package compragrupo94.Vistas;

import compragrupo94.AccesoADatos.CompraData;
import compragrupo94.AccesoADatos.DetalleCompraData;
import compragrupo94.AccesoADatos.ProveedorData;
import compragrupo94.DataTransferObject.DetalleComprasDTO;
import compragrupo94.Entidades.DetalleCompra;
import compragrupo94.Entidades.Provedor;
import java.time.ZoneId;
//import java.sql.Date;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormularioDetalleCompras extends javax.swing.JInternalFrame {
    //GENERO LAS CONSTANTES PARA LAS POSICIONES DE LAS COLUMNAS 
    private final int COL_ID_COMPRA =0;
    private final int COL_NOMBRE = 1;
    private final int COL_TOTAL = 2; 
    private final int COL_ID_PRODUCTO = 3;
    private final int COL_CANTIDAD = 4; 
    // 
    private DetalleCompraData detalleData;
    private ProveedorData proveedorData;
    private DefaultTableModel modelo;
    private CompraData compraData;
    private List<DetalleCompra> detalles = new ArrayList();
    
    public FormularioDetalleCompras() {
        initComponents();
        compraData = new CompraData();
        proveedorData = new ProveedorData();
        detalleData = new DetalleCompraData();
        modelo = new DefaultTableModel();
        armarDetalles();
        cargarProveedores();
        jBoxProveedor.setSelectedIndex(-1);
        jDfecha.setDate(null);
        obtenerCostoTotal();
        actualizarCostoTotal();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBoxProveedor = new javax.swing.JComboBox<>();
        jDfecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTdetalles = new javax.swing.JTable();
        jTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBusquedaNuwva = new javax.swing.JButton();

        jBoxProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBoxProveedorActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("PROVEEDOR");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("FECHA DE COMPRA");

        jBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBuscar.setText("BUSCAR");
        jBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBuscarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Costo Total");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("DETALLES DE COMPRA");

        jBusquedaNuwva.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBusquedaNuwva.setText("NUEVA BUSQUEDA");
        jBusquedaNuwva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBusquedaNuwvaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBoxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBuscar)
                .addGap(106, 106, 106))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jBusquedaNuwva, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBoxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(81, 81, 81)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jBusquedaNuwva)
                .addContainerGap(50, Short.MAX_VALUE))
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

    private void jBoxProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBoxProveedorActionPerformed
        
    }//GEN-LAST:event_jBoxProveedorActionPerformed

    private void jBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBuscarActionPerformed
        int proveedorIndex = jBoxProveedor.getSelectedIndex();
        Date fecha = (Date) jDfecha.getDate();
        
        if (proveedorIndex == -1 || fecha == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos antes de buscar compras.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            Provedor proveedor = proveedorData.listarProveedores().get(proveedorIndex);

            // Llama al método para buscar compras por proveedor y fecha
            List<DetalleComprasDTO> detalles = detalleData.buscarDetallesPorProveedorYFecha(proveedor.getRazonSocial(),
                    fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            //

            // Mostrar los detalles en la tabla
            mostrarDetallesEnTabla(detalles);
            jTotal.setText(String.valueOf(obtenerCostoTotal())); // COSTO TOTAL 
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ocurrió un error al buscar las compras.", "Error", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_jBuscarActionPerformed
    
    private void mostrarDetallesEnTabla(List<DetalleComprasDTO> detalles) {
        DefaultTableModel modelo = (DefaultTableModel) jTdetalles.getModel();

        // Limpia la tabla
        modelo.setRowCount(0);
        
        for (DetalleComprasDTO detalle : detalles) {
            Object[] fila = {
                detalle.getIdCompra(),
                detalle.getNombre(),
                detalle.getPrecioCosto(),
                detalle.getIdProducto(),
                detalle.getCantidad()
            };
            modelo.addRow(fila);
        }
    }    
    

    private void jDfechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDfechaPropertyChange
        
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
        
    }//GEN-LAST:event_jTdetallesPropertyChange

    private void jBusquedaNuwvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBusquedaNuwvaActionPerformed
        // Limpia la tabla
            DefaultTableModel modelo = (DefaultTableModel) jTdetalles.getModel();
            modelo.setRowCount(0);

            // Limpia el JComboBox y el JDateChooser
           jBoxProveedor.setSelectedIndex(-1);
            jDfecha.setDate(null);

           // Limpia el campo del costo total
           jTotal.setText("");

    }//GEN-LAST:event_jBusquedaNuwvaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jBoxProveedor;
    private javax.swing.JButton jBuscar;
    private javax.swing.JButton jBusquedaNuwva;
    private com.toedter.calendar.JDateChooser jDfecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTdetalles;
    private javax.swing.JTextField jTotal;
    // End of variables declaration//GEN-END:variables

    private void armarDetalles() {
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("IdCompra");        
        filaCabecera.add("Nombre");
        filaCabecera.add("Total");
        filaCabecera.add("IdProducto");
        filaCabecera.add("Cantidad");
        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }
        jTdetalles.setModel(modelo);        
    }
    
    private void cargarProveedores() {
        List<Provedor> proveedores = proveedorData.listarProveedores();
        for (Provedor proveedor : proveedores) {
            jBoxProveedor.addItem(proveedor.getRazonSocial());
        }
    }
    
    private double obtenerCostoTotal() {
        double costoTotal = 0.0;
        
        for (int i = 0; i < jTdetalles.getRowCount(); i++) {
            System.out.println("precio: " + jTdetalles.getValueAt(i, COL_TOTAL).toString());
            double precio = (double) jTdetalles.getValueAt(i, COL_TOTAL);
            //PRECIO SERIA COL_TOTAL(EN LA UBICACION 2 DE LA TABLA) 
            costoTotal += precio;
            System.out.println("costo total " + costoTotal);
        }
        return costoTotal;
    }
    
    
    private void actualizarCostoTotal() {
        DefaultTableModel modelo = (DefaultTableModel) jTdetalles.getModel();        
        double costoTotal = 0.0;
        // Itera sobre las filas de la tabla
        for (int i = 0; i < jTdetalles.getRowCount(); i++) {
            // Obtiene el precio y cantidad de la fila
            double precio = (double) jTdetalles.getValueAt(i, COL_TOTAL);            
            int cantidad = (int) jTdetalles.getValueAt(i, COL_CANTIDAD);            
            double Total = (double) jTdetalles.getValueAt(COL_TOTAL, COL_CANTIDAD);
            // Calcula el costo total por producto y lo suma al costo total 
            costoTotal += precio * cantidad;
        }

        // Actualiza campo para mostrar el costo total
        jTotal.setText(String.valueOf(costoTotal));        
    }
    
}
