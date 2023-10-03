
package compragrupo94.Entidades;


public class Producto {
    private int idProducto ;
    private String nombrePorducto ;
    private String descripcion ;
    private double precioActual;
    private int stock ;
    private boolean estado ; 

    public Producto() {
    }

    public Producto(int idProducto, String nombrePorducto, String descripcion, double precioActual, int stock, boolean estado) {
        this.idProducto = idProducto;
        this.nombrePorducto = nombrePorducto;
        this.descripcion = descripcion;
        this.precioActual = precioActual;
        this.stock = stock;
        this.estado = estado;
    }

    public Producto(String nombrePorducto, String descripcion, double precioActual, int stock, boolean estado) {
        this.nombrePorducto = nombrePorducto;
        this.descripcion = descripcion;
        this.precioActual = precioActual;
        this.stock = stock;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombrePorducto() {
        return nombrePorducto;
    }

    public void setNombrePorducto(String nombrePorducto) {
        this.nombrePorducto = nombrePorducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
