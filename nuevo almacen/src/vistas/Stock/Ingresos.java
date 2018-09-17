package vistas.Stock;

import Conexion.Conexion;
import javax.swing.table.DefaultTableModel;
import vistas.Principal;
import vistas.compras.TablaDeFacturasCompras;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Ingresos extends javax.swing.JInternalFrame {

    DefaultTableModel model = new DefaultTableModel();
    public static String id_del_producto;
    public static String id_de_la_factura;
    int control=0;
    void limpiar() {
        campo_detalle_producto.setText("");
        bonificacion.setText(null);
        Precio_compra.setText("");
        cantidad_ingreso.setText("");
        Result.setText("");
        bonificacion.setEnabled(false);
    }
    
    public Ingresos() {
        initComponents();
        limpiar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cantidad_ingreso = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Precio_compra = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        campo_detalle_producto = new javax.swing.JTextField();
        campo_factura_proveedor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        bonificacion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Result = new javax.swing.JLabel();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setMaximumSize(new java.awt.Dimension(730, 190));
        setMinimumSize(new java.awt.Dimension(730, 190));
        setPreferredSize(new java.awt.Dimension(730, 190));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 90, -1));

        guardar.setText("Guardar");
        guardar.setToolTipText("Modifica todas las filas seleccionadas de la tabla");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel1.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 90, 23));

        jButton1.setText("<html>Calcular Bonificación</html>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 160));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingreso de Stock");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 11, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 440, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 610, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Stock a Ingresar:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));
        getContentPane().add(cantidad_ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 170, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("<html>Precio de Compra:</html>");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 100, -1));
        getContentPane().add(Precio_compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 170, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Producto:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Factura:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, -1));

        campo_detalle_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campo_detalle_productoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                campo_detalle_productoMouseEntered(evt);
            }
        });
        getContentPane().add(campo_detalle_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 210, -1));

        campo_factura_proveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campo_factura_proveedorMouseClicked(evt);
            }
        });
        getContentPane().add(campo_factura_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 60, 220, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Bonificación:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 70, -1));
        getContentPane().add(bonificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 200, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Resultado:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, -1, -1));

        Result.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Result.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ResultMouseClicked(evt);
            }
        });
        Result.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ResultKeyPressed(evt);
            }
        });
        getContentPane().add(Result, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 200, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void campo_detalle_productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_detalle_productoMouseClicked
        ProductosPreciosStock pre = new ProductosPreciosStock();
        Principal.panel.add(pre);
        pre.setVisible(true);
        ProductosPreciosStock.control = "0";

    }//GEN-LAST:event_campo_detalle_productoMouseClicked

    private void campo_factura_proveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_factura_proveedorMouseClicked
        TablaDeFacturasCompras ta = new TablaDeFacturasCompras();
        Principal.panel.add(ta);
        ta.setVisible(true);
        TablaDeFacturasCompras.control = "0";
    }//GEN-LAST:event_campo_factura_proveedorMouseClicked

    private void campo_detalle_productoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campo_detalle_productoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_detalle_productoMouseEntered

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed

        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement("INSERT INTO ingreso(cantidad, precio_compra, fac_compras_id_facCompra, productos_id_productos) VALUES(?,?,?,?)");
            ps.setString(1, cantidad_ingreso.getText());
            ps.setString(2, Precio_compra.getText());
            ps.setString(3, id_de_la_factura);
            ps.setString(4, id_del_producto);
            int res = ps.executeUpdate();
            if (res > 0) {

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error1 " + ex.getMessage());
        }

        if (control==1) {
            try {

                ps = con.prepareStatement("SELECT stock FROM productos WHERE id_productos=?");
                ps.setString(1, id_del_producto);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String Stockbd = rs.getString("stock");

                    int resultado = Integer.parseInt(Stockbd) + Integer.parseInt(cantidad_ingreso.getText());
                    ps = con.prepareStatement("UPDATE productos SET stock=?, precio_vta=? WHERE id_productos=?");

                    ps.setString(1, String.valueOf(resultado));
                    ps.setString(2, Result.getText());
                    ps.setString(3, id_del_producto);
                    int res = ps.executeUpdate();
                    if (res > 0) {
                        JOptionPane.showMessageDialog(null, "Se ingreso el Stock y se calculo el Precio de venta del Producto");
                    }

                }
                control=0;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error2 " + e.getMessage());
            }
        } else {
            try {
                ps = con.prepareStatement("SELECT stock FROM productos WHERE id_productos=?");
                ps.setString(1, id_del_producto);
                rs = ps.executeQuery();
                if (rs.next()) {
                    String stockbd = rs.getString("stock");
                    int resu = Integer.parseInt(stockbd) + Integer.parseInt(cantidad_ingreso.getText());
                    ps = con.prepareStatement("UPDATE productos SET stock=? WHERE id_productos=?");
                    ps.setString(1, String.valueOf(resu));
                    ps.setString(2, id_del_producto);
                    int res = ps.executeUpdate();
                    if (res > 0) {
                        JOptionPane.showMessageDialog(null, "Se ingreso el Stock del Producto");
                    }
                }
                control=0;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "error3 " + ex.getMessage());
            }
        }
        limpiar();
    }//GEN-LAST:event_guardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        control=1;
        bonificacion.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ResultKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ResultKeyPressed
        String valor1=Precio_compra.getText();
        String valor2=bonificacion.getText();
        float resultado=Float.parseFloat(valor1)+Float.parseFloat(valor1)*Float.parseFloat(valor2)/100;
        Result.setText(String.valueOf(resultado));
    }//GEN-LAST:event_ResultKeyPressed

    private void ResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ResultMouseClicked
        String valor1=Precio_compra.getText();
        String valor2=bonificacion.getText();
        float resultado=Float.parseFloat(valor1)+Float.parseFloat(valor1)*Float.parseFloat(valor2)/100;
        Result.setText(String.valueOf(resultado));
    }//GEN-LAST:event_ResultMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Precio_compra;
    private javax.swing.JLabel Result;
    private javax.swing.JTextField bonificacion;
    public static javax.swing.JTextField campo_detalle_producto;
    public static javax.swing.JTextField campo_factura_proveedor;
    private javax.swing.JTextField cantidad_ingreso;
    private javax.swing.JButton guardar;
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
