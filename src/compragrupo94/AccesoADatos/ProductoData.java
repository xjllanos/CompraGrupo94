
package compragrupo94.AccesoADatos;

import compragrupo94.Entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProductoData {
    
    private Connection con =null;
    
    public ProductoData(){
    
        con = Conexion.getConexion(); 
    }
    
    public boolean guardarProducto ( Producto producto){
        boolean resultado = false ; 
        String sql = "INSERT INTO producto (nombreProducto, descripcion, precioActual, stock, estado)"
                + "VALUES (?, ?, ?, ?, ?)"; 
        
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString (1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstado());
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            
            if (rs.next()){
                producto.setIdProducto(rs.getInt(1));
                JOptionPane.showMessageDialog(null, " Producto guardado ");
                resultado = true ; 
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al cargar los drivers ");
        }
        return resultado ; 
    }
    
    public boolean modificarProducto ( Producto producto ){
    
        boolean resultado = false;
        String sql="UPDATE producto SET  nombreProducto= ?, descripcion = ?, precioActual = ?, stock= ?,estado = ? "
                + "WHERE idProducto = ? ";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setBoolean(5, producto.isEstado());
            ps.setInt(6, producto.getIdProducto());
            int exito = ps.executeUpdate();
            
            if(exito==1){
                
                JOptionPane.showMessageDialog(null, " Producto modificado ");    
                resultado = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla producto " );
        }
        return resultado;
    }
    
    public boolean eliminarProducto ( int id ) {
        boolean resultado = false ; 
        String sql="UPDATE producto SET estado = 0 WHERE idProducto = ?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if(exito==1){
                
                JOptionPane.showMessageDialog(null, " Producto eliminado ");
                resultado = true ; 
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla alumno");
        }
        return resultado ;
    }
    
    public List<Producto> listarProductos(){
        
        String sql= "SELECT idProducto, nombreProducto, descripcion, precioActual, stock FROM producto WHERE  estado = 1";
        ArrayList<Producto> productos=new ArrayList<>();
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
              
                Producto producto = new Producto ();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(true);
                productos.add(producto);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla producto ");
        }
        return productos;
    }
    
     
    // productosMinimo("precioActual")
    // productosMinimo("stock")
    public List<Producto> productosMinimo (String orden){
        
        String sql= "SELECT idProducto, nombreProducto, descripcion, precioActual, stock FROM producto WHERE  estado = 1 ORDER BY ? ASC ";
        ArrayList<Producto> productos=new ArrayList<>();
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, orden);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
              
                Producto producto = new Producto ();
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(true);
                productos.add(producto);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla producto ");
        }
        return productos;
    }
}
