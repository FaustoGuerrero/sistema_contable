
package InterfacesGraficas;

import javax.swing.ImageIcon;

public class PessVariant extends javax.swing.JDialog {

    public PessVariant(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/spravka.png")).getImage()); //para colocar un icono al programa
        String texto = "<html>\n"
                + " <body>\n"
                //width=\"500\" 
                + "   <table bgcolor=\"#F5F5EF\" border=\"1\" align=\"center\" \n"
                + "     cellpadding=\"4\" cellspacing=\"0\">\n"
                + "    <tr> \n"
                + "         <td colspan=\"2\" rowspan=\"2\" bgcolor=\"#fbffcc\"><center><b>Показатели</b></td>\n"
                + "         <td colspan=\"5\" bgcolor=\"#fbffcc\"><center><b>Год</b></td>\n"
                + "    </tr>\n"
                + "    <tr> \n"
                + "         <td bgcolor=\"#fbffcc\"><center><b>2014</b></td>\n"
                + "         <td bgcolor=\"#fbffcc\"><center><b>2015</b></td>\n"
                + "         <td bgcolor=\"#fbffcc\"><center><b>2016</b></td>\n"
                + "         <td bgcolor=\"#fbffcc\"><center><b>2017</b></td>\n"
                + "         <td bgcolor=\"#fbffcc\"><center><b>2018</b></td>\n"                
                + "    <tr> \n"                
                + "         <td colspan=\"7\"><center><b>Пессимистический вариант</b></center></td>\n"
                + "    </tr>\n"
                + "    <tr> \n"                
                + "         <td rowspan=\"2\"><center>Оценка прибыли<br>(убытка) от<br>реализации с.-х.<br>продукции на 1 руб.<br>вложений, руб.</td>\n"
                + "         <td><center>Минимальное значение</td>\n"
                + "         <td><center>-0,0843</td>\n"
                + "         <td><center>-0,0411</td>\n"
                + "         <td><center>-0,0492</td>\n"
                + "         <td><center>-0,1242</td>\n"
                + "         <td><center>-0,1695</td>\n"                
                + "    <tr> \n"                                                
                + "         <td><center>Максимальное значение</td>\n"
                + "         <td><center>-0,0570</td>\n"
                + "         <td><center>-0,02781</td>\n"
                + "         <td><center>-0,0333</td>\n"
                + "         <td><center>-0,0840</td>\n"
                + "         <td><center>-0,1147</td>\n"  
                + "    </tr>\n"
                + "    <tr> \n"                
                + "    <td colspan=\"2\"><center>Уровень возможных потерь в<br>условиях неопределённости,<br>руб. на 1 руб. вложений</td>\n"
                + "         <td><center>-0,0273</td>\n"
                + "         <td><center>-0,0133</td>\n"
                + "         <td><center>-0,0159</td>\n"
                + "         <td><center>-0,0402</td>\n"
                + "         <td><center>-0,0549</td>\n"
                + "    </tr>\n"
                + "    <td colspan=\"2\"><center>Оценка вложений на 100 га<br>сельскохозяйственных угодий,<br>тыс. руб.</td>\n"
                + "         <td><center>1377,16</td>\n"
                + "         <td><center>1419,93</td>\n"
                + "         <td><center>1411,56</td>\n"
                + "         <td><center>1341,29</td>\n"
                + "         <td><center>1303,29</td>\n"
                + "    </tr>\n"
                + "   </table>\n"
                + " </body>\n"
                + "</html>";
        jLabel1.setText(texto);
        Spravka spravka = new Spravka(null, false);
        jLabel4.setText(spravka.texto);
        this.setLocationRelativeTo(null);        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 810, 390));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Коэффициент возможных потерь");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 510, 920, 40));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        jButton2.setText("   НАЗАД");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 800, 250, 70));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Для пессимистического варианта");
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 60));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, 690, 260));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Равномерность распределения пессимистического варианта оценки составляет 42,7%");
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 440, 930, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
     this.dispose();
  OtsenkaEffektivnost otsenka = new OtsenkaEffektivnost(null, true);
     otsenka.setVisible(true);
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PessVariant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PessVariant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PessVariant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PessVariant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PessVariant dialog = new PessVariant(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
