package compragrupo94;

import compragrupo94.AccesoADatos.CompraData;
import compragrupo94.AccesoADatos.Conexion;
import compragrupo94.AccesoADatos.DetalleCompraData;
import compragrupo94.AccesoADatos.ProductoData;
import compragrupo94.AccesoADatos.ProveedorData;
import compragrupo94.DataTransferObject.DetalleComprasDTO;
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
                          
       DetalleCompraData detalleData = new DetalleCompraData();
    
               //obtener detalles entre dos fechas
        try {
            LocalDate fechaInicio = LocalDate.of(2023, 10, 1);
            LocalDate fechaFin = LocalDate.of(2023, 10, 7);
            List<DetalleCompra> detallesEntreFechas = detalleData.ProductoEntreFechas(Date.valueOf(fechaInicio), Date.valueOf(fechaFin));
            System.out.println("Detalles entre " + fechaInicio + " y " + fechaFin + ":");
            for (DetalleCompra detalle : detallesEntreFechas) {
                System.out.println(detalle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

           // Otros detalles del proveedor
        int idProveedor = 1; 
        List<DetalleCompra> detallesPorProveedor = detalleData.ProductoPorProveedor(idProveedor);
        System.out.println("\nDetalles del proveedor con ID " + idProveedor + ":");
        for (DetalleCompra detalle : detallesPorProveedor) {
            System.out.println(detalle);
        }


         // detalles de la compra 

        int idCompra = 2; 
        List<DetalleCompra> detallesPorCompra = detalleData.ProductoPorCompra(idCompra);
        System.out.println("\nDetalles de la compra con ID " + idCompra + ":");
        for (DetalleCompra detalle : detallesPorCompra) {
            System.out.println(detalle);
        }

               //  cuántos productos con ID se ha comprado
        int idProducto = 3;  
        int totalCantidad = detalleData.CantidadesProducto(idProducto);
        System.out.println("\nTotal de productos con ID " + idProducto + " comprados: " + totalCantidad);

        int idCompra2 = 1; // Supongamos que queremos el precio final de la compra con ID 1
        double precioFinal = detalleData.PrecioFinal(idCompra2);
        System.out.println("\nPrecio final de la compra con ID " + idCompra2 + ": " + precioFinal);

        // buscar detalles por proveedor y fecha

        String razonSocialProveedor = "Proveedor1"; 
        LocalDate fechaSeleccionada = LocalDate.of(2023, 10, 5); 
        List<DetalleComprasDTO> detallesEncontrados = detalleData.buscarDetallesPorProveedorYFecha(razonSocialProveedor, fechaSeleccionada);
        System.out.println("\nDetalles encontrados para el proveedor " + razonSocialProveedor + " y la fecha " + fechaSeleccionada + ":");
        for (DetalleCompra detalle : detallesEncontrados) {
            System.out.println(detalle);
        }
    }
 
}  