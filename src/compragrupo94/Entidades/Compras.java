
package compragrupo94.Entidades;

import java.time.LocalDate;


public class Compras {
    private int idCompra; 
    private int idProvedor ;
    private LocalDate fecha ;

    public Compras() {
    }

    public Compras(int idCompra, int idProvedor, LocalDate fecha) {
        this.idCompra = idCompra;
        this.idProvedor = idProvedor;
        this.fecha = fecha;
    }

    public Compras(int idProvedor, LocalDate fecha) {
        this.idProvedor = idProvedor;
        this.fecha = fecha;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdProvedor() {
        return idProvedor;
    }

    public void setIdProvedor(int idProvedor) {
        this.idProvedor = idProvedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    @Override
    public String toString() {
        return "idCompra: "+ idCompra +" idProveedor: "+ idProvedor + " fecha: " + fecha ;
    }
    
}
