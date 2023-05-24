package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades2.Producto2;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Transactional
public class ProductoRepo2Impl implements ProductoRepo2 {


    @PersistenceContext
    EntityManager entityManager = null;


    @Override

    public Integer guardarProducto(String codigo, int cantidad, String categoria, String nombre, double precioCompra, double precioVenta) {
        int r = entityManager.createNativeQuery("INSERT INTO producto2 (codigo,cantidad,categoria,nombre,precio_compra,precio_venta) VALUES (?,?,?,?,?,?)")
                .setParameter(1, codigo)
                .setParameter(2, cantidad)
                .setParameter(3, categoria)
                .setParameter(4, nombre)
                .setParameter(5, precioCompra)
                .setParameter(6, precioVenta)
                .executeUpdate();

        return r;
    }

    @Override
    public Integer actualizarProducto(String codigo, int cantidad, String categoria, String nombre, double precioCompra, double precioVenta) {
        int r;

        r = entityManager.createNativeQuery("UPDATE producto2 SET cantidad = ?,categoria=?,nombre=?,precio_compra=?, precio_venta=? WHERE codigo=?")
                .setParameter(1, cantidad)
                .setParameter(2, categoria)
                .setParameter(3, nombre)
                .setParameter(4, precioCompra)
                .setParameter(5, precioVenta)
                .setParameter(6, codigo)
                .executeUpdate();


        return r;
    }

    @Override
    public Producto2 buscarProducto(String codigo) {
        List<Producto2> p = null;
        p = entityManager.createNativeQuery("SELECT * FROM  producto2  WHERE codigo=?", Producto2.class)
                .setParameter(1, codigo)
                .getResultList();

        if (!p.isEmpty()) {
            return p.get(0);
        }

        return null;
    }

    @Override
    public Integer eliminarProducto(String codigo) {
        int r = entityManager.createNativeQuery("DELETE FROM producto2 WHERE codigo = ?")
                .setParameter(1, codigo)
                .executeUpdate();

        return r;
    }

    @Override
    public Producto2 buscarProductoC(String codigo) {
        return null;
    }

    @Override
    public List<Producto2> traerProductos() {

        List<Producto2> productos = entityManager.createNativeQuery("SELECT * FROM producto2", Producto2.class)
                .getResultList();

        return productos;
    }

    @Override
    public List<Producto2> obtenerProductosLow() {
        List<Producto2> productosLow = entityManager.createNativeQuery("SELECT * FROM producto2 WHERE  cantidad <=10", Producto2.class)
                .getResultList();
        return productosLow;

    }

    @Override
    @Transactional
    public Integer actualizarProductoVendido(Producto2 producto2) {

        int r;
        r = entityManager.createNativeQuery("UPDATE producto2 SET cantidad = ? WHERE codigo=?")
                .setParameter(1, producto2.getCantidad())
                .setParameter(2, producto2.getCodigo())
                .executeUpdate();

        return r;
    }

    @Override
    public Producto2 buscarProductoNombre(String nombre) {
        List<Producto2> productoEncontrado = entityManager.createNativeQuery("SELECT * FROM producto2 p where p.nombre = ? ", Producto2.class).setParameter(1, nombre).getResultList();
        if (!productoEncontrado.isEmpty()) {
            System.out.println("Encontro producto :" + productoEncontrado.get(0).getNombre());
            return productoEncontrado.get(0);

        }

        System.out.println("No Encontro producto");
        return null;
    }


    @Override
    public List<Producto2> findAll() {
        return null;
    }

    @Override
    public List<Producto2> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Producto2> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Producto2> findAllById(Iterable<String> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Producto2 producto2) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Producto2> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Producto2> S save(S s) {
        return null;
    }

    @Override
    public <S extends Producto2> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Producto2> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Producto2> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Producto2> iterable) {

    }

    @Override
    public <S extends Producto2> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Producto2> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Producto2 getOne(String s) {
        return null;
    }

    @Override
    public Producto2 getById(String s) {
        return null;
    }

    @Override
    public <S extends Producto2> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Producto2> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Producto2> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Producto2> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Producto2> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Producto2> boolean exists(Example<S> example) {
        return false;
    }
}
