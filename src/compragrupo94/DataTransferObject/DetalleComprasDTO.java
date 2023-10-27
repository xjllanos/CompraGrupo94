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
public class DetalleComprasDTO extends DetalleCompra { 
    private String nombre ;
    
    public DetalleComprasDTO(int idDetalle, int cantidad, double precioCosto, int idCompra, int idProducto) {
        super(idDetalle, cantidad, precioCosto, idCompra, idProducto);
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
