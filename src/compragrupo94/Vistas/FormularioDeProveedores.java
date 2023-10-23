package compragrupo94.Vistas;

//import com.sun.glass.events.KeyEvent;
import compragrupo94.AccesoADatos.ProveedorData;
import compragrupo94.Entidades.Provedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormularioDeProveedores extends javax.swing.JInternalFrame {
    private int idProveedor ; 
    private DefaultTableModel modelo = new DefaultTableModel();
    private List <Provedor> proveedores = new ArrayList(); 
    private int filaSeleccionada; 

    public FormularioDeProveedores() {
        initComponents();
        armarCabecera (); 
        cargarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLTelefono = new javax.swing.JLabel();
        jBModificiar = new javax.swing.JButton();
        jLEstado = new javax.swing.JLabel();
        jBActualizar = new javax.swing.JButton();
        jTRazonSocial = new javax.swing.JTextField();
        jBLimpiar = new javax.swing.JButton();
        jTDomicilio = new javax.swing.JTextField();
        jTTelefono = new javax.swing.JTextField();
        jREstado = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaProveedores = new javax.swing.JTable();
        jLRazonSocial = new javax.swing.JLabel();
        jLDomicilio = new javax.swing.JLabel();
        jBAgregar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();

        setClosable(true);

        jLTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLTelefono.setText("TELEFONO:");

        jBModificiar.setText("MODIFICAR");
        jBModificiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificiarActionPerformed(evt);
            }
        });

        jLEstado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLEstado.setText("ESTADO:");

        jBActualizar.setText("ACTUALIZAR");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jBLimpiar.setText("LIMPIAR");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setText("PROVEEDORES");

        jTablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablaProveedores);

        jLRazonSocial.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLRazonSocial.setText("RAZON SOCIAL:");

        jLDomicilio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLDomicilio.setText("DOMICILIO:");

        jBAgregar.setText("GUARDAR");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBEliminar.setText("ELIMINAR");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLDomicilio)
                                    .addComponent(jLRazonSocial)
                                    .addComponent(jLTelefono)
                                    .addComponent(jLEstado))
                                .addGap(40, 40, 40)
                                .addComponent(jTRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jREstado))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jBActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBAgregar)
                                .addGap(103, 103, 103)
                                .addComponent(jBLimpiar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBModificiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBEliminar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLRazonSocial)
                    .addComponent(jTRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDomicilio)
                    .addComponent(jTDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTelefono)
                    .addComponent(jTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLEstado)
                    .addComponent(jREstado))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBActualizar)
                    .addComponent(jBAgregar)
                    .addComponent(jBLimpiar))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBModificiar)
                    .addComponent(jBEliminar))
                .addContainerGap(266, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
   private void limpiarFormulario() {
        idProveedor = 0 ; 
        jTRazonSocial.setText("");
        jTDomicilio.setText("");
        jTTelefono.setText("");
        jREstado.setSelected(false);
        filaSeleccionada = -1;
    }
     
    private void jBModificiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificiarActionPerformed
        // BOTON MODIFICAR
        filaSeleccionada = jTablaProveedores.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "NO HA SELECCIONADO NINGUNA FILA PARA MODIFICAR");
        }else{
            System.out.println("Fila seleccionada: " + filaSeleccionada);
            idProveedor = (Integer)modelo.getValueAt(filaSeleccionada,0) ;
            jTRazonSocial.setText((String)modelo.getValueAt(filaSeleccionada,1));
            jTDomicilio.setText((String)modelo.getValueAt(filaSeleccionada,2));
            jTTelefono.setText(((Integer)modelo.getValueAt(filaSeleccionada,3)).toString());
            jREstado.setSelected(true);
        }
    }//GEN-LAST:event_jBModificiarActionPerformed
 
    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        // BOTON ACTUALIZAR
        // ACTUALIZACION EN BASE DE DATOS
        Provedor proveedor = cargarProveedor();
        proveedor.setIdProveedor(idProveedor);
        ProveedorData pro = new ProveedorData ();
        boolean seActualizo = pro.modificarProveedor(proveedor);

        // ACTUALIZACION EN VISTA
        if (seActualizo) {
            modelo.setValueAt(idProveedor,filaSeleccionada,0);
            modelo.setValueAt(jTRazonSocial.getText().trim(), filaSeleccionada, 1);
            modelo.setValueAt(jTDomicilio.getText().trim(), filaSeleccionada, 2);
            modelo.setValueAt(jTTelefono.getText().trim(), filaSeleccionada, 3);
            modelo.setValueAt(jREstado.isSelected() ? "ACTIVO" : "NO ACTIVO", filaSeleccionada, 4);
            limpiarFormulario();
        }
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        // BOTON LIMPIAR
        limpiarFormulario();
    }//GEN-LAST:event_jBLimpiarActionPerformed

    /*    */

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        // BOTON GUARDAR "LLAMO A GUARDAR PROVEEDOR"
        try {
            ProveedorData pd = new ProveedorData();
            Provedor proveedor = cargarProveedor();
            boolean seGuardo = pd.guardarProveedor(proveedor);
            if (seGuardo){
                cargarDatos(proveedor);
                limpiarFormulario();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "SOLO SE ADMITEN NUMEROS");
        }
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // BOTON ELIMINAR
        // jTablaProductos.getSelectedRow() -> SI NO SE HA SELECCIONADO NADA AUN, POR DEFECTO ES -1
        filaSeleccionada = jTablaProveedores.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "NO HA SELECCIONADO NINGUNA FILA PARA ELIMINAR");
        }else {
            idProveedor = (Integer)modelo.getValueAt(filaSeleccionada,0);
            System.out.println("ID DE PROVEEDOR A ELIMINAR: " + idProveedor );
            ProveedorData pd = new ProveedorData();
            boolean seElimino = pd.eliminarProveedor(idProveedor);
            if (seElimino){
                modelo.removeRow(filaSeleccionada);
            }
        }
    }//GEN-LAST:event_jBEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBModificiar;
    private javax.swing.JLabel jLDomicilio;
    private javax.swing.JLabel jLEstado;
    private javax.swing.JLabel jLRazonSocial;
    private javax.swing.JLabel jLTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jREstado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTDomicilio;
    private javax.swing.JTextField jTRazonSocial;
    private javax.swing.JTextField jTTelefono;
    private javax.swing.JTable jTablaProveedores;
    // End of variables declaration//GEN-END:variables

