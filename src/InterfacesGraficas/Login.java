package InterfacesGraficas;

import com.sun.awt.AWTUtilities;
import java.awt.Shape;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import ConexionBD.ConBD;
import com.mysql.jdbc.PreparedStatement;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    VentanaError ventana;
    SplashBienvenida mensaje;
    int errores = 3;

    public Login() {
        initComponents();         
        super.setIconImage(new ImageIcon(getClass().getResource("/imagenes/estudiante+.png")).getImage());
       // this.setIconImage(new ImageIcon(getClass().getResource("/imagenes/estudiante+.png")).getImage()); //para colocar un icono al programa
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        this.setLocationRelativeTo(null); //para centrar el formulario          
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 100, 100); //para redondear la ventana        
        AWTUtilities.setWindowShape(this, forma);
    }

    @Override
    public void setIconImage(Image image) {
        setIconImage(image); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextPwd = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("ПОЛЬЗОВАТЕЛЬ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        jTextUsuario.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jTextUsuario.setToolTipText("Введите имя пользователя");
        jTextUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextUsuarioKeyPressed(evt);
            }
        });
        getContentPane().add(jTextUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 146, 34));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("ПАРОЛЬ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pasos.png"))); // NOI18N
        jButton1.setText("ВОЙТИ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/btnSalir.png"))); // NOI18N
        jButton2.setText("ВЫЙТИ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 146, 70));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 204, 204));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("АВТОРИЗАЦИЯ");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/close.png"))); // NOI18N
        jLabel4.setToolTipText("Закрыть программу");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/minimiza.png"))); // NOI18N
        jLabel5.setToolTipText("Свернуть");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addGap(46, 46, 46)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("*");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 34, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("*");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 34, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/inicio.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 290, 290));

        jTextPwd.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jTextPwd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextPwdKeyPressed(evt);
            }
        });
        getContentPane().add(jTextPwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 150, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int contador = 0;
        String texto;
        ventana = new VentanaError(this, true);

        if (jTextUsuario.getText().isEmpty() && jTextPwd.getText().isEmpty()) {
            contador++;
            texto = "Все данные необходимы!";
            ventana.jLabelError.setText(texto);
            ventana.setVisible(true);
            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
            jTextUsuario.requestFocus();
        } else if (jTextUsuario.getText().isEmpty()) {
            contador++;
            texto = "<html><body><center>Поле Пользователь<br>нельзя оставлять пустое!!!</center></body></html>";
            ventana.jLabelError.setText(texto);
            ventana.setVisible(true);
            jLabel6.setVisible(true);
            jLabel7.setVisible(false);
            jTextUsuario.requestFocus();
        } else if (jTextPwd.getText().isEmpty()) {
            contador++;
            texto = "<html><body><center>Поле Пароль<br>нельзя оставлять пустое!!!</center></body></html>";
            ventana.jLabelError.setText(texto);
            ventana.setVisible(true);
            jLabel6.setVisible(false);
            jLabel7.setVisible(true);
            jTextPwd.requestFocus();
        } else if (contador == 0) {
            try {
                Connection con = null;
                con = new ConBD().getConection();
                PreparedStatement st;
                ResultSet rs;
                st = (PreparedStatement) con.prepareStatement("SELECT * FROM login;");
                rs = st.executeQuery();
                while (rs.next()) {
                    if (rs.getString(1).equals(jTextUsuario.getText()) && rs.getString(2).equals(jTextPwd.getText())) {
                        mensaje = new SplashBienvenida(this, true);
                        this.dispose();
                        mensaje.setVisible(true);
                        //con.close();
                        break;
                    } else {
                        errores--;
                        if (errores == 0) {
                            texto = "<html><body><center>Ваши попытки закончились<br>Система закроется</center></body></html>";
                            ventana.jLabelError.setText(texto);
                            ventana.setVisible(true);
                            System.exit(0);
                        } else {
                            texto = "<html><body><center>Вы ввели неверные данные!<br> Остаётся " + errores + " попытка(и)</center></body></html>";
                            ventana.jLabelError.setText(texto);
                            ventana.setVisible(true);
                        }
                        jLabel6.setVisible(false);
                        jLabel7.setVisible(false);
                        jTextPwd.setText("");
                        jTextUsuario.setText("");
                        jTextUsuario.requestFocus();
                    }
                }
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Ошибка при подключении, проверьте данные!" + ex, "ВНИМАНИЕ", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextUsuarioKeyPressed
        char c = evt.getKeyChar();
        //Para controlar solo letras
        if (Character.isLetter(c) || c == KeyEvent.VK_BACK_SPACE) {
            jTextUsuario.setEditable(true);
        } else {
            jTextUsuario.setEditable(false);
           // super.getToolkit().beep();
        }
    }//GEN-LAST:event_jTextUsuarioKeyPressed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        this.setState(JFrame.ICONIFIED); //Para minimizar la ventana
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        System.exit(0);  // Para cerrar la ventana
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jTextPwdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPwdKeyPressed
       int tecla = evt.getKeyCode();
        if ((tecla >= KeyEvent.VK_0 && tecla <= KeyEvent.VK_9) || (tecla >= KeyEvent.VK_NUMPAD0 && tecla <= KeyEvent.VK_NUMPAD9) || tecla == KeyEvent.VK_BACK_SPACE) {
            jTextPwd.setEditable(true);
        } else {
            jTextPwd.setEditable(false);
            super.getToolkit().beep();

        }
    }//GEN-LAST:event_jTextPwdKeyPressed

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
                    //javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jTextPwd;
    private javax.swing.JTextField jTextUsuario;
    // End of variables declaration//GEN-END:variables
}
