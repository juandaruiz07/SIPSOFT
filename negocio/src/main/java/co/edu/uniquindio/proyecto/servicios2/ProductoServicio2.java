package co.edu.uniquindio.proyecto.servicios2;

import co.edu.uniquindio.proyecto.entidades2.Producto2;

import java.util.List;

public interface ProductoServicio2 {

    List<Producto2> obtenerProductos()throws Exception;


    int registrarProducto(Producto2 p) throws Exception;
    int actualizarProducto(Producto2 p)throws Exception;


    Producto2 BuscarProducto(String codigo)throws Exception;
    Boolean eliminarPrducto(String codigo)throws Exception;

    Producto2 buscarC(String cedula)throws Exception;

    Producto2 buscarProducto(String nombreProducto)throws Exception;



    int actualizarProductoVendido(Producto2 p)throws  Exception;


    List<Producto2> productosBajaCantidad()throws Exception;
}
