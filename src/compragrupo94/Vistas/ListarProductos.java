/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compragrupo94.Vistas;

import compragrupo94.AccesoADatos.CompraData;
import compragrupo94.AccesoADatos.DetalleCompraData;
import compragrupo94.DataTransferObject.DetalleComprasDTO;
import compragrupo94.AccesoADatos.ProductoData;
import compragrupo94.AccesoADatos.ProveedorData;
import compragrupo94.Entidades.DetalleCompra;
import compragrupo94.Entidades.Producto;
import compragrupo94.Entidades.Provedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.time.ZoneId;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guido
 */
public class ListarProductos extends javax.swing.JInternalFrame {
    private int idProducto ; 
    private DetalleCompraData detalleData;
    private DefaultTableModel modelo = new DefaultTableModel ();
    private List <Producto> productos = new ArrayList (); 
    private int filaSeleccionada; 
    private ProductoData productoData;
    private ProveedorData proveedorData;
    /**
     * Creates new form ListarProductos
     */
    public ListarProductos() {
        initComponents();
        detalleData = new DetalleCompraData();
        productoData = new ProductoData();
        proveedorData = new ProveedorData();
        cargarProveedores();
        armarCabecera (); 
        cargarTabla();
        
        // Limpia la tabla al inicio
    modelo.setRowCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDatef1 = new com.toedter.calendar.JDateChooser();
        jDateComprados = new com.toedter.calendar.JDateChooser();
        jDatef2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBoxProductor = new javax.swing.JComboBox<>();
        jButtonUltimaCompra = new javax.swing.JButton();
        jButtonComprobarStock = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButtonCompradosPor = new javax.swing.JButton();
        jButtonCompradosEl = new javax.swing.JButton();
        jButtonEntreFechas = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTdetalles = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("STOCK MENOR A:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("VER ULTIMA COMPRA:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setText("Y");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setText("PRODUCTOS COMPRADOS EL:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setText("PRODUCTOS COMPRADOS POR:");

        jButtonUltimaCompra.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButtonUltimaCompra.setText("ULTIMA COMPRA");
        jButtonUltimaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUltimaCompraActionPerformed(evt);
            }
        });

        jButtonComprobarStock.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButtonComprobarStock.setText("COMPROBAR STOCK");
        jButtonComprobarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComprobarStockActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setText("PRODUCTOS COMPRADOS ENTRE EL:");

        jButtonCompradosPor.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButtonCompradosPor.setText("BUSCAR");
        jButtonCompradosPor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompradosPorActionPerformed(evt);
            }
        });

        jButtonCompradosEl.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButtonCompradosEl.setText("BUSCAR");
        jButtonCompradosEl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompradosElActionPerformed(evt);
            }
        });

        jButtonEntreFechas.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButtonEntreFechas.setText("BUSCAR");
        jButtonEntreFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntreFechasActionPerformed(evt);
            }
        });

        jTdetalles.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTdetalles);

        jScrollPane2.setViewportView(jScrollPane1);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDatef1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jBoxProductor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateComprados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonUltimaCompra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonCompradosPor, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCompradosEl, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDatef2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEntreFechas))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonComprobarStock, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateComprados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonCompradosEl, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBoxProductor, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCompradosPor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonUltimaCompra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jDatef1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDatef2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEntreFechas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonComprobarStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCompradosElActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompradosElActionPerformed
    // Obtén la fecha seleccionada
    Date fecha = jDateComprados.getDate();

    if (fecha == null) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una fecha antes de buscar productos comprados.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Convierte la fecha en objeto LocalDate
        LocalDate fechaSeleccionada = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Llama al método para buscar productos comprados por fecha
        List<Producto> productos = productoData.listarProductosPorFecha(fechaSeleccionada);

        // Limpia la tabla antes de agregar nuevos datos
        modelo.setRowCount(0);

        // Agrega los productos encontrados a la tabla
        for (Producto producto : productos) {
            cargarDatos(producto);
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Ocurrió un error al buscar los productos comprados en la fecha seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    }//GEN-LAST:event_jButtonCompradosElActionPerformed

    private void jButtonCompradosPorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompradosPorActionPerformed
        
        int proveedorIndex = jBoxProductor.getSelectedIndex();

    if (proveedorIndex == -1) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un proveedor antes de buscar compras.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Obtiene el proveedor seleccionado
        Provedor proveedor = proveedorData.listarProveedores().get(proveedorIndex);

        // Llama al método para buscar compras por proveedor
        List<Producto> productos = productoData.listarProductosPorProveedor(proveedor.getIdProveedor());

        // Limpia la tabla antes de agregar nuevos datos
        modelo.setRowCount(0);

        // Agrega los productos encontrados a la tabla
        for (Producto producto : productos) {
            cargarDatos(producto);
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Ocurrió un error al buscar los productos comprados al proveedor seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
    }
        
    }//GEN-LAST:event_jButtonCompradosPorActionPerformed

    private void jButtonUltimaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUltimaCompraActionPerformed
        // Usar ProductoData para obtener el último producto comprado
    ProductoData productoData = new ProductoData();
    Producto ultimoProductoComprado = productoData.obtenerUltimoProductoComprado();

    // Luego puedes mostrar la información del último producto en tu interfaz
    if (ultimoProductoComprado != null) {
        // Construye el mensaje con la información del último producto
        String mensaje = "Último producto comprado:\n" +
                        "Nombre: " + ultimoProductoComprado.getNombreProducto() + "\n" +
                        "Descripción: " + ultimoProductoComprado.getDescripcion() + "\n" +
                        "Precio: " + ultimoProductoComprado.getPrecioActual() + "\n" +
                        "Stock: " + ultimoProductoComprado.getStock() + "\n" +
                        "Estado: " + (ultimoProductoComprado.isEstado() ? "Activo" : "No Activo");

        // Muestra el mensaje
        JOptionPane.showMessageDialog(this, mensaje);
    } else {
        JOptionPane.showMessageDialog(this, "No se encontró ningún producto comprado.");
    }
    }//GEN-LAST:event_jButtonUltimaCompraActionPerformed

    private void jButtonEntreFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntreFechasActionPerformed
        // Obtén las fechas seleccionadas
    Date fechaInicioDate = jDatef1.getDate();
    Date fechaFinDate = jDatef2.getDate();
    
    if (fechaInicioDate == null || fechaFinDate == null) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione ambas fechas para buscar productos comprados.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Convierte Date a LocalDate
    LocalDate fechaInicioSeleccionada = jDatef1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate fechaFinSeleccionada = jDatef2.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    java.sql.Date fechaInicio = new java.sql.Date(fechaInicioDate.getTime());
