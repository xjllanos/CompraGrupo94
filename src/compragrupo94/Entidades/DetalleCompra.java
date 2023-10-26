
package compragrupo94.Entidades;

import java.time.LocalDate;

public class DetalleCompra {
    private int idDetalle;
    private int cantidad;
    private double precioCosto;
    private int idCompra;
    private int idProducto;
    private int idProveedor; 
    private LocalDate fecha; 


    public DetalleCompra(int idDetalle, int cantidad, double precioCosto, int idCompra, int idProducto) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.precioCosto = precioCosto;
        this.idCompra = idCompra;
        this.idProducto = idProducto;
        this.idProveedor= idProveedor;
        this.fecha = fecha;
    }

    public DetalleCompra(int cantidad, double precioCosto, int idCompra, int idProducto) {
        this.cantidad = cantidad;
        this.precioCosto = precioCosto;
        this.idCompra = idCompra;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
        this.fecha = fecha;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
 




