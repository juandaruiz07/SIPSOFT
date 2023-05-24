package co.edu.uniquindio.proyecto.servicios2;

import co.edu.uniquindio.proyecto.entidades2.Producto2;
import co.edu.uniquindio.proyecto.repo.ProductoRepo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class Producto2ServicioImpl implements ProductoServicio2 {

    @Autowired
    private ProductoRepo2 productoRepo2;

    public Producto2ServicioImpl(ProductoRepo2 productoRepo2) {
        this.productoRepo2 = productoRepo2;
    }


    @Override
    public List<Producto2> obtenerProductos() throws Exception {

        List<Producto2> productosStock = new ArrayList<>();

        productosStock = productoRepo2.traerProductos();

        System.out.println("Productos encontrados en el servicio " + productosStock.size());

        if (productosStock==null) {

            throw new Exception("No hay productos registrados");

        }

        return productosStock;
    }

    @Override
    public int registrarProducto(Producto2 p) throws Exception {
        int r = 0;

        Producto2 pb = productoRepo2.buscarProductoC(p.getCodigo());

        if (pb != null) {
            throw new Exception("El producto que desea guardar ya se encuentra registrado");

        } else {
            r = productoRepo2.guardarProducto(p.getCodigo(), p.getCantidad(), p.getCategoria(), p.getNombre(), p.getPrecioCompra(), p.getPrecioVenta());


        }
        return r;
    }

    @Override
    @Transactional
    public int actualizarProducto(Producto2 p) throws Exception {

        System.out.println("Entro a actualizar Producto");

        int r = 0;

        Producto2 pb = productoRepo2.buscarProducto(p.getCodigo());
        System.out.println("Encontro producto pb " + pb.getNombre());


        if (pb != null) {
            String inventario;
            String proveedor;

            inventario = "Inventario de prueba";
            proveedor = "Proveedor de prueba";

            r = productoRepo2.actualizarProducto(p.getCodigo(), p.getCantidad(), p.getCategoria(), p.getNombre(), p.getPrecioCompra(), p.getPrecioVenta());

            return r;

        } else {
            throw new Exception("El producto que desea actualizar no se encuentra registrado");
//p.getInventario().getCodigo();p.getProveedor().getNit();

        }

    }

    @Override
    public Producto2 BuscarProducto(String codigo) throws Exception {

        Producto2 producto2 = productoRepo2.buscarProductoC(codigo);

        if (producto2 == null) {

            throw new Exception("El producto que desea buscar no se encuentra registrado");


        } else {

            return producto2;
        }

    }

    @Override
    public Boolean eliminarPrducto(String codigo) throws Exception {
        int r = 0;
        Producto2 producto2 = productoRepo2.buscarProductoC(codigo);

        if (producto2 == null) {

            throw new Exception("El producto que desea eliminar no se encuentra registrado");


        } else {


            r = productoRepo2.eliminarProducto(codigo);
            if (r != 0) {

                return true;
            }
        }
        return false;
    }

    @Override
    public Producto2 buscarC(String cedula) throws Exception {
        return null;
    }

    @Override
    public Producto2 buscarProducto(String nombreProducto) throws Exception {

        Producto2 pEncontrado = productoRepo2.buscarProductoNombre(nombreProducto);

        if (pEncontrado == null) {

            throw new Exception("Busquedad por nombre no dio resultado");

        } else {

            return pEncontrado;
        }


    }

    @Override
    public int actualizarProductoVendido(Producto2 p) throws Exception {
        int actualizar = 0;
        actualizar = productoRepo2.actualizarProductoVendido(p);
        if (actualizar != 0) {
            return actualizar;
        } else {
            throw new Exception("No se pudo actualizar el producto");
        }

    }

    @Override
    public List<Producto2> productosBajaCantidad() throws Exception {
        List<Producto2> p= new ArrayList<>();

        p=productoRepo2.obtenerProductosLow();

        if(p!= null && !p.isEmpty()){
            return p;
        }else{
            throw new Exception("No hay productos con baja cantidad");
        }
    }


}
