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

public class Table5 extends javax.swing.JDialog {

    JTable table;
    DefaultTableModel dm;

    public Table5(java.awt.Frame parent, boolean modal) {
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
        titulos[4] = new JLabel("<html><body><center>2017-2016</center></body></html>");
        titulos[5] = new JLabel("<html><body><center>2018-2017</center></body></html>");
        titulos[6] = new JLabel("<html><body><center>Абс. отклонение (+,-)</center></body></html>");

        JLabel columna0[] = new JLabel[6];
        columna0[0] = new JLabel("<html><body>Себестоимость продукции <br>растениеводства</body></html>");
        columna0[1] = new JLabel("<html><body>Себестоимость продукции <br>животноводства</body></html>");
        columna0[2] = new JLabel("<html><body>Затраты на основное <br>производство</body></html>");
        columna0[4] = new JLabel("<html><body>Рентабельность продукции<br>растениеводства</body></html>");
        columna0[3] = new JLabel("<html><body>Рентабельность продукции<br>животноводства Pпр.жив.</body></html>");
        columna0[5] = new JLabel("<html><body>Рентабельность затрат на <br>основное производство<br>Pосн.пр.</body></html>");        

        String[] pokazateli = new String[]{"n09990", "n09750", "n08600", "n02050"};
        ConsultaSqlDataIn tab = new ConsultaSqlDataIn();
        tab.llenarDatos(pokazateli, pokazateli.length, 3);

        Object[][] valores = new Object[columna0.length][columna0.length];
        for (int i = 0; i < valores.length; i++) {
            if (i < 3) {
                valores[i][0] = columna0[i].getText();
                valores[i][1] = tab.datos[i][0];
                valores[i][2] = tab.datos[i][1];
                valores[i][3] = tab.datos[i][2];
            } else {
                valores[i][0] = columna0[i].getText();
            }
        }

        BigDecimal rounded;
        double division;
        //Рентабельности
        for (int j = 1; j < 4; j++) {
            division = tab.datos[3][j-1] / Double.valueOf(valores[1][j].toString());
            rounded = new BigDecimal(division);
            rounded = rounded.setScale(2, BigDecimal.ROUND_HALF_UP);
            valores[3][j] = rounded;
            
            division = tab.datos[3][j-1] / Double.valueOf(valores[0][j].toString());
            rounded = new BigDecimal(division);
            rounded = rounded.setScale(2, BigDecimal.ROUND_HALF_UP);
            valores[4][j] = rounded;
            
            division = tab.datos[3][j-1] / Double.valueOf(valores[2][j].toString());
            rounded = new BigDecimal(division);
            rounded = rounded.setScale(2, BigDecimal.ROUND_HALF_UP);
            valores[5][j] = rounded;            
        }

        dm.setDataVector(valores, new Object[]{titulos[0].getText(), titulos[1].getText(), titulos[2].getText(), titulos[3].getText(), titulos[4].getText(), titulos[5].getText()});
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

        personalizarTabla();
        calcularCampos();
        JScrollPane scroll = new JScrollPane(table);
        getContentPane().add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 800, 400));// X   Y  ANCHO ALTO
    }

    private void printTable() {
        MessageFormat header = new MessageFormat("Специфические отраслевые показатели экономической эффективности\n");
        MessageFormat footer = new MessageFormat("Страница {0}");
        try {
            table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (Exception e) {
        }
    }

    private void calcularCampos() {
        double resta, resta2;
        BigDecimal rounded;
        for (int i = 0; i < table.getRowCount(); i++) {
            try {
                resta = Double.valueOf(table.getValueAt(i, 2).toString()) - Double.valueOf(table.getValueAt(i, 1).toString());
                resta2 = Double.valueOf(table.getValueAt(i, 3).toString()) - Double.valueOf(table.getValueAt(i, 2).toString());
                rounded = new BigDecimal(resta);
                rounded = rounded.setScale(2, BigDecimal.ROUND_HALF_UP);
                dm.setValueAt(rounded, i, 4);
                rounded = new BigDecimal(resta2);
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
                case 5:
                    table.setRowHeight(i, table.getRowHeight() * 4);
                    break;
                default:
                    table.setRowHeight(i, table.getRowHeight() * 3);
                    break;
            }
        }
        table.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Специфические отраслевые показатели экономической эффективности");
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
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 490, 250, 70));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir2.png"))); // NOI18N
        jButton3.setText("   Сформировать отчёт");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 250, 70));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, 80, 20));

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
            java.util.logging.Logger.getLogger(Table5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Table5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Table5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Table5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
      
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Table5 dialog = new Table5(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
