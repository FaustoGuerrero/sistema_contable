package InterfacesGraficas;

import RendererTablas.ColumnGroup;
import RendererTablas.GroupableTableHeader;
import ConexionBD.ConsultaSqlDataIn;
import java.awt.Color;
import java.awt.Font;
import java.math.BigDecimal;
import java.text.MessageFormat;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class Table1 extends javax.swing.JDialog {

    JTable table;
    DefaultTableModel dm;

    public Table1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/spravka.png")).getImage());

        dm = new DefaultTableModel() {
            @Override
            public Class getColumnClass(int columnIndex) {
                return String.class;
            }
            //Sobreescribimos el metodo de si se puede editar los valores de una columna
            private final boolean[] tableColumns = {false, false, false, false, false, false};
            @Override
            public boolean isCellEditable(int row, int column) {
                //return super.isCellEditable(row, column); //con esta linea podemos permitir o bloquear una celda determinada
                return this.tableColumns[column];
            }
        };
        JLabel titulos[] = new JLabel[7];
        titulos[0] = new JLabel("<html><body><center>Показатель,<br>тыс.руб.</center></body></html>");
        titulos[1] = new JLabel("<html><body><center>За<br>2016 г.</center></body></html>");
        titulos[2] = new JLabel("<html><body><center>За<br>2017 г.</center></body></html>");
        titulos[3] = new JLabel("<html><body><center>За<br>2018 г.</center></body></html>");
        titulos[4] = new JLabel("<html><body><center>2017/2016</center></body></html>");
        titulos[5] = new JLabel("<html><body><center>2018/2017</center></body></html>");
        titulos[6] = new JLabel("<html><body><center>Темп роста, %</center></body></html>");

        JLabel columna0[] = new JLabel[17];
        columna0[0] = new JLabel("<html><body>Выручка от продаж</body></html>");
        columna0[1] = new JLabel("<html><body>Валовая прибыль</body></html>");
        columna0[2] = new JLabel("<html><body>Коммерческие расходы</body></html>");
        columna0[3] = new JLabel("<html><body>Управленческие расходы</body></html>");
        columna0[4] = new JLabel("<html><body>Прибыль от продаж</body></html>");
        columna0[5] = new JLabel("<html><body>Проценты к получению</body></html>");
        columna0[6] = new JLabel("<html><body>Проценты к уплате</body></html>");
        columna0[7] = new JLabel("<html><body>Доходы от участия в<br>других организациях</body></html>");
        columna0[8] = new JLabel("<html><body>Прочие доходы</body></html>");
        columna0[9] = new JLabel("<html><body>Прочие расходы</body></html>");
        columna0[10] = new JLabel("<html><body>Прибыль до<br>налогообложения</body></html>");
        columna0[11] = new JLabel("<html><body>Себестоимость проданной<br>продукции, работ, услуг</body></html>");
        columna0[12] = new JLabel("<html><body>Средняя стоимость активов</body></html>");
        columna0[13] = new JLabel("<html><body>Средняя стоимость<br>оборотных активов</body></html>");
        columna0[14] = new JLabel("<html><body>Средняя стоимость<br>собственного капитала</body></html>");
        columna0[15] = new JLabel("<html><body>Средняя стоимость<br>рабочего и продуктивного<br>скота</body></html>");
        columna0[16] = new JLabel("<html><body>Средняя стоимость<br>машин и оборудования</body></html>");

        String[] pokazateli = new String[]{"n02010", "n02029", "n02030", "n02040", "n02050", "n02060", "n02070", "n02080", "n02090", "n02100",
            "n02140", "n02020", "n01300", "n01290", "n01490", "n05102", "n05090"};

        ConsultaSqlDataIn tab = new ConsultaSqlDataIn();
        tab.llenarDatos(pokazateli, pokazateli.length, 3);

        Object[][] valores = new Object[columna0.length][columna0.length];
        for (int i = 0; i < valores.length; i++) {
            valores[i][0] = columna0[i].getText();
            valores[i][1] = tab.datos[i][0];
            valores[i][2] = tab.datos[i][1];
            valores[i][3] = tab.datos[i][2];
        }

        dm.setDataVector(valores,
                new Object[]{titulos[0].getText(), titulos[1].getText(), titulos[2].getText(), titulos[3].getText(), titulos[4].getText(), titulos[5].getText()});

        table = new JTable(dm) {
            @Override
            protected JTableHeader createDefaultTableHeader() {
                return new GroupableTableHeader(columnModel);
            }
        };

        TableColumnModel cm = table.getColumnModel();
        ColumnGroup g_lang = new ColumnGroup(titulos[6].getText());
        g_lang.add(cm.getColumn(4));
        g_lang.add(cm.getColumn(5));

        GroupableTableHeader header = (GroupableTableHeader) table.getTableHeader();
        header.addColumnGroup(g_lang);
        
//        MultiLineHeaderRenderer renderer = new MultiLineHeaderRenderer();
//        Enumeration enumerador = table.getColumnModel().getColumns();
//        while (enumerador.hasMoreElements()) {
//            ((TableColumn) enumerador.nextElement()).setHeaderRenderer(renderer);
//        }

        personalizarTabla();
        calcularCampos();
        JScrollPane scroll = new JScrollPane(table);
        getContentPane().add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 800, 720));// X   Y  ANCHO ALTO
    }

    private void printTable() {
        MessageFormat header = new MessageFormat("Показатели формирования финансовых результатов\n");
        MessageFormat footer = new MessageFormat("Страница {0}");
        try {
            table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (Exception e) {
        }
    }

    private void calcularCampos() {
        double division, division2;
        BigDecimal rounded;
        for (int i = 0; i < table.getRowCount(); i++) {
            try {
                division = Double.valueOf(table.getValueAt(i, 2).toString()) / Double.valueOf(table.getValueAt(i, 1).toString()) * 100;
                division2 = Double.valueOf(table.getValueAt(i, 3).toString()) / Double.valueOf(table.getValueAt(i, 2).toString()) * 100;
                rounded = new BigDecimal(division);
                rounded = rounded.setScale(2, BigDecimal.ROUND_HALF_UP);
                dm.setValueAt(rounded, i, 4);
                rounded = new BigDecimal(division2);
                rounded = rounded.setScale(2, BigDecimal.ROUND_HALF_UP);
                dm.setValueAt(rounded, i, 5);
            } catch (NumberFormatException e) {
                dm.setValueAt(0, i, 4);
                dm.setValueAt(0, i, 5);
            }
        }
    }

    private void personalizarTabla() {
        table.getColumnModel().getColumn(0).setPreferredWidth(155);
        for (int i = 1; i <= 5; i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(30);
        }

        for (int i = 0; i < table.getRowCount(); i++) {
            switch (i) {
                case 7:
                case 11:
                case 13:
                case 14:
                case 15:
                case 16:
                    table.setRowHeight(i, table.getRowHeight() * 3);
                    break;
                default:
                    table.setRowHeight(i, table.getRowHeight() * 2);
                    break;
            }
        }
        table.setFont(new Font("Tahoma", Font.PLAIN, 13));
        DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
        centrar.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(1).setCellRenderer(centrar);

        // Para alinear los datos de la tabla a la derecha//
        DefaultTableCellRenderer derecha = new DefaultTableCellRenderer();
        derecha.setHorizontalAlignment(SwingConstants.RIGHT);
        table.getColumnModel().getColumn(2).setCellRenderer(derecha);
        table.getColumnModel().getColumn(3).setCellRenderer(derecha);
        table.getColumnModel().getColumn(4).setCellRenderer(derecha);
        table.getColumnModel().getColumn(5).setCellRenderer(derecha);
//        table.getColumnModel().getColumn(6).setCellRenderer(derecha);
        table.setGridColor(Color.BLACK); //color de los bordes de cada celda
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Показатели формирования финансовых результатов");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 60));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        jButton2.setText("   В главное меню");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 830, 250, 70));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir2.png"))); // NOI18N
        jButton3.setText("   Сформировать отчёт");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 830, 250, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        printTable();
    }//GEN-LAST:event_jButton3MouseClicked

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Table1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Table1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Table1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Table1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Table1 dialog = new Table1(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
