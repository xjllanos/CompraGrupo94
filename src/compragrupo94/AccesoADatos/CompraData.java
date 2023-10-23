/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compragrupo94.AccesoADatos;

import compragrupo94.Entidades.Compras;
import compragrupo94.Entidades.Producto;
import compragrupo94.Entidades.Provedor;
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

/**
 *
 * @author JATil
 */
public class CompraData {
    private Connection con =null;
    
    public CompraData(){
        con = Conexion.getConexion();
    }
    
    public void registrarCompra(Provedor proveedor, Producto producto, int cantidad, LocalDate fecha) {
    // Primero, debes insertar la compra en la tabla 'compra'.
    String sqlCompra = "INSERT INTO compra (idProvedor, fecha) VALUES (?, ?)";
    try (PreparedStatement psCompra = con.prepareStatement(sqlCompra, Statement.RETURN_GENERATED_KEYS)) {
        psCompra.setInt(1, proveedor.getIdProveedor());
        psCompra.setDate(2, Date.valueOf(fecha));
        psCompra.executeUpdate();
        
        ResultSet rsCompra = psCompra.getGeneratedKeys();
        int idCompra = -1;
        if (rsCompra.next()) {
            idCompra = rsCompra.getInt(1);
        }
        
        // Ahora, inserta los detalles de la compra en la tabla 'detallecompra'.
        if (idCompra != -1) {
            String sqlDetalleCompra = "INSERT INTO detallecompra (idCompra, idProducto, cantidad, precioCosto) VALUES (?, ?, ?, ?)";
            try (PreparedStatement psDetalleCompra = con.prepareStatement(sqlDetalleCompra)) {
                psDetalleCompra.setInt(1, idCompra);
                psDetalleCompra.setInt(2, producto.getIdProducto());
                psDetalleCompra.setInt(3, cantidad);
                psDetalleCompra.setDouble(4, producto.getPrecioActual());
                psDetalleCompra.executeUpdate();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al insertar detalle de compra: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error al obtener el ID de la compra.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al insertar la compra: " + ex.getMessage());
    }
}
    public double obtenerPrecioCosto(int productoId) {
        // Implementa aquí la consulta a la base de datos para obtener el costo unitario del producto.
        String sql = "SELECT precioCosto FROM detallecompra WHERE idProducto = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, productoId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("precioCosto");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener el costo unitario: " + ex.getMessage());
        }
        return 0.0; // Devuelve 0.0 en caso de error o si no se encuentra el costo unitario.
    }
    
    public void AgregarCompra(Compras compras){
        
        String sql = "INSERT INTO compra (idCompra, idProvedor, fecha)"
                + "VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, compras.getIdCompra());
            ps.setInt(2, compras.getIdProvedor());
            
            // fecha
            LocalDate fecha = compras.getFecha();

            // Convierto LocalDate a Date antes de establecerlo en el PreparedStatement
            Date Fecha = Date.valueOf(fecha);

            ps.setDate(3, Fecha); // Establesco la fecha en el PreparedStatement
            ps.executeUpdate();
            
            ResultSet rs=ps.getGeneratedKeys();
            
            if (rs.next()){
                
                compras.setIdCompra(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "compra guardada");
                
            }
            ps.close();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al cargar los drivers");
        }
        
    }
    
    public void modificarCompra(Compras compras) {
        String sql = "UPDATE compra SET idProvedor = ?, fecha = ? WHERE idCompra = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, compras.getIdProvedor());
            
            // Fecha
            LocalDate fecha = compras.getFecha();
            java.sql.Date fechaSQL = java.sql.Date.valueOf(fecha);
            ps.setDate(2, fechaSQL);
            
            ps.setInt(3, compras.getIdCompra());
            
            int exito = ps.executeUpdate();
            
            if (exito == 1) { 
                JOptionPane.showMessageDialog(null, "Compra modificada"); 
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró una compra con ese ID"); 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla compra");
        }
    }


    
    public void eliminarCompra(int id){
        
        String sql="DELETE FROM compra WHERE idCompra = ?";
        
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if(exito==1){
                
            JOptionPane.showMessageDialog(null, " compra eliminada ");    
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " Error al acceder a la tabla compra");
        }
        
    }
    
    public List<Compras> buscarComprasPorFecha(LocalDate fecha) {
    String sql = "SELECT * FROM compra WHERE fecha = ?";
    ArrayList<Compras> compras = new ArrayList<>();

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        // Convierte LocalDate a Date (java.sql.Date) antes de establecerlo en el PreparedStatement
        java.sql.Date fechaSQL = java.sql.Date.valueOf(fecha);
        ps.setDate(1, fechaSQL); // Establece la fecha en el PreparedStatement

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Compras compra = new Compras(); // Creo una nueva instancia para cada compra
            compra.setIdCompra(rs.getInt("idCompra"));
            compra.setIdProvedor(rs.getInt("idProvedor"));
            compra.setFecha(rs.getDate("fecha").toLocalDate()); // Convierto java.sql.Date a LocalDate
            compras.add(compra); // Agrego la instancia a la lista
        }

        if (compras.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron compras para esa fecha");
        }
        
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla compra");
    }

    return compras;
}


}