package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades2.Cliente;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class ClienteRepoImpl implements ClienteRepo {

    @PersistenceContext
    EntityManager entityManager = null;

    @Override
    public Integer guardarCliente(String cedula, String direccion, String nombre, String correo, String nit) {

        int r = entityManager.createNativeQuery("INSERT INTO cliente (cedula, direccion, nombre,correo,nit) VALUES (?,?,?,?,?)")
                .setParameter(1, cedula)
                .setParameter(2, direccion)
                .setParameter(3, nombre)
                .setParameter(4, correo)
                .setParameter(5, nit)
                .executeUpdate();


        return r;
    }

    @Override
    public Integer actualizarCliente(String cedula, String direccion, String nombre, String nit, String correo) {

        int r = entityManager.createNativeQuery("UPDATE cliente SET direccion=? , nombre=?,nit=?,correo=? WHERE cedula=?")
                .setParameter(1, direccion)
                .setParameter(2, nombre)
                .setParameter(3, nit)
                .setParameter(4, correo)
                .setParameter(5, cedula)
                .executeUpdate();


        return r;
    }

    @Override
    public Object buscarCliente(String cedula) {

        Cliente clienteEncontrado = null;
        List<Cliente> c = new ArrayList<>();

        c = entityManager.createNativeQuery("SELECT * FROM cliente WHERE cedula= ?")
                .setParameter(1, cedula)
                .getResultList();

        if(!c.isEmpty()) {
            System.out.println("Encontro un cliente");
            clienteEncontrado = c.get(0);

            return (Cliente) clienteEncontrado;
        }else{
            return null;
        }
    }

    @Override
    public Integer eliminarCliente(String cedula) {

        Integer eliminados = 0;

        eliminados = entityManager.createNativeQuery("DELETE FROM cliente WHERE cedula = ?")
                .setParameter(1, cedula)
                .executeUpdate();

        return eliminados;
    }

    @Override
    public Cliente findByCedula(String cedula) {
        return null;
    }

    @Override
    public Cliente obtenerCliente(String cedula) {
        return null;
    }

    @Override
    public Cliente actualizarCli(String cedula, String direccion, String nombre, String nit, String correo) {
        return null;
    }


    @Override
    public List<Cliente> findAll() {
        return null;
    }

    @Override
    public List<Cliente> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Cliente> findAllById(Iterable<String> iterable) {
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
    public void delete(Cliente cliente) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Cliente> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Cliente> S save(S s) {
        return null;
    }

    @Override
    public <S extends Cliente> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Cliente> findById(String s) {
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
    public <S extends Cliente> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Cliente> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Cliente> iterable) {

    }

    @Override
    public void deleteAllInBatch(Iterable<Cliente> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Cliente getOne(String s) {
        return null;
    }

    @Override
    public Cliente getById(String s) {
        return null;
    }

    @Override
    public <S extends Cliente> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Cliente> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Cliente> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Cliente> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Cliente> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Cliente> boolean exists(Example<S> example) {
        return false;
    }
}
