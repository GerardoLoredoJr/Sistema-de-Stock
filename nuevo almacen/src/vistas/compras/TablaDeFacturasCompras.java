package vistas.compras;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static vistas.Principal.panel;
import vistas.Stock.Ingresos;
import vistas.Stock.ProductosPreciosStock;
import static vistas.Ventas.Ventas.tablaventas;

public class TablaDeFacturasCompras extends javax.swing.JInternalFrame {

    DefaultTableModel model1 = new DefaultTableModel();
    
    public static String control="1";

    void buscar_fecha(String texto) {

        String[] columnas = {"id", "Fecha", "Número de Factura", "Monto", "Estado", "Proveedor"};
        String text = "" + texto + "_%";
        String sql = "SELECT id_facCompra, fecha, numero, monto, estado, Proveedor FROM fac_compras WHERE fecha LIKE " + '"' + text + '"';

        model1 = new DefaultTableModel(null, columnas);
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] filas = new Object[6];
            while (rs.next()) {
                filas[0] = rs.getString("id_facCompra");
                filas[1] = rs.getString("fecha");
                filas[2] = rs.getString("numero");
                filas[3] = rs.getString("monto");
                filas[4] = rs.getString("estado");
                filas[5] = rs.getString("Proveedor");

                model1.addRow(filas);
            }
            tablaFacCompras.setModel(model1);

        } catch (SQLException ex) {
            Logger.getLogger(ProductosPreciosStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void buscar_fecha_y_Provedor(String texto) {

        String[] columnas = {"id", "Fecha", "Número de Factura", "Monto", "Estado", "Proveedor"};
        String text = "" + texto + "_%";
        String sql = "SELECT id_facCompra, fecha, numero, monto, estado, Proveedor FROM fac_compras WHERE fecha LIKE " + '"' + text + '"' + " AND Proveedor=?";

        model1 = new DefaultTableModel(null, columnas);
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, buscarsegundaop.getText());
            rs = ps.executeQuery();
            Object[] filas = new Object[6];
            while (rs.next()) {
                filas[0] = rs.getString("id_facCompra");
                filas[1] = rs.getString("fecha");
                filas[2] = rs.getString("numero");
                filas[3] = rs.getString("monto");
                filas[4] = rs.getString("estado");
                filas[5] = rs.getString("Proveedor");

                model1.addRow(filas);
            }
            tablaFacCompras.setModel(model1);

        } catch (SQLException ex) {
            Logger.getLogger(ProductosPreciosStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void buscar_proveedor(String texto) {

        String[] columnas = {"id", "Fecha", "Número de Factura", "Monto", "Estado", "Proveedor"};
        String tex = "" + texto + "_%";
        String sql = "SELECT id_facCompra, fecha, numero, monto, estado, Proveedor FROM fac_compras WHERE Proveedor LIKE " + '"' + tex + '"';

        model1 = new DefaultTableModel(null, columnas);
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] filas = new Object[6];
            while (rs.next()) {
                filas[0] = rs.getString("id_facCompra");
                filas[1] = rs.getString("fecha");
                filas[2] = rs.getString("numero");
                filas[3] = rs.getString("monto");
                filas[4] = rs.getString("estado");
                filas[5] = rs.getString("Proveedor");

                model1.addRow(filas);
            }
            tablaFacCompras.setModel(model1);
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProductosPreciosStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void buscar_estado(String texto) {

        String[] columnas = {"id", "Fecha", "Número de Factura", "Monto", "Estado", "Proveedor"};
        String tex = "" + texto + "_%";
        String sql = "SELECT id_facCompra, fecha, numero, monto, estado, Proveedor FROM fac_compras WHERE estado LIKE " + '"' + tex + '"';

        model1 = new DefaultTableModel(null, columnas);
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Object[] filas = new Object[6];
            while (rs.next()) {
                filas[0] = rs.getString("id_facCompra");
                filas[1] = rs.getString("fecha");
                filas[2] = rs.getString("numero");
                filas[3] = rs.getString("monto");
                filas[4] = rs.getString("estado");
                filas[5] = rs.getString("Proveedor");

                model1.addRow(filas);
            }
            tablaFacCompras.setModel(model1);
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProductosPreciosStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  public static void cargar_tabla() {
        DefaultTableModel model = new DefaultTableModel();
        tablaFacCompras.setModel(model);

        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_facCompra, fecha, numero, monto, estado, Proveedor FROM fac_compras");
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadcolum = rsmd.getColumnCount();
            model.addColumn("id");
            model.addColumn("Fecha");
            model.addColumn("Número de Factura");
            model.addColumn("Monto");
            model.addColumn("Estado");
            model.addColumn("Proveedor");

            while (rs.next()) {
                Object[] filas = new Object[cantidadcolum];
                for (int i = 0; i < cantidadcolum; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                model.addRow(filas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TablaDeFacturasCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TablaDeFacturasCompras() {
        initComponents();
        cargar_tabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacCompras = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        buscarpor = new javax.swing.JTextField();
        fecha = new javax.swing.JRadioButton();
        estado = new javax.swing.JRadioButton();
        proveedor = new javax.swing.JRadioButton();
        boton_modificar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        buscarsegundaop = new javax.swing.JTextField();
        detalles = new javax.swing.JButton();

        setTitle("Tabla de Facturas de Compras");
        setMaximumSize(new java.awt.Dimension(620, 591));
        setMinimumSize(new java.awt.Dimension(620, 591));
        setPreferredSize(new java.awt.Dimension(620, 591));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tabla de Facturas de Compras");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 48));

        tablaFacCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Fecha", "Número de Factura", "Montó", "Estado", "Proveedor"
            }
        ));
        tablaFacCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaFacComprasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaFacCompras);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 600, 400));

        jLabel3.setText("Buscar por:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        buscarpor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buscarporMouseClicked(evt);
            }
        });
        buscarpor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarporKeyReleased(evt);
            }
        });
        getContentPane().add(buscarpor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 140, -1));

        fecha.setText("Fecha");
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, -1, -1));

        estado.setText("Estado");
        estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoActionPerformed(evt);
            }
        });
        getContentPane().add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, -1));

        proveedor.setText("Proveedor");
        getContentPane().add(proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, -1));

        boton_modificar.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        boton_modificar.setText("Modificar");
        boton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_modificarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, 90, -1));

        jButton1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 530, 70, -1));

        jButton2.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton2.setText("Actualizar Tabla");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, -1, -1));

        jLabel4.setText("y/o");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        buscarsegundaop.setToolTipText("Este campo solo puede ser utilizado si se selecciona que va a buscar por fecha y proveedor");
        getContentPane().add(buscarsegundaop, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 140, -1));

        detalles.setText("Ver detalles");
        detalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detallesActionPerformed(evt);
            }
        });
        getContentPane().add(detalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 530, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_modificarActionPerformed
        int fila = tablaFacCompras.getSelectedRow();
        String id_comp = String.valueOf(tablaFacCompras.getValueAt(fila, 0));
        Factura_Compras.id = String.valueOf(tablaFacCompras.getValueAt(fila, 0));

        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT * FROM fac_compras WHERE id_facCompra=?");
            ps.setString(1, id_comp);
            rs = ps.executeQuery();
            if (rs.next()) {
                
                SimpleDateFormat formatofecha=new SimpleDateFormat("dd/MM/yyyy");
                Date fecha = null;
                
                try {
                    fecha=formatofecha.parse(rs.getString("fecha"));
                } catch (ParseException ex) {
                    Logger.getLogger(TablaDeFacturasCompras.class.getName()).log(Level.SEVERE, null, ex);
                }
                

                Factura_Compras.campo_fecha.setDate(fecha);
                Factura_Compras.campor_tipo_factura.setText(rs.getString("tipo"));
                Factura_Compras.campo_sucursa.setText(rs.getString("num_suc"));
                Factura_Compras.campo_factura.setText(rs.getString("numero"));
                Factura_Compras.campo_monto.setText(rs.getString("monto"));
                Factura_Compras.combo_estado.setSelectedItem(rs.getString("estado"));
                Factura_Compras.combo_proveedor.setSelectedItem(rs.getString("Proveedor"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TablaDeFacturasCompras.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_boton_modificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cargar_tabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buscarporKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarporKeyReleased
        if (fecha.isSelected() && proveedor.isSelected()) {
            String fec = buscarpor.getText();
            buscar_fecha_y_Provedor(fec);

        } else if (estado.isSelected()) {
            String es = buscarpor.getText();
            buscar_estado(es);

        } else if (proveedor.isSelected()) {
            String pro = buscarpor.getText();
            buscar_proveedor(pro);

        } else if (fecha.isSelected()) {
            String fe = buscarpor.getText();
            buscar_fecha(fe);
        }

    }//GEN-LAST:event_buscarporKeyReleased

    private void estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoActionPerformed

    private void buscarporMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buscarporMouseClicked
        cargar_tabla();
    }//GEN-LAST:event_buscarporMouseClicked

    private void tablaFacComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaFacComprasMouseClicked
        if(control.equals("0")){
        int fila = tablaFacCompras.getSelectedRow();
        Ingresos.id_de_la_factura = String.valueOf(tablaFacCompras.getValueAt(fila, 0));
        Ingresos.campo_factura_proveedor.setText(String.valueOf(tablaFacCompras.getValueAt(fila, 1) + " | " + String.valueOf(tablaFacCompras.getValueAt(fila, 5))));
        this.setVisible(false);
        }
    }//GEN-LAST:event_tablaFacComprasMouseClicked

    private void detallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detallesActionPerformed
          int fila=tablaFacCompras.getSelectedRow();
          String id=tablaFacCompras.getValueAt(fila, 0).toString();
          Connection con=null;
          Conexion conn=new Conexion();
          con=conn.getConexion();
          PreparedStatement ps;
          ResultSet rs;
          
        try {
            DefaultTableModel model=(DefaultTableModel) Detalles_de_FacturasCompras.tabla_detalles_de_factura_de_Compras.getModel();
            ps=con.prepareStatement("SELECT * FROM ingreso WHERE fac_compras_id_facCompra=?");
            ps.setString(1, id);
            rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            
            model.addColumn("cantidad");
            model.addColumn("Pecio de Compra");
            model.addColumn("Factura");
            model.addColumn("Producto");
            while(rs.next()){
               String[] filas=new String[4];
               filas[0]=rs.getString("cantidad");
               filas[1]=rs.getString("precio_compra");
               
               ps=con.prepareStatement("SELECT * FROM fac_compras WHERE id_facCompra=?");
               ps.setString(1, rs.getString("fac_compras_id_facCompra"));
               
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TablaDeFacturasCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }//GEN-LAST:event_detallesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_modificar;
    private javax.swing.JTextField buscarpor;
    private javax.swing.JTextField buscarsegundaop;
    private javax.swing.JButton detalles;
    private javax.swing.JRadioButton estado;
    private javax.swing.JRadioButton fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton proveedor;
    public static javax.swing.JTable tablaFacCompras;
    // End of variables declaration//GEN-END:variables
}
