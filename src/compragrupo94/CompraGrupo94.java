
package compragrupo94;

import compragrupo94.AccesoADatos.Conexion;
import compragrupo94.AccesoADatos.ProductoData;
import compragrupo94.AccesoADatos.ProveedorData;
import compragrupo94.Entidades.Producto;
import compragrupo94.Entidades.Provedor;
import java.sql.Connection;


public class CompraGrupo94 {

    
    public static void main(String[] args) {
        Connection con = Conexion.getConexion(); 
        //Producto pro = new Producto (6,"Gamer Masterbox MB320L", "Gabinete Gamer",85.000,5,true);
        //ProductoData pd = new ProductoData (); 
        
        //pd.guardarProducto(pro); FUNCIONA
        
        //pd.modificarProducto(pro); FUNCIONA DE 80 PASO A "85" Y EL STOCK DE 4 PASO A "5"   
       
        //pd.eliminarProducto(6); FUNCIONA IdProducto "6" PASO A ESTADO 0  
                
        //NUEVO "ProductoData" PARA LLAMAR A LISTA DE PRODUCTOS 
        ProductoData prod = new ProductoData (); 
        /*
        for (Producto producto: prod.listarProductos()){
            System.out.println(producto.getNombreProducto());
            System.out.println(producto.getDescripcion());
            System.out.println(producto.getPrecioActual());
            System.out.println(producto.getStock());
            //FUNCIONA MUESTRA LOS PRODUCTOS CON EL ESTADO "1"
        }
        */
        
        /*
        System.out.println(" ORDEN POR PRECIO ACTUAL : ");
        for (Producto producto: prod.productosMinimo("precioActual")){
            System.out.println("Producto: " + producto.getNombreProducto() 
                    + " - Descripcion: " + producto.getDescripcion() 
                    + " - Precio Actual: " + producto.getPrecioActual() 
                    + " - Stock: " + producto.getStock());
        }
        System.out.println(" ------------------------------------------ ");
        System.out.println(" ORDEN POR STOCK : ");
        for (Producto producto: prod.productosMinimo("stock")){
            System.out.println("Producto: " + producto.getNombreProducto() 
                    + " - Descripcion: " + producto.getDescripcion() 
                    + " - Precio Actual: " + producto.getPrecioActual() 
                    + " - Stock: " + producto.getStock());
        }
        System.out.println(" ------------------------------------------ ");
        */
        
        //***** PROVEEDOR *****
        Provedor prov = new Provedor (1,"Compusystems", "Belgrano 111",266477777,true);
        ProveedorData provd = new ProveedorData(); 
        
        //provd.guardarProveedor(prov); //FUNCIONA
        //provd.modificarProveedor(prov); //FUNCIONA
        //provd.eliminarProveedor(6); //FUNCIONA 
        ProveedorData prove = new ProveedorData(); 
        for (Provedor proveedor: prove.listarProveedores()){
            System.out.print(proveedor.getIdProveedor());
            System.out.print(" - ");
            System.out.print(proveedor.getRazonSocial());
            System.out.print(" - ");
            System.out.print(proveedor.getDomicilio());
            System.out.print(" - ");
            System.out.println(proveedor.getTelefono());
        }




    }
    
}
