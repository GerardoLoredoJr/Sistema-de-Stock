
package vistas.Ventas;



import Conexion.Conexion;
import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import vistas.Principal;
import vistas.Stock.ProductosPreciosStock;


public class Ventas extends javax.swing.JInternalFrame {
 String fecha="";
 double total=0;
 DefaultTableModel model1=new DefaultTableModel();
 
 void buscar_fecha(String texto) {

        String[] columnas = {"codigo", "detalle", "cantidad", "PrecioUnidad", "cliente", "precio", "fecha"};
        String tex = "" + texto + "_%";
        String sql = "SELECT codigo, detalle, cantidad, PrecioUnidad, cliente, precio, fecha FROM ventas_dia WHERE fecha LIKE " + '"' + tex + '"';

        model1 = new DefaultTableModel(null, columnas);
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            Object[] filas=new Object[7];
            while(rs.next()){
               filas[0]=rs.getString("codigo");
               filas[1]=rs.getString("detalle");
               filas[2]=rs.getString("cantidad");
               filas[3]=rs.getString("PrecioUnidad");
               filas[4]=rs.getString("cliente");
               filas[5]=rs.getString("precio");
               filas[6]=rs.getString("fecha");
               model1.addRow(filas);
            }
            tablaventas.setModel(model1);
            ps.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductosPreciosStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
 void buscar_cliente(String texto) {

        String[] columnas = {"codigo", "detalle", "cantidad", "PrecioUnidad", "cliente", "precio", "fecha"};
        String tex = "" + texto + "_%";
        String sql = "SELECT codigo, detalle, cantidad, PrecioUnidad, cliente, precio, fecha FROM ventas_dia WHERE cliente LIKE " + '"' + tex + '"';

        model1 = new DefaultTableModel(null, columnas);
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(sql);
            rs=ps.executeQuery();
            Object[] filas=new Object[7];
            while(rs.next()){
               filas[0]=rs.getString("codigo");
               filas[1]=rs.getString("detalle");
               filas[2]=rs.getString("cantidad");
               filas[3]=rs.getString("PrecioUnidad");
               filas[4]=rs.getString("cliente");
               filas[5]=rs.getString("precio");
               filas[6]=rs.getString("fecha");
               model1.addRow(filas);
            }
            tablaventas.setModel(model1);
            ps.close();
            rs.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductosPreciosStock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
 void cargar(){
     DefaultTableModel model=new DefaultTableModel();
        tablaventas.setModel(model);
        Connection con = null;
                Conexion conn = new Conexion();
                con = conn.getConexion();
                PreparedStatement ps;
                ResultSet rs;
     try {
         ps=con.prepareStatement("SELECT codigo, detalle, cantidad, PrecioUnidad, cliente, precio, fecha FROM ventas_dia");
         
         rs=ps.executeQuery();
         ResultSetMetaData rsmd=rs.getMetaData();
         int cantidad=rsmd.getColumnCount();
         model.addColumn("código");
         model.addColumn("detalle");
         model.addColumn("cantidad");
         model.addColumn("PrecioUnidad");
         model.addColumn("cliente");
         model.addColumn("precio");
         model.addColumn("fecha");
         while(rs.next()){
             Object[] fila=new Object[cantidad];
             for(int i=0;i<cantidad;i++){
                 
                 fila[i]=rs.getObject(i+1);
             }
             model.addRow(fila);
         }
         
     } catch (SQLException ex) {
         Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
     }
 }
    
    public Ventas() {
        initComponents();
        DateFormat formato=new SimpleDateFormat("dd/MM/YYYY");
        
        fecha_venta.setText(String.valueOf(formato.format(new Date())));
        
        cargar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fecha_venta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventas = new javax.swing.JTable();
        ActualizarTabla = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        buscadorr = new javax.swing.JTextField();
        radio_fecha = new javax.swing.JRadioButton();
        radio_cliente = new javax.swing.JRadioButton();
        jButton2 = new javax.swing.JButton();

        setTitle("Ventas del Día");
        setMaximumSize(new java.awt.Dimension(915, 564));
        setMinimumSize(new java.awt.Dimension(915, 564));
        setPreferredSize(new java.awt.Dimension(915, 564));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ventas del Día");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 23, -1, -1));

        fecha_venta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fecha_ventaMouseClicked(evt);
            }
        });
        fecha_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecha_ventaActionPerformed(evt);
            }
        });
        jPanel1.add(fecha_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(812, 29, 90, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(769, 32, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 70));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 450, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 912, -1));

        tablaventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descripción", "Cantidad", "Unidad", "Cliente", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tablaventas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 113, 912, 350));

        ActualizarTabla.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        ActualizarTabla.setText("Actualizar Tabla");
        ActualizarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarTablaActionPerformed(evt);
            }
        });
        getContentPane().add(ActualizarTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 480, -1, 28));

        jButton1.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 480, -1, 28));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Buscar lo Vendido en el día por:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        buscadorr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscadorrKeyReleased(evt);
            }
        });
        getContentPane().add(buscadorr, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 140, -1));

        buttonGroup1.add(radio_fecha);
        radio_fecha.setText("Fecha");
        getContentPane().add(radio_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 78, -1, -1));

        buttonGroup1.add(radio_cliente);
        radio_cliente.setText("Cliente");
        getContentPane().add(radio_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 78, -1, -1));

        jButton2.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jButton2.setText("Generar Reporte");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 480, 120, 28));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fecha_ventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecha_ventaMouseClicked
        
       
        
    }//GEN-LAST:event_fecha_ventaMouseClicked

    private void ActualizarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarTablaActionPerformed
        cargar();
    }//GEN-LAST:event_ActualizarTablaActionPerformed

    private void fecha_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecha_ventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fecha_ventaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buscadorrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscadorrKeyReleased
        if(radio_fecha.isSelected()){
            String fec=buscadorr.getText();
            buscar_fecha(fec);
        }
        if(radio_cliente.isSelected()){
            String cli=buscadorr.getText();
            buscar_cliente(cli);
        }
    }//GEN-LAST:event_buscadorrKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
           
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarTabla;
    private javax.swing.JTextField buscadorr;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField fecha_venta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radio_cliente;
    private javax.swing.JRadioButton radio_fecha;
    public static javax.swing.JTable tablaventas;
    // End of variables declaration//GEN-END:variables
}
