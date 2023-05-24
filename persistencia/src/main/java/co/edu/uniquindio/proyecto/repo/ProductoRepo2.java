package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades2.Producto2;
import co.edu.uniquindio.proyecto.entidades2.TipoContrato;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductoRepo2 extends JpaRepository<Producto2, String> {


    Integer guardarProducto(String codigo,int cantidad, String categoria, String nombre, double precioCompra, double precioVenta);

    Integer actualizarProducto(String codigo, int cantidad, String categoria, String nombre, double precioCompra, double precioVenta);

    Producto2 buscarProducto(String codigo);

    Integer eliminarProducto(String codigo);


    @Query("select p from Producto2 p where p.codigo=:codigo")
    Producto2 buscarProductoC(String codigo);





    List<Producto2> traerProductos();

    List<Producto2> obtenerProductosLow();

    Integer actualizarProductoVendido(Producto2 producto);


    Producto2 buscarProductoNombre(String nombre);


    void deleteAllById(Iterable<? extends String> iterable);

    <S extends Producto2> List<S> saveAllAndFlush(Iterable<S> iterable);

    void deleteAllInBatch(Iterable<Producto2> iterable);

    void deleteAllByIdInBatch(Iterable<String> iterable);

    Producto2 getById(String s);
}
