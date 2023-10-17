
package compragrupo94.Vistas;

import compragrupo94.AccesoADatos.ProveedorData;
import compragrupo94.Entidades.Provedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class FormularioListadoProveedores extends javax.swing.JInternalFrame {
    private List<Provedor> listaP;
    private ProveedorData pData;
    private DefaultTableModel modelo;

    public FormularioListadoProveedores() {
        initComponents();
        pData = new ProveedorData();
        listaP = pData.listarProveedores();
        modelo = new DefaultTableModel();
        
        cargarProveedores();
        armarCabeceraTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTProveedores = new javax.swing.JTable();

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("LISTADO DE PROVEEDORES");

        jTProveedores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTProveedores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel3)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTProveedores;
    // End of variables declaration//GEN-END:variables

    private void armarCabeceraTabla(){
        ArrayList<Object> filaCabecera= new ArrayList<>();
        modelo.addColumn("ID");
        modelo.addColumn("RAZON SOCIAL");
        modelo.addColumn("DOMICILIO");
        modelo.addColumn("TELEFONO");
        for(Object it: filaCabecera){
            modelo.addColumn(it);
        }
        jTProveedores.setModel(modelo);     
    }

    private void cargarProveedores(){
        borrarFilaTabla();
        List <Provedor> lista = pData.obtenerMateriasCursadas(selec.getIdAlumno());
        for (Materia m: lista){
            modelo.addRow(new Object[]{m.getIdMateria(), m.getNombre(), m.getAnio()});
        }
    }

    private void borrarFilaTabla(){
        int indice= modelo.getRowCount() -1;
        for (int i = indice;i>=0;i--){
            modelo.removeRow(i);
        }
    }


}
