
package vistas;
import Conexion.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Recuperar_contraseña extends javax.swing.JFrame {
 
    
    public Recuperar_contraseña() {
        initComponents();
        con1.setEnabled(false);
        con2.setEnabled(false);
        modificar.setEnabled(false);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        recuperar_contraseña = new javax.swing.JButton();
        boton_salir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        palabraclave = new javax.swing.JPasswordField();
        con1 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        con2 = new javax.swing.JPasswordField();
        modificar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(417, 350));
        setMinimumSize(new java.awt.Dimension(417, 350));
        setPreferredSize(new java.awt.Dimension(417, 350));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Recuperar contraseña");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Usuario:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 71, -1, -1));
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 68, 290, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Palabra Clave:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        recuperar_contraseña.setText("Recuperar Contaseña");
        recuperar_contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recuperar_contraseñaActionPerformed(evt);
            }
        });
        getContentPane().add(recuperar_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        boton_salir.setText("Salir");
        boton_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_salirActionPerformed(evt);
            }
        });
        getContentPane().add(boton_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 80, -1));

        jLabel5.setText("Contraseña Nueva:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));
        getContentPane().add(palabraclave, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 290, -1));
        getContentPane().add(con1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 240, -1));

        jLabel6.setText("Confirmar  Contraseña:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));
        getContentPane().add(con2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 240, -1));

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        getContentPane().add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void recuperar_contraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recuperar_contraseñaActionPerformed
        Connection con=null;
        Conexion conn=new Conexion();
        con=conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            
            ps=con.prepareStatement("SELECT * FROM usuarios WHERE usuario=?");
            ps.setString(1, usuario.getText());
            rs=ps.executeQuery();
           
            if(rs.next()){
                
                if(usuario.getText().equals(rs.getString("usuario")) && String.valueOf(palabraclave.getPassword()).equals(rs.getString("palabraclave"))){
                    usuario.setEnabled(false);
                    palabraclave.setEnabled(false);
                    
                    con1.setEnabled(true);
                    con2.setEnabled(true);
                    modificar.setEnabled(true);
                    }else{
                    JOptionPane.showMessageDialog(null, "usuario y correo no son iguales a lo ingresado anteriormente");
                }
                    
                    
                
            }else{
                JOptionPane.showMessageDialog(null, "usuario oh palabra clave incorrecto");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Recuperar_contraseña.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_recuperar_contraseñaActionPerformed

    private void boton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_salirActionPerformed
        dispose();
        Login lo=new Login();
        lo.setVisible(true);
    }//GEN-LAST:event_boton_salirActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        Connection con=null;
        Conexion conn=new Conexion();
        con=conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps=con.prepareStatement("UPDATE usuarios SET contraseña=?, contraseña2=? WHERE usuario=?");
            ps.setString(1, String.valueOf(con1.getPassword()));
            ps.setString(2, String.valueOf(con2.getPassword()));
            ps.setString(3, usuario.getText());
            int res=ps.executeUpdate();
            if(res>0){
                JOptionPane.showMessageDialog(null, "Su contraseña de usuario fue modificada");
            }
            this.setVisible(false);
            Login lo=new Login();
            lo.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_modificarActionPerformed

    
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
            java.util.logging.Logger.getLogger(Recuperar_contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Recuperar_contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Recuperar_contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Recuperar_contraseña.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Recuperar_contraseña().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_salir;
    private javax.swing.JPasswordField con1;
    private javax.swing.JPasswordField con2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton modificar;
    private javax.swing.JPasswordField palabraclave;
    private javax.swing.JButton recuperar_contraseña;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
