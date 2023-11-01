/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compragrupo94.DataTransferObject;

import compragrupo94.Entidades.DetalleCompra;

/**
 *
 * @author JATil
 */

public class DetalleComprasDTO { 
    private int idDetalle;
    private int cantidad;
    private double precioCosto;
    private int idCompra;
    private int idProducto ;
    private String nombreProducto ;
    private String descripcion ;
    private double precioActual;
    private int stock ;
    private boolean estado ; 

    public DetalleComprasDTO(int idProducto, String nombreProducto, String descripcion, double precioActual, int stock, boolean estado){}
            
    public DetalleComprasDTO(int idDetalle, int cantidad, double precioCosto, int idCompra, int idProducto) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.precioCosto = precioCosto;
        this.idCompra = idCompra;
        this.idProducto = idProducto;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public int getIdProducto() {
        return idProducto;
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
    public String getNombre() {
        return nombreProducto;
    }

    public void setNombre(String nombre) {
        this.nombreProducto = nombre;
    }
}