java.sql.Date fechaFin = new java.sql.Date(fechaFinDate.getTime());

    try {
        // Llama al método para buscar productos comprados entre las fechas
        List<Producto> productos = productoData.listarProductosCompradosEntreFechas(fechaInicio, fechaFin);

        // Limpia la tabla antes de agregar nuevos datos
        modelo.setRowCount(0);

        // Agrega los productos encontrados a la tabla
        for (Producto producto : productos) {
            cargarDatos(producto);
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Ocurrió un error al buscar los productos comprados entre las fechas seleccionadas.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButtonEntreFechasActionPerformed

    private void jButtonComprobarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComprobarStockActionPerformed
        try {
        // Obtiene el número ingresado en jTextField1
        int stockMaximo = Integer.parseInt(jTextField1.getText());

        // Llama al método para buscar productos con stock menor al número ingresado
        List<Producto> productos = productoData.listarProductosConStockMenorA(stockMaximo);

        // Limpia la tabla antes de agregar nuevos datos
        modelo.setRowCount(0);

        // Agrega los productos encontrados a la tabla
        for (Producto producto : productos) {
            cargarDatos(producto);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido en el campo Stock Menor a:", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButtonComprobarStockActionPerformed

        
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jBoxProductor;
    private javax.swing.JButton jButtonCompradosEl;
    private javax.swing.JButton jButtonCompradosPor;
    private javax.swing.JButton jButtonComprobarStock;
    private javax.swing.JButton jButtonEntreFechas;
    private javax.swing.JButton jButtonUltimaCompra;
    private com.toedter.calendar.JDateChooser jDateComprados;
    private com.toedter.calendar.JDateChooser jDatef1;
    private com.toedter.calendar.JDateChooser jDatef2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTdetalles;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

private void armarCabecera (){
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("PRECIO");
        modelo.addColumn("STOCK");
        modelo.addColumn("ESTADO");
        jTdetalles.setModel(modelo);     
    }

private void cargarDatos (Producto producto){
        modelo.addRow(new Object []{
            producto.getIdProducto(),
            producto.getNombreProducto(),
            producto.getDescripcion(),
            producto.getPrecioActual(),
            producto.getStock(),
            (producto.isEstado() ? "ACTIVO" : "NO ACTIVO" )}); //EL TERNARIO CUMPLE LA FUNCION DE UN IF ELSE 
        //producto.isEstado() -> CONDICION PARA VALIDAR(SI EL RESULTADO ES TRUE HACE LO QUE ESTA DESPUES DEL SIGNO "?")
        //? "ACTIVO" : "NO ACTIVO" -> SE MUESTRA "ACTIVO" CUANDO SE CUMPLE LA CONDICCION SINO (ELSE) SE MUESTRA "NO ACTIVO"  
    }

private void cargarTabla (){
        ProductoData pd = new ProductoData();
        productos = pd.listarProductos();
        for (Producto p: productos) {
            cargarDatos(p); 
        }    
    }

private void cargarProveedores() {
    List<Provedor> proveedores = proveedorData.listarProveedores();
    for (Provedor proveedor : proveedores) {
        jBoxProductor.addItem(proveedor.getRazonSocial());
    }
}





}

