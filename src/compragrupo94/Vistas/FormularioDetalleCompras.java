
package compragrupo94.Vistas;
import compragrupo94.AccesoADatos.DetalleCompraData;
import compragrupo94.AccesoADatos.ProveedorData;
import compragrupo94.Entidades.DetalleCompra;
import compragrupo94.Entidades.Provedor;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class FormularioDetalleCompras extends javax.swing.JInternalFrame {
private List<DetalleCompra> detallesPorProveedor;
    private DefaultTableModel modelo;
     private DetalleCompraData detalleData;
    private List<Provedor> listaProveedores;
    
    public FormularioDetalleCompras() {
        initComponents();
        modelo = new DefaultTableModel();
         listaProveedores = new ArrayList<>();
        detalleData = new DetalleCompraData(); 
        detallesPorProveedor=new ArrayList<>();
         armarDetalles();
        actualizarCostoTotal();
       obtenerCostoTotal();
        cargarProveedores();
        
                
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jboxProveedor = new javax.swing.JComboBox<>();
        jDfecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTdetalles = new javax.swing.JTable();
        jTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jboxProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jboxProveedorActionPerformed(evt);
            }
        });

        jDfecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDfechaPropertyChange(evt);
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
        jTdetalles.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTdetallesPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTdetalles);

        jTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTotalActionPerformed(evt);
            }
        });

        jLabel1.setText("PROVEEDOR");

        jLabel2.setText("FECHA DE COMPRA");

        jBuscar.setText("BUSCAR");
        jBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarActionPerformed(evt);
            }
        });

        jLabel3.setText("Costo Total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jboxProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDfecha, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBuscar)
                .addGap(106, 106, 106))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jboxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(81, 81, 81)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jBuscar)))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jboxProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jboxProveedorActionPerformed
          ProveedorData proveedorData = new ProveedorData();
        listaProveedores = proveedorData.listarProveedores();
        
        jboxProveedor.removeAllItems(); // Limpia combox
        
        listaProveedores.forEach((proveedor) -> {
            jboxProveedor.addItem(proveedor.getRazonSocial());
        });
    }//GEN-LAST:event_jboxProveedorActionPerformed

    private void jBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarActionPerformed
        // Verifica  q la fecha y el proveedor sean  seleccionados
    if (jDfecha.getDate() != null && jboxProveedor.getSelectedItem() != null) {
        Date dateSeleccionada = (Date) jDfecha.getDate();
        Instant instant = dateSeleccionada.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDate fechaSeleccionada = instant.atZone(zoneId).toLocalDate();
        String razonSocialProveedor = jboxProveedor.getSelectedItem().toString();

        
        List<DetalleCompra> comprasEncontradas = detalleData.buscarDetallesPorProveedorYFecha(razonSocialProveedor, fechaSeleccionada);

        detallesPorProveedor = comprasEncontradas;

        // Actualiza la tabla
        actualizarTablaDetalles();
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione una fecha y un proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
    }
   
      
                                          
    }//GEN-LAST:event_jBuscarActionPerformed

    private void jDfechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDfechaPropertyChange
        // Verifica si tanto la fecha como el proveedor están seleccionados
    if (jDfecha.getDate() != null && jboxProveedor.getSelectedItem() != null) {
        jBuscar.setEnabled(true);
    }
    else {
        jBuscar.setEnabled(false);
    }
    }//GEN-LAST:event_jDfechaPropertyChange

    private void jTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTotalActionPerformed
          try {
        // Llama al método para actualizar 
        actualizarCostoTotal();

       // llama al método para obtener 
        double costoTotal = obtenerCostoTotal();

        // Actualiza el jTotal
        jTotal.setText(String.valueOf(costoTotal));
    } catch (Exception e) {
        e.printStackTrace(); 
    }
    }//GEN-LAST:event_jTotalActionPerformed

    private void jTdetallesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTdetallesPropertyChange
        if ("tableCellEditor".equals(evt.getPropertyName())) {
            int fila = jTdetalles.getSelectedRow();
            int columna = jTdetalles.getSelectedColumn();
            Object valor = jTdetalles.getValueAt(fila, columna);
            System.out.println("Valor seleccionado: " + valor);
        }
    }//GEN-LAST:event_jTdetallesPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBuscar;
    private com.toedter.calendar.JDateChooser jDfecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTdetalles;
    private javax.swing.JTextField jTotal;
    private javax.swing.JComboBox<String> jboxProveedor;
    // End of variables declaration//GEN-END:variables

    private void armarDetalles() {
        
        ArrayList <Object> filaCabecera=new ArrayList<>();
                filaCabecera.add("IdProducto"); 
                filaCabecera.add("Nombre");
                filaCabecera.add("Descripcion");
                filaCabecera.add("Cantidad");
                filaCabecera.add("Precio");
                filaCabecera.add("Total");
           for (Object it: filaCabecera){
           modelo.addColumn(it);
            
            }
            modelo.addColumn("Costo Total"); 
           jTdetalles.setModel(modelo);
    }
    

    private void actualizarCostoTotal() {
        DefaultTableModel modelo = (DefaultTableModel) jTdetalles.getModel(); 
    double costoTotal = 0.0;
   
    // Itera sobre las filas de la tabla
    for (int i = 0; i < jTdetalles.getRowCount(); i++) {
        // Obtiene el precio y cantidad de la fila
        double precio = (double) jTdetalles.getValueAt(i,4); 
        int cantidad = (int) jTdetalles.getValueAt(i, 5); 
        double Total =(double)jTdetalles.getValueAt(4, 5);
        // Calcula el costo total por producto y lo suma al costo total 
        costoTotal += precio * cantidad;
    }
    
    // Actualiza campo para mostrar el costo total
    jTotal.setText(String.valueOf(costoTotal)); 
    
    
    }

    private double obtenerCostoTotal() {
         double costoTotal = 0.0;
    
    for (int i = 0; i < jTdetalles.getRowCount(); i++) {
        double precio = (double) jTdetalles.getValueAt(i, 4);
        int cantidad = (int) jTdetalles.getValueAt(i, 5);
        costoTotal += precio * cantidad;
    }
    
    return costoTotal;
    }

    private void cargarProveedores() {
          ProveedorData proveedorData = new ProveedorData();
        listaProveedores = proveedorData.listarProveedores();

        jboxProveedor.removeAllItems(); // Limpia los elementos del JComboBox

        listaProveedores.forEach((proveedor) -> {
            jboxProveedor.addItem(proveedor.getRazonSocial());
        });
    
    }
    private void actualizarTablaDetalles() {
         // Actualiza la tabla jTdetalles
    DefaultTableModel model = (DefaultTableModel) jTdetalles.getModel();
    model.setRowCount(0); // Limpia la tabla 

    for (DetalleCompra detalle : detallesPorProveedor) {
        Object[] row = {detalle.getIdCompra(), detalle.getIdProducto(), detalle.getCantidad(), detalle.getPrecioCosto()};
        model.addRow(row);
    }
    
  }  
    
    private void limpiarTabla(){
        int indice = modelo.getRowCount()-1;
         for (int i = indice;i>0;i--)
             modelo.removeRow(i);
   
}
    
     private void mostrarComprasEnTabla(List<DetalleCompra> compras) {
    DefaultTableModel modelo = (DefaultTableModel) jTdetalles.getModel();

    // Limpia la tabla
    modelo.setRowCount(0);

    for (DetalleCompra compra : compras) {
        Object[] fila = {
            compra.getIdCompra(),
            compra.getIdProveedor(),
            compra.getPrecioCosto(),
            compra.getIdProducto(), 
          
        };

        modelo.addRow(fila);
    }
    
   
    }
}
