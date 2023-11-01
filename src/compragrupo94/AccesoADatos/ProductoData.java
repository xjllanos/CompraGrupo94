
package compragrupo94.AccesoADatos;

import compragrupo94.Entidades.Producto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ProductoData {
    
    private Connection con =null;
    
    public ProductoData(){
    
        con = Conexion.getConexion(); 
    }
    
    public boolean actualizarStock(int idProducto, int nuevoStock) {
    boolean resultado = false;
    String sql = "UPDATE producto SET stock = ? WHERE idProducto = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, nuevoStock);
        ps.setInt(2, idProducto);
        int exito = ps.executeUpdate();

        if (exito == 1) {
            JOptionPane.showMessageDialog(null, "Stock actualizado con éxito.");
            resultado = true;
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar el stock del producto.");
    }
    return resultado;
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
    
    public Producto obtenerUltimoProductoComprado() {
    String sql = "SELECT p.idProducto, p.nombreProducto, p.descripcion, p.precioActual, p.stock " +
                 "FROM producto p " +
                 "INNER JOIN detallecompra d ON p.idProducto = d.idProducto " +
                 "INNER JOIN compra c ON d.idCompra = c.idCompra " +
                 "WHERE p.estado = 1 " +
                 "ORDER BY c.fecha DESC, d.idDetalle DESC " +
                 "LIMIT 1";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            Producto producto = new Producto();
            producto.setNombreProducto(rs.getString("nombreProducto"));
            producto.setDescripcion(rs.getString("descripcion"));
            producto.setPrecioActual(rs.getDouble("precioActual"));
            producto.setStock(rs.getInt("stock"));
            producto.setEstado(true);
            ps.close();
            return producto;
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto.");
    }
    
    return null; // Devuelve null si no se encontraron productos
}
    
    public List<Producto> listarProductosPorFecha(LocalDate fecha) {
    String sql = "SELECT p.idProducto, p.nombreProducto, p.descripcion, p.precioActual, p.stock " +
                 "FROM producto p " +
                 "INNER JOIN detallecompra dc ON p.idProducto = dc.idProducto " +
                 "INNER JOIN compra c ON dc.idCompra = c.idCompra " +
                 "WHERE p.estado = 1 AND c.fecha = ?";
    
    ArrayList<Producto> productos = new ArrayList<>();

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setDate(1, Date.valueOf(fecha));
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Producto producto = new Producto();
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
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto.");
    }

    return productos;
}
    
    public List<Producto> listarProductosPorProveedor(int idProveedor) {
    String sql = "SELECT p.idProducto, p.nombreProducto, p.descripcion, p.precioActual, p.stock " +
                 "FROM producto p " +
                 "INNER JOIN detallecompra dc ON p.idProducto = dc.idProducto " +
                 "INNER JOIN compra c ON dc.idCompra = c.idCompra " +
                 "WHERE p.estado = 1 AND c.idProvedor = ?";
    
    ArrayList<Producto> productos = new ArrayList<>();

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idProveedor);
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Producto producto = new Producto();
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
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto.");
    }

    return productos;
}
    
    public List<Producto> listarProductosCompradosEntreFechas(Date fechaInicio, Date fechaFin) throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT DISTINCT p.* FROM producto p " +
                     "INNER JOIN detallecompra d ON p.idProducto = d.idProducto " +
                     "INNER JOIN compra c ON d.idCompra = c.idCompra " +
                     "WHERE c.fecha BETWEEN ? AND ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setDate(1, new java.sql.Date(fechaInicio.getTime()));
            statement.setDate(2, new java.sql.Date(fechaFin.getTime()));
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Producto producto = new Producto();
                    producto.setIdProducto(resultSet.getInt("idProducto"));
                    producto.setNombreProducto(resultSet.getString("nombreProducto"));
                    producto.setDescripcion(resultSet.getString("descripcion"));
                    producto.setPrecioActual(resultSet.getDouble("precioActual"));
                    producto.setStock(resultSet.getInt("stock"));
                    producto.setEstado(resultSet.getInt("estado") == 1);
                    productos.add(producto);
                }
            }
        }
        return productos;
    }
     
    // productosMinimo("precioActual")
    // productosMinimo("stock")
    public List<Producto> listarProductosConStockMenorA(int stockMaximo) {
    List<Producto> productos = new ArrayList<>();
    String sql = "SELECT idProducto, nombreProducto, descripcion, precioActual, stock, estado FROM producto WHERE stock <= ?";
    
    try (PreparedStatement statement = con.prepareStatement(sql)) {
        statement.setInt(1, stockMaximo);
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Producto producto = new Producto();
                producto.setIdProducto(resultSet.getInt("idProducto"));
                producto.setNombreProducto(resultSet.getString("nombreProducto"));
                producto.setDescripcion(resultSet.getString("descripcion"));
                producto.setPrecioActual(resultSet.getDouble("precioActual"));
                producto.setStock(resultSet.getInt("stock"));
                producto.setEstado(resultSet.getInt("estado") == 1);
                productos.add(producto);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto.");
    }
    
    return productos;
}
}