private void armarCabecera (){
        modelo.addColumn("ID");
        modelo.addColumn("RZON SOCIAL");
        modelo.addColumn("DOMICILIO");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("ESTADO");
        jTablaProveedores.setModel(modelo);     
    }
    
    private void cargarDatos (Provedor proveedor){
        modelo.addRow(new Object []{
            proveedor.getIdProveedor(),
            proveedor.getRazonSocial(),
            proveedor.getDomicilio(),
            proveedor.getTelefono(),
            (proveedor.isEstado() ? "ACTIVO" : "NO ACTIVO" )}); //EL TERNARIO CUMPLE LA FUNCION DE UN IF ELSE 
        //producto.isEstado() -> CONDICION PARA VALIDAR(SI EL RESULTADO ES TRUE HACE LO QUE ESTA DESPUES DEL SIGNO "?")
        //? "ACTIVO" : "NO ACTIVO" -> SE MUESTRA "ACTIVO" CUANDO SE CUMPLE LA CONDICCION SINO (ELSE) SE MUESTRA "NO ACTIVO"  
    }
    
    private void cargarTabla (){
        ProveedorData pd = new ProveedorData();
        proveedores = pd.listarProveedores();
        for (Provedor p: proveedores) {
            cargarDatos(p); 
        }    
    }
    
    private Provedor cargarProveedor() throws NumberFormatException {
        Provedor pro = new Provedor();
        pro.setRazonSocial(jTRazonSocial.getText());
        pro.setDomicilio(jTDomicilio.getText());
        pro.setTelefono(Integer.parseInt(jTTelefono.getText()));
        pro.setEstado(jREstado.isSelected());
        return pro ; 
    }

}
