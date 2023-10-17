import compragrupo94.AccesoADatos.ProveedorData;
import compragrupo94.Entidades.Provedor;

//package compragrupo94.Vistas;

public class FormularioDeProveedores extends javax.swing.JInternalFrame {
    private int idProveedor;
    
    public FormularioDeProveedores() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLproveedor = new javax.swing.JLabel();
        jLRazonSocial = new javax.swing.JLabel();
        jTRazonSocial = new javax.swing.JTextField();
        jLDomicilio = new javax.swing.JLabel();
        jTDomicilio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTEstado = new javax.swing.JRadioButton();
        jTBuscar = new javax.swing.JButton();
        jTGuardar = new javax.swing.JButton();
        jTEliminar = new javax.swing.JButton();
        jLTelefono = new javax.swing.JLabel();
        jTTelefono = new javax.swing.JTextField();
        jLId = new javax.swing.JLabel();
        jTId = new javax.swing.JTextField();
        jTListar = new javax.swing.JButton();

        jLproveedor.setFont(new java.awt.Font("Arial", 1, 22)); // NOI18N
        jLproveedor.setText("PROVEEDORES");

        jLRazonSocial.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLRazonSocial.setText("RAZON SOCIAL:");

        jLDomicilio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLDomicilio.setText("DOMICILIO:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("ESTADO:");

        jTBuscar.setText("Buscar");
        jTBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBuscarActionPerformed(evt);
            }
        });

        jTGuardar.setText("Guardar");
        jTGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTGuardarActionPerformed(evt);
            }
        });

        jTEliminar.setText("Eliminar");
        jTEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTEliminarActionPerformed(evt);
            }
        });

        jLTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLTelefono.setText("TELEFONO:");

        jLId.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLId.setText("ID:");

        jTListar.setText("Listar");
        jTListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLproveedor)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLId)
                    .addComponent(jLTelefono)
                    .addComponent(jLabel5)
                    .addComponent(jLDomicilio)
                    .addComponent(jLRazonSocial))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTEstado))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jTBuscar)
                .addGap(26, 26, 26)
                .addComponent(jTGuardar)
                .addGap(27, 27, 27)
                .addComponent(jTEliminar)
                .addGap(27, 27, 27)
                .addComponent(jTListar)
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLproveedor)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLId)
                    .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLRazonSocial)
                    .addComponent(jTRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDomicilio)
                    .addComponent(jTDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLTelefono)
                    .addComponent(jTTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTEstado, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTEliminar)
                    .addComponent(jTGuardar)
                    .addComponent(jTBuscar)
                    .addComponent(jTListar))
                .addGap(56, 56, 56))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBuscarActionPerformed
        //BUSCAR PROVEEDOR
        int num = Integer.parseInt(jTId.getText());
        System.out.println(num);

        ProveedorData pd = new ProveedorData ();
        Provedor proveedor = pd.buscarProveedor(num);
        System.out.println(proveedor.getRazonSocial());
        
        jTRazonSocial.setText(proveedor.getRazonSocial());
        jTDomicilio.setText(proveedor.getDomicilio());
        jTEstado.setSelected(proveedor.isEstado());
        idProveedor = proveedor.getIdProveedor();
    }//GEN-LAST:event_jTBuscarActionPerformed

    private void jTGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTGuardarActionPerformed
        // GUARDAR PROVEEDOR
        ProveedorData pd = new ProveedorData();
        Provedor proveedor = new Provedor ();
        //proveedor.setDni(Integer.parseInt(jTDni.getText()));
        proveedor.setRazonSocial(jTRazonSocial.getText());
        proveedor.setDomicilio(jTDomicilio.getText());
        proveedor.setEstado(jTEstado.isSelected());
        pd.guardarProveedor(proveedor);

    }//GEN-LAST:event_jTGuardarActionPerformed

    private void jTEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTEliminarActionPerformed
        // ELIMINAR PROVEEDOR
        System.out.println("ID DE PROVEEDOR A ELIMINAR: " + idProveedor);
        ProveedorData pd = new ProveedorData ();
        pd.eliminarProveedor(idProveedor);
        idProveedor = 0 ;
        jTRazonSocial.setText("");
        jTDomicilio.setText("");
        jTEstado.setSelected(false);
    }//GEN-LAST:event_jTEliminarActionPerformed

    private void jTListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTListarActionPerformed
        // TODO add your handling code here:
        
        
        
        
        
        
    }//GEN-LAST:event_jTListarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLDomicilio;
    private javax.swing.JLabel jLId;
    private javax.swing.JLabel jLRazonSocial;
    private javax.swing.JLabel jLTelefono;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLproveedor;
    private javax.swing.JButton jTBuscar;
    private javax.swing.JTextField jTDomicilio;
    private javax.swing.JButton jTEliminar;
    private javax.swing.JRadioButton jTEstado;
    private javax.swing.JButton jTGuardar;
    private javax.swing.JTextField jTId;
    private javax.swing.JButton jTListar;
    private javax.swing.JTextField jTRazonSocial;
    private javax.swing.JTextField jTTelefono;
    // End of variables declaration//GEN-END:variables
}
