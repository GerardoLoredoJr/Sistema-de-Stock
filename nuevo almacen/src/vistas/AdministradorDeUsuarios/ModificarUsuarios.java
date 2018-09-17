package vistas.AdministradorDeUsuarios;

import Conexion.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ModificarUsuarios extends javax.swing.JInternalFrame {

    
    void poner_null(){
        usuario.setText(null);
        contraseñaanterior.setText(null);
        campo_contraseña.setText(null);
        campor_confi_contraseña.setText(null);
        
        palabraclave.setText(null);
    }

    void inhabilitar() {
        
        contraseñaanterior.setEnabled(false);
        campo_contraseña.setEnabled(false);
        campor_confi_contraseña.setEnabled(false);
        
        palabraclave.setEnabled(false);
        usuario.setEnabled(false);
        poner_null();
        boton_usuarios.setEnabled(true);
        boton_guardar.setEnabled(false);
    }

    void habilitar() {
        
        campo_contraseña.setEnabled(true);
        campor_confi_contraseña.setEnabled(true);
        
        boton_usuarios.setEnabled(false);
        boton_guardar.setEnabled(true);
        contraseñaanterior.setEnabled(true);
        palabraclave.setEnabled(true);
        usuario.setEnabled(true);
    }

    public ModificarUsuarios() {
        initComponents();
        inhabilitar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        boton_usuarios = new javax.swing.JButton();
        boton_guardar = new javax.swing.JButton();
        boton_salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campo_contraseña = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        campor_confi_contraseña = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        palabraclave = new javax.swing.JPasswordField();
        contraseñaanterior = new javax.swing.JPasswordField();
        usuario = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setTitle("Modificar Usuarios ");
        setMaximumSize(new java.awt.Dimension(586, 288));
        setMinimumSize(new java.awt.Dimension(586, 288));
        setPreferredSize(new java.awt.Dimension(586, 288));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/equipo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 130, -1));

        boton_usuarios.setText("Usuarios");
        boton_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_usuariosActionPerformed(evt);
            }
        });
        jPanel1.add(boton_usuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 130, -1));

        boton_guardar.setText("Guardar");
        boton_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(boton_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 130, -1));

        boton_salir.setText("Salir");
        boton_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_salirActionPerformed(evt);
            }
        });
        jPanel1.add(boton_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 130, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 260));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Modificar Usuarios y Administrador");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 11, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("<html>Nueva Contraseña:</html>");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 60, -1));

        campo_contraseña.setToolTipText("Ingrese su \"Nueva Contraseña\"");
        getContentPane().add(campo_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 300, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("<html>Confirmar Contraseña:</html>");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 60, -1));

        campor_confi_contraseña.setToolTipText("Confirmar su contraseña para poder modificar");
        getContentPane().add(campor_confi_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 300, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Usuario:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 60, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("<html>Contraseña Anterior:</html>");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 60, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("<html>Palabra Clave:</html>");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 215, 60, -1));
        getContentPane().add(palabraclave, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 300, -1));
        getContentPane().add(contraseñaanterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 300, -1));
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 300, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 420, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_salirActionPerformed
        dispose();
    }//GEN-LAST:event_boton_salirActionPerformed

    private void boton_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_usuariosActionPerformed
        
        habilitar();

    }//GEN-LAST:event_boton_usuariosActionPerformed

    private void boton_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardarActionPerformed
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        String contraseña1 = String.valueOf(campo_contraseña.getPassword());
        String contraseña2 = String.valueOf(campor_confi_contraseña.getPassword());
        if (contraseña1.equals(contraseña2)) {
            try {
                ps = con.prepareStatement("UPDATE usuarios SET contraseña=?, contraseña2=?, palabraclave=? WHERE usuario=?");

                ps.setString(1, String.valueOf(campo_contraseña.getPassword()));
                ps.setString(2, String.valueOf(campor_confi_contraseña.getPassword()));
                ps.setString(3, String.valueOf(palabraclave.getPassword()));
                ps.setString(4, usuario.getText());

                int res = ps.executeUpdate();
                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "Se modifico el usuario");
                }
                inhabilitar();
            } catch (SQLException ex) {
                Logger.getLogger(ModificarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_boton_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton boton_guardar;
    private javax.swing.JButton boton_salir;
    public static javax.swing.JButton boton_usuarios;
    public static javax.swing.JPasswordField campo_contraseña;
    public static javax.swing.JPasswordField campor_confi_contraseña;
    public static javax.swing.JPasswordField contraseñaanterior;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPasswordField palabraclave;
    public static javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
