
package compragrupo94.AccesoADatos;

import compragrupo94.Entidades.DetalleCompra;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DetalleCompraData {

public class DetalleCompraDAO {
   private Connection connection;


    public List<DetalleCompra> productoFechaDeterminada(Date fecha) throws SQLException {
        List<DetalleCompra> detalles = new ArrayList<>();
        String sql = "SELECT * FROM DetalleCompra WHERE fecha = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDate(1, fecha);
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

    public List<DetalleCompra> ProductoPorProveedor(int proveedorId) throws SQLException {
        List<DetalleCompra> detalles = new ArrayList<>();
        String sql = "SELECT d.* FROM DetalleCompra d " +
                     "JOIN Compra c ON d.idCompra = c.idCompra " +
                     "JOIN Proveedor p ON c.idProveedor = p.idProveedor " +
                     "WHERE p.idProveedor = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, proveedorId);
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

    public List<DetalleCompra> ProductoPorCompra(int compraId) throws SQLException {
        List<DetalleCompra> detalles = new ArrayList<>();
        String sql = "SELECT * FROM DetalleCompra WHERE idCompra = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, compraId);
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

    public List<DetalleCompra> ProductoEntreFechas(Date fechaInicio, Date fechaFin) throws SQLException {
        List<DetalleCompra> detalles = new ArrayList<>();
        String sql = "SELECT d.* FROM DetalleCompra d " +
                     "JOIN Compra c ON d.idCompra = c.idCompra " +
                     "WHERE c.fecha BETWEEN ? AND ?";
        PreparedStatement statement = connection.prepareStatement(sql);
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
}
}

