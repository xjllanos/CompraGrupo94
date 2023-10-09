
package compragrupo94;

import compragrupo94.AccesoADatos.CompraData;
import compragrupo94.AccesoADatos.Conexion;
import compragrupo94.AccesoADatos.DetalleCompraData;
import compragrupo94.AccesoADatos.ProductoData;
import compragrupo94.AccesoADatos.ProveedorData;
import compragrupo94.Entidades.Compras;
import compragrupo94.Entidades.DetalleCompra;
import compragrupo94.Entidades.Producto;
import compragrupo94.Entidades.Provedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public class CompraGrupo94 {
    


    
    public static void main(String[] args) throws SQLException {
        Connection con = Conexion.getConexion(); 
        //****PRODUCTO*****//
        //Producto pro = new Producto (6,"Gamer Masterbox MB320L", "Gabinete Gamer",85.000,5,true);
        //ProductoData pd = new ProductoData (); 
        
        
        //pd.guardarProducto(pro); //FUNCIONA
        
        //pd.modificarProducto(pro); //FUNCIONA DE 80 PASO A "85" Y EL STOCK DE 4 PASO A "5"   
       
        //pd.eliminarProducto(6); //FUNCIONA IdProducto "6" PASO A ESTADO 0  
                
        //NUEVO "ProductoData" PARA LLAMAR A LISTA DE PRODUCTOS 
   
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
        
        //***** PROVEEDOR *****//
        /*Provedor prov = new Provedor (1,"Compusystems", "Belgrano 111",266477777,true);
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
        }*/
        
        
        //*****COMPRAS*****//
        //Compras pro = new Compras (4,6,LocalDate.of(2020, 05, 23));
        //CompraData pd = new CompraData ();
        
        
        //pd.AgregarCompra(pro);//FUNCIONA
        
        //pd.modificarCompra(pro);//FUNCIONA
       
        //pd.eliminarCompra(3); //FUNCIONA 
         
        
        //*****Buscar compras*****// 
        /*CompraData com = new CompraData();
        for(Compras compra: com.buscarComprasPorFecha(LocalDate.of(2023, 4, 23))){
            System.out.println("idProveedor: "+ compra.getIdProvedor());
        };*/

                          //***DetalleCompraData***//
                          
         DetalleCompraData detalleCompraData = new DetalleCompraData();

        // Ejemplo de cómo usar los métodos
        List<DetalleCompra> detallesPorProveedor = detalleCompraData.ProductoPorProveedor(1); // Supongamos que 1 es el ID del proveedor
        List<DetalleCompra> detallesPorCompra = detalleCompraData.ProductoPorCompra(1); // Supongamos que 1 es el ID de la compra
        double precioFinal = detalleCompraData.PrecioFinal(1); // Supongamos que 1 es el ID de la compra
        int cantidadProducto = detalleCompraData.CantidadesProducto(1); // Supongamos que 1 es el ID del producto

        // Mostrar los resultados
        System.out.println("Detalles por proveedor:");
        for (DetalleCompra detalle : detallesPorProveedor) {
            System.out.println(detalle.getIdDetalle() + ", " + detalle.getCantidad() + ", " + detalle.getPrecioCosto() + ", " + detalle.getIdCompra() + ", " + detalle.getIdProducto());
        }

        System.out.println("Detalles por compra:");
        for (DetalleCompra detalle : detallesPorCompra) {
            System.out.println(detalle.getIdDetalle() + ", " + detalle.getCantidad() + ", " + detalle.getPrecioCosto() + ", " + detalle.getIdCompra() + ", " + detalle.getIdProducto());
        }

        System.out.println("Precio Final: " + precioFinal);
        System.out.println("Cantidad de producto: " + cantidadProducto);
    }
}  
    

  

    
    

