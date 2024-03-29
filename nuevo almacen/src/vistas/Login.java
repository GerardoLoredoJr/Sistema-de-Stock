
package vistas;

import Conexion.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

   
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        limpiar();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelKey = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        contraseña = new javax.swing.JPasswordField();
        lblOlvidoPass = new javax.swing.JLabel();
        LabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(361, 190));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelKey.setBackground(new java.awt.Color(102, 102, 255));
        PanelKey.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/llave 96.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        PanelKey.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 100, 99));

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        btnIngresar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnIngresarKeyPressed(evt);
            }
        });
        PanelKey.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 100, -1));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        PanelKey.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 168, 100, -1));

        jButton1.setText("Invitado");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PanelKey.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 139, 100, -1));

        getContentPane().add(PanelKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 210));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Log In");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 140, 40));

        jLabel3.setBackground(new java.awt.Color(153, 153, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, 20));

        jLabel4.setBackground(new java.awt.Color(153, 153, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contraseña: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, 20));

        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usuarioKeyPressed(evt);
            }
        });
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 130, -1));

        contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contraseñaKeyPressed(evt);
            }
        });
        getContentPane().add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 130, -1));

        lblOlvidoPass.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblOlvidoPass.setForeground(new java.awt.Color(255, 255, 255));
        lblOlvidoPass.setText("Olvidó su contraseña?");
        lblOlvidoPass.setToolTipText("Presione aquí para recuperar su clave");
        lblOlvidoPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOlvidoPassMouseClicked(evt);
            }
        });
        getContentPane().add(lblOlvidoPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        LabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        LabelFondo.setText("registrarse");
        getContentPane().add(LabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 370, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void usuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyPressed
        if (evt.getKeyCode()==10){
            this.contraseña.requestFocus();
        }
    }//GEN-LAST:event_usuarioKeyPressed

    private void contraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contraseñaKeyPressed
        if (evt.getKeyCode()==10){
            this.btnIngresar.requestFocus();
        }
    }//GEN-LAST:event_contraseñaKeyPressed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        Connection con=null;
        Conexion CONN=new Conexion();
        con=CONN.getConexion();
        
        PreparedStatement ps;
        ResultSet rs;
        
        try{
        ps=con.prepareStatement("SELECT * FROM usuarios WHERE usuario=?");
        ps.setString(1,usuario.getText());
            
            rs=ps.executeQuery();
            if(rs.next()){
                
                String usuario_bd=rs.getString("usuario");
                String contraseña_bd=rs.getString("contraseña");
                String CONTRASEÑA=String.valueOf(contraseña.getPassword());
                
                if(CONTRASEÑA.equals(contraseña_bd) && usuario.getText().equals(usuario_bd)){
                   
                 Principal prin=new Principal();
                 prin.setVisible(true);
                 this.setVisible(false);
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "usuario y contraseña no encontrado");
                }
                
            }else{
                JOptionPane.showMessageDialog(null,"usuario y contraseña no encontrado");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
       
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnIngresarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnIngresarKeyPressed
        Connection con=null;
        Conexion CONN=new Conexion();
        con=CONN.getConexion();
        
        PreparedStatement ps;
        ResultSet rs;
        
        try{
        ps=con.prepareStatement("SELECT * FROM usuarios WHERE usuario=?");
        ps.setString(1,usuario.getText());
            
            rs=ps.executeQuery();
            if(rs.next()){
                
                String usuario_bd=rs.getString("usuario");
                String contraseña_bd=rs.getString("contraseña");
                String CONTRASEÑA=String.valueOf(contraseña.getPassword());
                
                if(CONTRASEÑA.equals(contraseña_bd) && usuario.getText().equals(usuario_bd)){
                   
                 Principal prin=new Principal();
                 prin.setVisible(true);
                 this.setVisible(false);
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "usuario y contraseña no encontrado");
                }
                
            }else{
                JOptionPane.showMessageDialog(null,"usuario y contraseña no encontrado");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_btnIngresarKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Principal pri=new Principal();
        pri.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblOlvidoPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOlvidoPassMouseClicked
        Recuperar_contraseña re=new Recuperar_contraseña();
        re.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lblOlvidoPassMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    public void limpiar(){
        this.usuario.setText("");
        this.contraseña.setText("");
        this.usuario.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelFondo;
    private javax.swing.JPanel PanelKey;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblOlvidoPass;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
