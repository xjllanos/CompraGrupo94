package compragrupo94.AccesoADatos;

import compragrupo94.DataTransferObject.DetalleComprasDTO;
import compragrupo94.Entidades.DetalleCompra;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class DetalleCompraData {

    private List<DetalleCompra> detallesCompra;
    private Connection con;
   

    public DetalleCompraData() {
        
        con = Conexion.getConexion();
        detallesCompra = new ArrayList<>();
    }

    public List<DetalleCompra> ProductoEntreFechas(Date fechaInicio, Date fechaFin) throws SQLException {
        List<DetalleCompra> detalles = new ArrayList<>();
        String sql = "SELECT d.* FROM DetalleCompra d "
                + "JOIN Compra c ON d.idCompra = c.idCompra "
                + "WHERE c.fecha BETWEEN ? AND ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setDate(1, fechaInicio);
        statement.setDate(2, fechaFin);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            DetalleCompra detalle = new DetalleCompra(
                    resultSet.getInt("idDetalle"),
                    resultSet.getInt("cantidad"),
                    resultSet.getDouble("precioCosto"),
                    resultSet.getInt("idCompra"),
                    resultSet.getInt("idProducto")
            );
            detalles.add(detalle);
        }
        return detalles;
    }

    public void agregarDetalleCompra(DetalleCompra detalle) throws SQLException {
        String query = "INSERT INTO detalle_compra (cantidad, precio_costo, id_compra, id_producto, id_proveedor, fecha) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = con.prepareStatement(query);
        statement.setInt(1, detalle.getCantidad());
        statement.setDouble(2, detalle.getPrecioCosto());
        statement.setInt(3, detalle.getIdCompra());
        statement.setInt(4, detalle.getIdProducto());
        statement.setInt(5, detalle.getIdProveedor());
        statement.setDate(6, java.sql.Date.valueOf(detalle.getFecha()));

        statement.executeUpdate();
    }

    public List<DetalleCompra> ProductoPorProveedor(int idProveedor) {
        List<DetalleCompra> detallesPorProveedor = new ArrayList<>();
        for (DetalleCompra detalle : detallesCompra) {
            if (detalle.getIdProveedor() == idProveedor) {
                detallesPorProveedor.add(detalle);
            }
        }
        return detallesPorProveedor;
    }

    public List<DetalleCompra> ProductoPorCompra(int idCompra) {
        List<DetalleCompra> detallesPorCompra = new ArrayList<>();
        for (DetalleCompra detalle : detallesCompra) {
            if (detalle.getIdCompra() == idCompra) {
                detallesPorCompra.add(detalle);
            }
        }
        return detallesPorCompra;
    }

    public double PrecioFinal(int idCompra) {
        double precioFinal = 0.0;
        for (DetalleCompra detalle : detallesCompra) {
            if (detalle.getIdCompra() == idCompra) {
                precioFinal += detalle.getPrecioCosto() * detalle.getCantidad();
            }
        }
        return precioFinal;
    }

    public int CantidadesProducto(int idProducto) {
        int totalCantidad = 0;
        for (DetalleCompra detalle : detallesCompra) {
            if (detalle.getIdProducto() == idProducto) {
                totalCantidad += detalle.getCantidad();
            }
        }
        return totalCantidad;
    }

    public List<DetalleComprasDTO> buscarDetallesPorProveedorYFecha(String razonSocialProveedor, LocalDate fechaSeleccionada) {
         List<DetalleComprasDTO> detallesEncontrados = new ArrayList<>();
    try {
        String sql = "SELECT * FROM DetalleCompra d "
                + "JOIN Compra c ON d.idCompra = c.idCompra "
                + "JOIN Proveedor p ON c.idProvedor = p.idProveedor "
                + "JOIN Producto pr ON pr.idProducto = d.idProducto "
                + "WHERE p.razonSocial = ? AND DATE(c.fecha) = ?";

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, razonSocialProveedor);
        Date fecha = Date.valueOf(fechaSeleccionada);
        statement.setDate(2, fecha);
        ResultSet resultSet = statement.executeQuery();
        
        boolean hasResults = false;
        
        while (resultSet.next()) {
            hasResults = true;
            DetalleComprasDTO detalle = new  DetalleComprasDTO(
                    resultSet.getInt("idDetalle"),
                    resultSet.getInt("cantidad"),
                    resultSet.getDouble("precioCosto"),
                    resultSet.getInt("idCompra"),
                    resultSet.getInt("idProducto")
            );
            detalle.setNombre(resultSet.getNString("nombreProducto"));
            System.out.println(">>> Detalle de compra: { idDetalle: " + detalle.getIdDetalle()
                    + ", cantidad: " + detalle.getCantidad()
                    + ", precioCosto: " + detalle.getPrecioCosto()
                    + ", compra: " + detalle.getIdCompra()
                    + ", producto: " + detalle.getIdProducto()
                    + " }"); // AGREGUE UN SOUT PARA QUE IMPRIMA EL MENSAJE Y MUESTRE EL DETALLE DE COMPRA 
            detallesEncontrados.add(detalle);
        }
        
        if (!hasResults) {
            System.out.println("No se encontraron detalles de compra para el proveedor y fecha especificados.");
            JOptionPane.showMessageDialog(null, "No se encontraron detalles de compra para el proveedor y fecha especificados.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException e) {
        e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Ocurrió un error al buscar los detalles de compra.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    return detallesEncontrados;

}
}