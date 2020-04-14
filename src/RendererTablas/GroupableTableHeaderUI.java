package RendererTablas;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.plaf.basic.*;

public class GroupableTableHeaderUI extends BasicTableHeaderUI {
    private Font fuente = new Font("Comic Sans MS", Font.BOLD, 16);
    @Override
    public void paint(Graphics g, JComponent c) {
        Rectangle clipBounds = g.getClipBounds();
        if (header.getColumnModel() == null) {
            return;
        }
        ((GroupableTableHeader) header).setColumnMargin();
        int column = 0;
        Dimension size = header.getSize();
        Rectangle cellRect = new Rectangle(0, 0, size.width, size.height);
        Hashtable h = new Hashtable();        

        Enumeration enumeration = header.getColumnModel().getColumns();
        while (enumeration.hasMoreElements()) {
            cellRect.height = size.height;
            cellRect.y = 0;
            TableColumn aColumn = (TableColumn) enumeration.nextElement();
            Enumeration cGroups = ((GroupableTableHeader) header).getColumnGroups(aColumn);
            if (cGroups != null) {
                int groupHeight = 0;
                while (cGroups.hasMoreElements()) {
                    ColumnGroup cGroup = (ColumnGroup) cGroups.nextElement();
                    Rectangle groupRect = (Rectangle) h.get(cGroup);
                    if (groupRect == null) {
                        groupRect = new Rectangle(cellRect);
                        Dimension d = cGroup.getSize(header.getTable());
                        groupRect.width = d.width;
                        groupRect.height = d.height+10;     // aqui le damos mas altura al rectangulo de la celda subdividida
                        h.put(cGroup, groupRect);
                    }
                    paintCell(g, groupRect, cGroup);
                    groupHeight += groupRect.height;
                    cellRect.height = size.height - groupHeight;
                    cellRect.y = groupHeight;
                }
            }
            // cellRect.width = aColumn.getWidth() + columnMargin;//aqui esta agregando mas ancho a la columna 
            cellRect.width = aColumn.getWidth();
            if (cellRect.intersects(clipBounds)) {
                paintCell(g, cellRect, column);
            }
            cellRect.x += cellRect.width;
            column++;
        }
    }

    private void paintCell(Graphics g, Rectangle cellRect, int columnIndex) {
        TableColumn aColumn = header.getColumnModel().getColumn(columnIndex);
        TableCellRenderer renderer = aColumn.getHeaderRenderer();
        renderer = new DefaultTableCellRenderer() {
            // Esta parte es la que centra el titulo
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel header = new JLabel();
                header.setForeground(Color.BLACK);
                header.setOpaque(true);
                //header.setBackground(Color.RED);
                header.setBackground(new Color(245, 245, 239));
                header.setFont(fuente); //tamaño de letra del encabezado menos de la subdividida
                header.setHorizontalAlignment(JLabel.CENTER);
                header.setText(value.toString());
                header.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK)); //color del borde de todas las celdas del encabezado menos de la dividida(rectangulo)
                return header;
            }
       };

        Component component = renderer.getTableCellRendererComponent(header.getTable(), aColumn.getHeaderValue(), false, false, -1, columnIndex);
        //component.setBackground(Color.CYAN); //color de fondo de las celdas del encabezado     
        rendererPane.add(component);
        rendererPane.paintComponent(g, component, header, cellRect.x, cellRect.y, cellRect.width, cellRect.height, true);
    }

    private void paintCell(Graphics g, Rectangle cellRect, ColumnGroup cGroup) {
        TableCellRenderer renderer = cGroup.getHeaderRenderer();
        Component component = renderer.getTableCellRendererComponent(header.getTable(), cGroup.getHeaderValue(), false, false, -1, -1);
        rendererPane.add(component);
        rendererPane.paintComponent(g, component, header, cellRect.x, cellRect.y, cellRect.width, cellRect.height, true);
    }

    private int getHeaderHeight() {
        int height = 80;    // altura del encabezado
        TableColumnModel columnModel = header.getColumnModel();
        for (int column = 0; column < columnModel.getColumnCount(); column++) {
            TableColumn aColumn = columnModel.getColumn(column);
            TableCellRenderer renderer = aColumn.getHeaderRenderer();
            //esta linea tambien es nueva
            if (renderer == null) {
                return 80;
            }
            Component comp = renderer.getTableCellRendererComponent(header.getTable(), aColumn.getHeaderValue(), false, false, -1, column);
            int cHeight = comp.getPreferredSize().height;
            Enumeration enumerador = ((GroupableTableHeader) header).getColumnGroups(aColumn);
            if (enumerador != null) {
                while (enumerador.hasMoreElements()) {
                    ColumnGroup cGroup = (ColumnGroup) enumerador.nextElement();
                    cHeight += cGroup.getSize(header.getTable()).height;
                }
            }
            height = Math.max(height, cHeight);
        }
        return height;
    }

    private Dimension createHeaderSize(long width) {
        TableColumnModel columnModel = header.getColumnModel();
        width += columnModel.getColumnMargin() * columnModel.getColumnCount();
        if (width > Integer.MAX_VALUE) {
            width = Integer.MAX_VALUE;
        }
        return new Dimension((int) width, getHeaderHeight());
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        long width = 0;
        Enumeration enumeration = header.getColumnModel().getColumns();
        while (enumeration.hasMoreElements()) {
            TableColumn aColumn = (TableColumn) enumeration.nextElement();
            width = width + aColumn.getPreferredWidth();
        }
        return createHeaderSize(width);
    }
}
