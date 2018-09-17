package vistas.Stock;

import Conexion.Conexion;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import vistas.Ventas.Generador_de_ventas_del_dia;

public class ProductosPreciosStock extends javax.swing.JInternalFrame {

    public static String control;
    DefaultTableModel model = new DefaultTableModel();

    void cargar_tabla() {

        TablaProductosStock.setModel(model);

        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_productos, codigo, detalle, stock, precio_vta FROM productos");
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidaddecolumnas = rsmd.getColumnCount();
            model.addColumn("id");
            model.addColumn("codigo");
            model.addColumn("Descripción");
            model.addColumn("Stock");
            model.addColumn("Precio de Venta");

            while (rs.next()) {
                Object[] filas = new Object[cantidaddecolumnas];
                for (int i = 0; i < cantidaddecolumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                model.addRow(filas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductosPreciosStock.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void buscar_codigo(String texto) {

        String[] columnas = {"id", "codigo", "detalle", "unidad", "stock", "Precio de Venta"};
        String tex = "" + texto + "_%";
        String sql = "SELECT id_productos, codigo, detalle, unidad, stock, precio_vta FROM productos WHERE codigo LIKE " + '"' + tex + '"';

        model = new DefaultTableModel(null, columnas);
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            Object[] filas=new Object[6];
            while(rs.next()){
               filas[0]=rs.getString("id_productos");
               filas[1]=rs.getString("codigo");
               filas[2]=rs.getString("detalle");
               filas[3]=rs.getString("unidad");
               filas[4]=rs.getString("stock");
               filas[5]=rs.getString("precio_vta");
                model.addRow(filas);
            }
            TablaProductosStock.setModel(model);
            ps.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductosPreciosStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void buscador_detalle(String texto){
        String[] columnas = {"id", "codigo", "detalle", "unidad", "stock", "Precio de Venta"};
        String tex = "" + texto + "_%";
        String sql = "SELECT id_productos, codigo, detalle, unidad, stock, precio_vta FROM productos WHERE detalle LIKE " + '"' + tex + '"';

        model = new DefaultTableModel(null, columnas);
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            Object[] filas=new Object[6];
            while(rs.next()){
               filas[0]=rs.getString("id_productos");
               filas[1]=rs.getString("codigo");
               filas[2]=rs.getString("detalle");
               filas[3]=rs.getString("unidad");
               filas[4]=rs.getString("stock");
               filas[5]=rs.getString("precio_vta");
                model.addRow(filas);
            }
            TablaProductosStock.setModel(model);
            ps.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductosPreciosStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ProductosPreciosStock() {
        initComponents();
        cargar_tabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupBusqueda = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProductosStock = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_busqueda = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        radio_codigo = new javax.swing.JRadioButton();
        radio_desc = new javax.swing.JRadioButton();

        setMaximumSize(new java.awt.Dimension(560, 530));
        setMinimumSize(new java.awt.Dimension(560, 530));
        setPreferredSize(new java.awt.Dimension(560, 530));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaProductosStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Código", "Descripción", "Strock", "Precio de Venta"
            }
        ));
        TablaProductosStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProductosStockMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaProductosStock);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 96, 550, 350));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Productos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jLabel2.setToolTipText("");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 0, 550, -1));

        jLabel3.setText("Buscar por:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        txt_busqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_busquedaKeyReleased(evt);
            }
        });
        getContentPane().add(txt_busqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 160, -1));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 460, 60, -1));

        grupBusqueda.add(radio_codigo);
        radio_codigo.setText("Código");
        getContentPane().add(radio_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, -1, -1));

        grupBusqueda.add(radio_desc);
        radio_desc.setText("Descripción");
        getContentPane().add(radio_desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TablaProductosStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductosStockMouseClicked
        if (control.equals("0")) {
            int fila = TablaProductosStock.getSelectedRow();
            Ingresos.campo_detalle_producto.setText(String.valueOf(TablaProductosStock.getValueAt(fila, 2)));
            Ingresos.id_del_producto = String.valueOf(TablaProductosStock.getValueAt(fila, 0));
            this.setVisible(false);
        } else {
            int filas = TablaProductosStock.getSelectedRow();
            String id = TablaProductosStock.getValueAt(filas, 0).toString();

            Connection con = null;
            Conexion conn = new Conexion();
            con = conn.getConexion();
            PreparedStatement ps;
            ResultSet rs;
            try {
                ps = con.prepareStatement("SELECT codigo, detalle, unidad, precio_vta FROM productos WHERE id_productos=?");
                ps.setString(1, id);
                rs = ps.executeQuery();
                if (rs.next()) {
                    Generador_de_ventas_del_dia.codigo.setText(rs.getString("codigo"));
                    Generador_de_ventas_del_dia.detalle.setText(rs.getString("detalle"));
                    Generador_de_ventas_del_dia.unidad.setText(rs.getString("unidad"));
                    Generador_de_ventas_del_dia.precio_unidad.setText(rs.getString("precio_vta"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductosPreciosStock.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_TablaProductosStockMouseClicked

    private void txt_busquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_busquedaKeyReleased
       if(radio_codigo.isSelected()){
           String cod=txt_busqueda.getText();
           buscar_codigo(cod);
       }
       if(radio_desc.isSelected()){
           String de=txt_busqueda.getText();
           buscador_detalle(de);
       }
    }//GEN-LAST:event_txt_busquedaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaProductosStock;
    private javax.swing.ButtonGroup grupBusqueda;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radio_codigo;
    private javax.swing.JRadioButton radio_desc;
    private javax.swing.JTextField txt_busqueda;
    // End of variables declaration//GEN-END:variables
}
