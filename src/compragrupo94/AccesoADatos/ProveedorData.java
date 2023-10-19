
package compragrupo94.AccesoADatos;

import compragrupo94.Entidades.Producto;
import compragrupo94.Entidades.Provedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProveedorData {
    
    private Connection con =null;
    
    public ProveedorData(){
        con = Conexion.getConexion(); 
    }
    
    public boolean guardarProveedor (Provedor proveedor){
        boolean resultado = false;
        String sql = "INSERT INTO proveedor (razonSocial, domicilio, telefono, estado)"
                + "VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString (1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getDomicilio());
            ps.setInt(3, proveedor.getTelefono());
            ps.setBoolean(4, proveedor.isEstado());
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            
            if (rs.next()){
                proveedor.setIdProveedor(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Proveedor guardado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los Drivers.");
        }
        return resultado;
    }
    
    public boolean modificarProveedor (Provedor proveedor){
        boolean resultado = false;
        String sql = "UPDATE proveedor SET  razonSocial = ?, domicilio = ?, telefono = ?, estado = ? "
                + "WHERE idProveedor = ? ";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getDomicilio());
            ps.setInt(3, proveedor.getTelefono());
            ps.setBoolean(4, proveedor.isEstado());
            ps.setInt(5, proveedor.getIdProveedor());
            int exito = ps.executeUpdate();
            
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Proveedor modificado.");    
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor." );
        }
        return resultado;
    }
    
    public boolean eliminarProveedor (int id) {
        boolean resultado = false;
        String sql = "UPDATE proveedor SET estado = 0 WHERE idProveedor = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Proveedor eliminado.");    
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor.");
        }
        return resultado;
    }
    
    public List<Provedor> listarProveedores(){
        String sql = "SELECT idProveedor, razonSocial, domicilio, telefono FROM proveedor WHERE  estado = 1";
        ArrayList<Provedor> proveedores = new ArrayList<>();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Provedor proveedor = new Provedor();
                proveedor.setIdProveedor(rs.getInt("idProveedor"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getInt("telefono"));
                proveedor.setEstado(true);
                proveedores.add(proveedor);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla proveedor.");
        }
        return proveedores;
    }
    
    public Provedor buscarProveedor(int id){
        String sql= "SELECT razonSocial, domicilio, telefono FROM provedor WHERE idProveedor = ? AND estado = 1";
        Provedor proveedor = null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                proveedor = new Provedor();
                proveedor.setIdProveedor(id);
                proveedor.setRazonSocial(rs.getString("razon social"));
                proveedor.setTelefono(rs.getInt("telefono"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe el Proveedor.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Proveedor.");
        }
        return proveedor;
    }
    
}
