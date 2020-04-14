package InterfacesGraficas;

import com.sun.awt.AWTUtilities;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.tools.Tool;

public class Menu extends javax.swing.JFrame {

    public Menu() {
        initComponents();   
        this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/estudiante+.png")).getImage()); //para colocar un icono al programa        
        ImageIcon imagen = new ImageIcon(getClass().getResource("/fondos/montanaNieve.jpg"));
        Icon fondo = new ImageIcon(imagen.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
        jLabel1.setIcon(fondo);
        
        //this.setState(JFrame.MAXIMIZED_BOTH);
        try {
            ConexionBD.ConBD con = new ConexionBD.ConBD();
            con.getConection();
            java.util.Date date = new java.util.Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String fecha = sdf.format(date);
            jBasa.setText("ПОДКЛЮЧЕН К БАЗЕ ДАННЫХ");
            jHora.setText(fecha);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ошибка при подключении, проверьте данные!" + ex, "ВНИМАНИЕ", JOptionPane.ERROR_MESSAGE);
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        System.out.println("Resolucion de pantalla " + width + "  " + height);
        setSize((int) width-10, (int) height-50);
       // repaint();
       Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 70, 70); //para redondear la ventana        
        AWTUtilities.setWindowShape(this, forma);
        this.setLocationRelativeTo(null);
        
    }

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBasa = new javax.swing.JLabel();
        jHora = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jModDataIn = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jAcerca = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("СИСТЕМА");
        setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagenes/contabilidad.png")).getImage());
        setLocation(new java.awt.Point(500, 200));
        setUndecorated(true);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Оценка эффективности деятельности организации");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 668;
        gridBagConstraints.ipady = 713;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 2);
        getContentPane().add(jLabel2, gridBagConstraints);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fondos/fondoceleste.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = -2206;
        gridBagConstraints.ipady = -3316;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jLabel1, gridBagConstraints);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jBasa.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jBasa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jBasa.setToolTipText("");
        jBasa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jHora.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jHora.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jBasa, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jHora, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBasa, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                    .addComponent(jHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 480;
        gridBagConstraints.ipady = 38;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 100, 2, 0);
        getContentPane().add(jPanel1, gridBagConstraints);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.setMargin(new java.awt.Insets(30, 0, 20, 0));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(885, 70));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Nuevo1.png"))); // NOI18N
        jMenu1.setText("Загрузка данных");
        jMenu1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jMenu1.setMargin(new java.awt.Insets(30, 45, 30, 20));

        jModDataIn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jModDataIn.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jModDataIn.setText("Модифировать исходные данные");
        jModDataIn.setMargin(new java.awt.Insets(0, 15, 0, 0));
        jModDataIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jModDataInActionPerformed(evt);
            }
        });
        jMenu1.add(jModDataIn);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estadistica.png"))); // NOI18N
        jMenu2.setText("Анализ данных  ");
        jMenu2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jMenu2.setMargin(new java.awt.Insets(30, 45, 30, 20));

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jMenuItem6.setText("Показатели формирования финансовых результатов");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jMenuItem7.setText("Обобщающие показатели экономической эффективности организации");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jMenuItem8.setText("Показатели экономической эффективности использования активов");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jMenuItem1.setText("Показатели экономической эффективности использования капитала");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jMenuItem2.setText("Специфические отраслевые показатели экономической эффективности");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jMenuItem3.setText("Детерминированный факторный анализ экономической эффективности");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem14.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jMenuItem14.setText("Оценка эффективности основной деятельности в условиях неопределённости");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem14);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/upload.png"))); // NOI18N
        jMenu3.setText("Выгрузка данных");
        jMenu3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jMenu3.setMargin(new java.awt.Insets(30, 45, 30, 20));
        jMenuBar1.add(jMenu3);

        jAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/spravka.png"))); // NOI18N
        jAcerca.setText("Справка");
        jAcerca.setToolTipText("");
        jAcerca.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jAcerca.setMargin(new java.awt.Insets(30, 55, 30, 30));
        jAcerca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAcercaMouseClicked(evt);
            }
        });
        jMenuBar1.add(jAcerca);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnSalir.png"))); // NOI18N
        jMenu4.setText("Выход");
        jMenu4.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jMenu4.setMargin(new java.awt.Insets(30, 55, 30, 30));
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/minimiza.png"))); // NOI18N
        jMenu5.setToolTipText("Свернуть");
        jMenu5.setMargin(new java.awt.Insets(30, 376, 30, 20));
        jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu5MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        getAccessibleContext().setAccessibleName("                                                                                  SISTEMA - PROGRAMA EUROPEO DE EXCELENCIA");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jModDataInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jModDataInActionPerformed
        ModifDataIn ws = new ModifDataIn(Menu.this, true);
        ws.setVisible(true);

    }//GEN-LAST:event_jModDataInActionPerformed

    private void jAcercaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAcercaMouseClicked
        Spravka ws = new Spravka(Menu.this, true);
        ws.setVisible(true);
    }//GEN-LAST:event_jAcercaMouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Table1 ws = new Table1(Menu.this, true);
        ws.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Table4 ws = new Table4(Menu.this, true);
        ws.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Table3 ws = new Table3(Menu.this, true);
        ws.setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        Table2 ws = new Table2(Menu.this, true);
        ws.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        OtsenkaEffektivnost ws = new OtsenkaEffektivnost(null, true);
        ws.setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Table5 ws = new Table5(Menu.this, true);
        ws.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Table6 ws = new Table6(Menu.this, true);
        ws.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        this.setState(JFrame.ICONIFIED); //Para minimizar la ventana
    }//GEN-LAST:event_jMenu5MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JMenu jAcerca;
    public javax.swing.JLabel jBasa;
    public javax.swing.JLabel jHora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jModDataIn;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
