package co.edu.uniquindio.proyecto.repo;


import co.edu.uniquindio.proyecto.entidades2.Cargo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class CargoRepoImpl implements CargoRepo {

    @PersistenceContext
    EntityManager entityManager ;


    @Override
    @Transactional
    public Integer guardarCargo(String codigo, String descripcion) {
        int r = entityManager.createNativeQuery("INSERT INTO cargo (codigo, descripcion) VALUES (?,?)")
                .setParameter(1, codigo)
                .setParameter(2, descripcion)
                .executeUpdate();
        return r;
    }

    @Override
    public Integer actualizarCargo(String codigo, String descripcion) {


        int r = entityManager.createNativeQuery("UPDATE  cargo   SET descripcion= ?   WHERE codigo= ?")
                .setParameter(1, descripcion)
                .setParameter(2, codigo)
                .executeUpdate();


        return r;
    }

    @Override
    public Object buscarCargo(String codigo) {
        Object cargoEncontrado = null;

        cargoEncontrado = entityManager.createNativeQuery("SELECT * FROM cargo WHERE codigo= ?")
                .setParameter(1, codigo)
                .getSingleResult();

        return cargoEncontrado;
    }

    @Override
    public Integer eliminarCargo(String codigo) {
        Integer eliminados = 0;

        eliminados = entityManager.createNativeQuery("DELETE FROM cargo WHERE codigo = ?")
                .setParameter(1, codigo)
                .executeUpdate();

        return eliminados;
    }


    @Override
    public List<Cargo> findAll() {
        return null;
    }

    @Override
    public List<Cargo> listarCargos() {
        return null;
    }

    @Override
    public Cargo buscarCargoId(String codigo) {
        return null;
    }

    @Override
    public String buscarIdCargo(String nombre) {
        return null;
    }

    @Override
    public List<Cargo> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Cargo> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Cargo> findAllById(Iterable<String> iterable) {
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
    public void delete(Cargo cargo) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Cargo> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Cargo> S save(S s) {
        return null;
    }

    @Override
    public <S extends Cargo> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Cargo> findById(String s) {
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
    public <S extends Cargo> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Cargo> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Cargo> iterable) {

    }

    @Override
    public void deleteAllInBatch(Iterable<Cargo> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Cargo getOne(String s) {
        return null;
    }

    @Override
    public Cargo getById(String s) {
        return null;
    }

    @Override
    public <S extends Cargo> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Cargo> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Cargo> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Cargo> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Cargo> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Cargo> boolean exists(Example<S> example) {
        return false;
    }
}
