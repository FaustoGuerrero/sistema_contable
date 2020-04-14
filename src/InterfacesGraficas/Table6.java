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

public class Table6 extends javax.swing.JDialog {

    BigDecimal[] Arrayredondeos;
    int contArray = 0;
    JTable table, tableTotal;
    DefaultTableModel dm, modeloTotal;

    public Table6(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/spravka.png")).getImage());
        Arrayredondeos = new BigDecimal[20];

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

        JLabel columna0[] = new JLabel[14];
        columna0[0] = new JLabel("<html><body>Выручка от продаж</body></html>");
        columna0[1] = new JLabel("<html><body>Себестоимость проданной<br>продукции, работ, услуг</body></html>");
        columna0[2] = new JLabel("<html><body>Коммерческие расходы</body></html>");
        columna0[3] = new JLabel("<html><body>Управленческие расходы</body></html>");
        columna0[4] = new JLabel("<html><body>Чистая прибыль</body></html>");
        columna0[5] = new JLabel("<html><body>Средняя стоимость активов</body></html>");
        columna0[6] = new JLabel("<html><body>Средняя стоимость собственного <br>капитала, тыс.руб.</body></html>");
        columna0[7] = new JLabel("<html><body>Чистая рентабельность</body></html>");
        columna0[8] = new JLabel("<html><body>Рентабельность продаж, <br>Pпродаж.</body></html>");
        columna0[9] = new JLabel("<html><body>Рентабельность продукции,<br>Pпродукции</body></html>");
        columna0[10] = new JLabel("<html><body>Рентабельность активов, Pа</body></html>");
        columna0[11] = new JLabel("<html><body>Рентабельность оборотных <br>активов, Pоа</body></html>");
        columna0[12] = new JLabel("<html><body>Рентабельность машин и<br>оборудования, Pмо</body></html>");
        columna0[13] = new JLabel("<html><body>Рентабельность собственного <br>капитала Pск.</body></html>");

        String[] pokazateli = new String[]{"n02010", "n02020", "n02030", "n02040", "n02190", "n01300", "n01490", "n02050", "n01290", "n05090"};
        ConsultaSqlDataIn tab = new ConsultaSqlDataIn();
        tab.llenarDatos(pokazateli, pokazateli.length, 3);

        Object[][] valores = new Object[columna0.length][columna0.length];
        for (int i = 0; i < valores.length; i++) {
            if (i < 7) {
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
            division = Double.valueOf(valores[4][j].toString()) / Double.valueOf(valores[0][j].toString());
            rounded = new BigDecimal(division);
            rounded = rounded.setScale(2, BigDecimal.ROUND_HALF_UP);
            valores[7][j] = rounded;

            division = tab.datos[7][j - 1] / Double.valueOf(valores[0][j].toString());
            rounded = new BigDecimal(division);
            rounded = rounded.setScale(2, BigDecimal.ROUND_HALF_UP);
            valores[8][j] = rounded;

            division = tab.datos[7][j - 1] / (Double.valueOf(valores[1][j].toString()) + Double.valueOf(valores[2][j].toString()) + Double.valueOf(valores[3][j].toString()));
            rounded = new BigDecimal(division);
            rounded = rounded.setScale(2, BigDecimal.ROUND_HALF_UP);
            valores[9][j] = rounded;

            division = Double.valueOf(valores[4][j].toString()) / Double.valueOf(valores[5][j].toString());
            rounded = new BigDecimal(division);
            rounded = rounded.setScale(2, BigDecimal.ROUND_HALF_UP);
            valores[10][j] = rounded;

            division = Double.valueOf(valores[4][j].toString()) / tab.datos[8][j - 1];
            rounded = new BigDecimal(division);
            rounded = rounded.setScale(2, BigDecimal.ROUND_HALF_UP);
            valores[11][j] = rounded;

            division = Double.valueOf(valores[4][j].toString()) / tab.datos[9][j - 1];
            rounded = new BigDecimal(division);
            rounded = rounded.setScale(2, BigDecimal.ROUND_HALF_UP);
            valores[12][j] = rounded;

            division = Double.valueOf(valores[4][j].toString()) / Double.valueOf(valores[6][j].toString());
            rounded = new BigDecimal(division);
            rounded = rounded.setScale(2, BigDecimal.ROUND_HALF_UP);
            valores[13][j] = rounded;
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
        getContentPane().add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 800, 650));// X   Y  ANCHO ALTO

        //TABLA TOTAL
        modeloTotal = new DefaultTableModel() {
            @Override
            public Class getColumnClass(int columnIndex) {
                return String.class;
            }
            //Sobreescribimos el metodo de si se puede editar los valores de una columna
            private final boolean[] tableColumns = {false, false, false};

            @Override
            public boolean isCellEditable(int row, int column) {
                //return super.isCellEditable(row, column); //con esta linea podemos permitir o bloquear una celda determinada
                return this.tableColumns[column];
            }
        };
        JLabel titulosTabla2[] = new JLabel[3];
        titulosTabla2[0] = new JLabel("<html><body><center>Показатель степени<br>влияния фактора<br>тыс.руб.</center></body></html>");
        titulosTabla2[1] = new JLabel("<html><body><center>В 2017 г.</center></body></html>");
        titulosTabla2[2] = new JLabel("<html><body><center>В 2018 г.</center></body></html>");
        JLabel col0[] = new JLabel[10];
        col0[0] = new JLabel("<html><body>&#x25b3 Pпродаж В</body></html>");
        col0[1] = new JLabel("<html><body>&#x25b3 Pпродаж C</body></html>");
        col0[2] = new JLabel("<html><body>&#x25b3 Pпродаж КР</body></html>");
        col0[3] = new JLabel("<html><body>&#x25b3 Pпродаж УP</body></html>");
        col0[4] = new JLabel("<html><body><b>&#x25b3 Рентабельность<br>продаж Pпродаж<b></body></html>");
        col0[5] = new JLabel("");
        col0[6] = new JLabel("");
        col0[7] = new JLabel("");
        col0[8] = new JLabel("");
        col0[9] = new JLabel("");
        modeloTotal.setDataVector(new Object[][]{
            {col0[0].getText(), 0, 0},
            {col0[1].getText(), 0, 0},
            {col0[2].getText(), 0, 0},
            {col0[3].getText(), 0, 0},
            {col0[4].getText(), 0, 0},
            {col0[5].getText(), 0, 0},
            {col0[6].getText(), 0, 0},
            {col0[7].getText(), 0, 0},
            {col0[8].getText(), 0, 0},
            {col0[9].getText(), 0, 0},}, new Object[]{titulosTabla2[0].getText(), titulosTabla2[1].getText(), titulosTabla2[2].getText()});

        tableTotal = new JTable(modeloTotal) {
            @Override
            protected JTableHeader createDefaultTableHeader() {
                return new GroupableTableHeader(columnModel);
            }
        };
        tableTotal.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableTotal.getColumnModel().getColumn(1).setPreferredWidth(20);
        tableTotal.getColumnModel().getColumn(2).setPreferredWidth(20);
        for (int i = 0; i < table.getRowCount(); i++) {
            tableTotal.setRowHeight(i, tableTotal.getRowHeight() * 2);
        }
        tableTotal.setRowHeight(4, tableTotal.getRowHeight() * 3);
        tableTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
        DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
        centrar.setHorizontalAlignment(SwingConstants.CENTER);
        tableTotal.getColumnModel().getColumn(1).setCellRenderer(centrar);
        tableTotal.getColumnModel().getColumn(2).setCellRenderer(centrar);

        // Para alinear los datos de la tabla a la derecha//
        DefaultTableCellRenderer derecha = new DefaultTableCellRenderer();
        derecha.setHorizontalAlignment(SwingConstants.LEFT);
        tableTotal.getColumnModel().getColumn(0).setCellRenderer(derecha);
        tableTotal.setGridColor(Color.BLACK); //color de los bordes de cada celda
        calcularDatosTable2();
        //agregamos la tabla al scroll y le damos las coordenadas donde estara ubicada en la pantalla
        JScrollPane scroll2 = new JScrollPane(tableTotal);
        getContentPane().add(scroll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 200, 400, 250));// X   Y  ANCHO ALTO
    }

    private void calcularDatosTable2() {
        //Оценка влияния факторов в 2017 г
        double Prodash2016, Pusl1, Pusl2, Pusl3, Prodash2017;
        Prodash2016 = (Double.valueOf(table.getValueAt(0, 1).toString())
                - Double.valueOf(table.getValueAt(1, 1).toString())
                - Double.valueOf(table.getValueAt(2, 1).toString())
                - Double.valueOf(table.getValueAt(3, 1).toString())) / Double.valueOf(table.getValueAt(0, 1).toString());

        Pusl1 = (Double.valueOf(table.getValueAt(0, 2).toString())
                - Double.valueOf(table.getValueAt(1, 1).toString())
                - Double.valueOf(table.getValueAt(2, 1).toString())
                - Double.valueOf(table.getValueAt(3, 1).toString())) / Double.valueOf(table.getValueAt(0, 2).toString());

        Pusl2 = (Double.valueOf(table.getValueAt(0, 2).toString())
                - Double.valueOf(table.getValueAt(1, 2).toString())
                - Double.valueOf(table.getValueAt(2, 1).toString())
                - Double.valueOf(table.getValueAt(3, 1).toString())) / Double.valueOf(table.getValueAt(0, 2).toString());

        Pusl3 = (Double.valueOf(table.getValueAt(0, 2).toString())
                - Double.valueOf(table.getValueAt(1, 2).toString())
                - Double.valueOf(table.getValueAt(2, 2).toString())
                - Double.valueOf(table.getValueAt(3, 1).toString())) / Double.valueOf(table.getValueAt(0, 2).toString());

        Prodash2017 = (Double.valueOf(table.getValueAt(0, 2).toString())
                - Double.valueOf(table.getValueAt(1, 2).toString())
                - Double.valueOf(table.getValueAt(2, 2).toString())
                - Double.valueOf(table.getValueAt(3, 2).toString())) / Double.valueOf(table.getValueAt(0, 2).toString());

        //Влияние выручки на изменение рентабельности продаж
        double ProdashB = Pusl1 - Prodash2016;
        tableTotal.setValueAt(redondeo(ProdashB), 0, 1);

        //Влияние себестоимости на изменение рентабельности продаж
        double ProdashC = Pusl2 - Pusl1;
        tableTotal.setValueAt(redondeo(ProdashC), 1, 1);

        //Влияние коммерческих расходов на изменение рентабельности продаж
        double ProdashKP = Pusl3 - Pusl2;
        tableTotal.setValueAt(redondeo(ProdashKP), 2, 1);

        //Влияние управленческих расходов на изменение рентабельности продаж
        double ProdashYP = Prodash2017 - Pusl3;
        tableTotal.setValueAt(redondeo(ProdashYP), 3, 1);

        //Совокупное влияние факторов составит
        double TotalProdash2017 = ProdashB + ProdashC + ProdashKP + ProdashYP;
        String total = "<html><body><b>" + redondeo(TotalProdash2017) + "<b></body></html>";
        tableTotal.setValueAt(total, 4, 1);

        //Оценка влияния факторов в 2018 г
        Prodash2017 = (Double.valueOf(table.getValueAt(0, 2).toString())
                - Double.valueOf(table.getValueAt(1, 2).toString())
                - Double.valueOf(table.getValueAt(2, 2).toString())
                - Double.valueOf(table.getValueAt(3, 2).toString())) / Double.valueOf(table.getValueAt(0, 2).toString());

        Pusl1 = (Double.valueOf(table.getValueAt(0, 3).toString())
                - Double.valueOf(table.getValueAt(1, 2).toString())
                - Double.valueOf(table.getValueAt(2, 2).toString())
                - Double.valueOf(table.getValueAt(3, 2).toString())) / Double.valueOf(table.getValueAt(0, 3).toString());

        Pusl2 = (Double.valueOf(table.getValueAt(0, 3).toString())
                - Double.valueOf(table.getValueAt(1, 3).toString())
                - Double.valueOf(table.getValueAt(2, 2).toString())
                - Double.valueOf(table.getValueAt(3, 2).toString())) / Double.valueOf(table.getValueAt(0, 3).toString());

        Pusl3 = (Double.valueOf(table.getValueAt(0, 3).toString())
                - Double.valueOf(table.getValueAt(1, 3).toString())
                - Double.valueOf(table.getValueAt(2, 3).toString())
                - Double.valueOf(table.getValueAt(3, 3).toString())) / Double.valueOf(table.getValueAt(0, 3).toString());

        double Prodash2018 = (Double.valueOf(table.getValueAt(0, 3).toString())
                - Double.valueOf(table.getValueAt(1, 3).toString())
                - Double.valueOf(table.getValueAt(2, 3).toString())
                - Double.valueOf(table.getValueAt(3, 3).toString())) / Double.valueOf(table.getValueAt(0, 3).toString());

        //Влияние выручки на изменение рентабельности продаж
        ProdashB = Pusl1 - Prodash2017;
        tableTotal.setValueAt(redondeo(ProdashB), 0, 2);

        //Влияние себестоимости на изменение рентабельности продаж
        ProdashC = Pusl2 - Pusl1;
        tableTotal.setValueAt(redondeo(ProdashC), 1, 2);

        //Влияние коммерческих расходов на изменение рентабельности продаж
        ProdashKP = Pusl3 - Pusl2;
        tableTotal.setValueAt(redondeo(ProdashKP), 2, 2);

        //Влияние управленческих расходов на изменение рентабельности продаж
        ProdashYP = Prodash2018 - Pusl3;
        tableTotal.setValueAt(redondeo(ProdashYP), 3, 2);

        //Совокупное влияние факторов составит
        double TotalProdash2018 = ProdashB + ProdashC + ProdashKP + ProdashYP;
        total = "<html><body><b>" + redondeo(TotalProdash2018) + "<b></body></html>";
        tableTotal.setValueAt(total, 4, 2);

    }

    private Object redondeo(double ProdashB) {
        BigDecimal rounded;
        rounded = new BigDecimal(ProdashB);
        rounded = rounded.setScale(3, BigDecimal.ROUND_HALF_UP);
        return rounded;
    }

    private void printTable() {
        MessageFormat header = new MessageFormat("Детерминированный факторный анализ экономической эффективности\n");
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
                case 1:
                case 6:
                case 8:
                case 9:
                case 11:
                case 12:
                case 13:
                    table.setRowHeight(i, table.getRowHeight() * 3);
                    break;
                default:
                    table.setRowHeight(i, table.getRowHeight() * 2);
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
        jLabel2.setText("Детерминированный факторный анализ экономической эффективности");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1290, 60));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        jButton2.setText("   В главное меню");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 730, 250, 70));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imprimir2.png"))); // NOI18N
        jButton3.setText("   Сформировать отчёт");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 730, 250, 70));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 810, 80, 20));

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
            java.util.logging.Logger.getLogger(Table6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Table6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Table6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Table6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Table6 dialog = new Table6(new javax.swing.JFrame(), true);
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
