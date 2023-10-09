
package compragrupo94.AccesoADatos;

import compragrupo94.Entidades.DetalleCompra;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class DetalleCompraData {

    private List<DetalleCompra> detallesCompra;
    private Connection con;

    public DetalleCompraData() {
        con = Conexion.getConexion();
        detallesCompra = new ArrayList<>(); 
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
}
 
