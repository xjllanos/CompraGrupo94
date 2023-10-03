/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compragrupo94;

import compragrupo94.AccesoADatos.Conexion;
import java.sql.Connection;

/**
 *
 * @author JATil
 */
public class CompraGrupo94 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection con = Conexion.getConexion(); 
    }
    
}
