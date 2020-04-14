package RendererTablas;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class ColumnGroup {
    protected TableCellRenderer renderer;
    protected Vector v;
    protected String text;
    protected int margin = 0;
    private Font bold = new Font("Comic Sans MS", Font.BOLD, 16);

    public ColumnGroup(String text) {
        this(null, text);
    }

    public ColumnGroup(TableCellRenderer renderer, String text) {
        if (renderer == null) {
            this.renderer = new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column) {
                    JTableHeader header = table.getTableHeader();
                    if (header != null) {                       
                        setForeground(Color.BLACK);    //color personalizado de la celda de la columna dividida                       
                        setBackground(new Color(245, 245, 239));  //fondo personalizado                       
                        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK)); //borde de division de celdas NEGRO                        
                    }else{
                       setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK)); //borde de division de celdas NEGRO  
                       setForeground(Color.BLACK);    //color personalizado de la celda de la columna dividida                                            
                       setBackground(new Color(245, 245, 239));  //fondo personalizado  
                    }
                    //setFont(new Font("Comic Sans MS", Font.PLAIN, 16));  //Fuente de la celda del rectangulo Temp %                    
                    setFont(bold);  //Fuente de la celda del rectangulo Temp %                    
                    setForeground(Color.BLACK);    //color personalizado de la celda de la columna dividida
                    setBackground(new Color(245, 245, 239));                      
                    setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, Color.BLACK)); //borde de division de celdas BLANCO                                      
                    setHorizontalAlignment(JLabel.CENTER);
                    setVerticalAlignment(JLabel.CENTER);//aqui cambie
                    setText((value == null) ? "" : value.toString());                    
                    return this;
                }
            };
        } else {            
            this.renderer = renderer;            
        }
        this.text = text;
        v = new Vector();
    }

    /**
     * @param obj TableColumn or ColumnGroup
     */
    public void add(Object obj) {
        if (obj == null) {
            return;
        }
        v.addElement(obj);
    }

    /**
     * @param c TableColumn
     * @param v ColumnGroups
     */
    public Vector getColumnGroups(TableColumn c, Vector g) {
        g.addElement(this);
        if (v.contains(c)) {
            return g;
        }
        Enumeration e = v.elements();
        while (e.hasMoreElements()) {
            Object obj = e.nextElement();
            if (obj instanceof ColumnGroup) {
                Vector groups = (Vector) ((ColumnGroup) obj).getColumnGroups(c,(Vector) g.clone());
                if (groups != null) {
                    return groups;
                }
            }
        }
        return null;
    }

    public TableCellRenderer getHeaderRenderer() {
        return renderer;
    }

    public void setHeaderRenderer(TableCellRenderer renderer) {
        if (renderer != null) {
            this.renderer = renderer;
        }
    }

    public Object getHeaderValue() {
        return text;
    }

    public Dimension getSize(JTable table) {
        //Component comp = renderer.getTableCellRendererComponent(table, getHeaderValue(), true, true, -1, 10);
        Component comp = renderer.getTableCellRendererComponent(table, getHeaderValue(), false, false, -1, -1);
        int height = comp.getPreferredSize().height;
        int width = 0;
        Enumeration e = v.elements();
        while (e.hasMoreElements()) {
            Object obj = e.nextElement();
            if (obj instanceof TableColumn) {
                TableColumn aColumn = (TableColumn) obj;
                width += aColumn.getWidth();
                width += margin;
            } else {
                width += ((ColumnGroup) obj).getSize(table).width;
            }
        }
        return new Dimension(width, height);
    }

    public void setColumnMargin(int margin) {
        this.margin = margin;
        Enumeration e = v.elements();
        while (e.hasMoreElements()) {
            Object obj = e.nextElement();
            if (obj instanceof ColumnGroup) {
                ((ColumnGroup) obj).setColumnMargin(margin);
            }
        }
    }
}
