package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades2.TipoContrato;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Transactional
public class TipoContratoRepoImpl implements TipoContratoRepo {

    @PersistenceContext
    EntityManager entityManager = null;


    @Override
    @Transactional
    public Integer guardarTipoContrato(String codigo, String tipo) {
        int r = entityManager.createNativeQuery("INSERT INTO tipo_contrato (codigo, tipo) VALUES (?,?)")
                .setParameter(1, codigo)
                .setParameter(2, tipo)
                .executeUpdate();

        return r;
    }

    @Override
    public Integer actualizarTipoContrato(String codigo, String tipo) {
        int r = entityManager.createNativeQuery("UPDATE  tipo_contrato   SET tipo = ?   WHERE codigo= ?")
                .setParameter(1, tipo)
                .setParameter(2, codigo)
                .executeUpdate();


        return r;
    }

    @Override
    public Object buscarTipoContrato(String codigo) {
        List<Object> e = null;

        e = entityManager.createNativeQuery("SELECT * FROM  tipo_contrato  WHERE codigo=?")
                .setParameter(1, codigo)
                .getResultList();


        if (!e.isEmpty()) {
            return e.get(0);
        }

        return null;
    }

    @Override
    public Integer eliminarTipoContrato(String codigo) {
        int r = entityManager.createNativeQuery("DELETE FROM tipo_contrato WHERE codigo = ?")
                .setParameter(1, codigo)
                .executeUpdate();

        return r;
    }

    @Override
    public List<TipoContrato> listarContratos() {
        return null;
    }

    @Override
    public TipoContrato buscarContratoPorId(String id) {
        return null;
    }


    @Override
    public List<TipoContrato> findAll() {
        return null;
    }

    @Override
    public List<TipoContrato> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<TipoContrato> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<TipoContrato> findAllById(Iterable<String> iterable) {
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
    public void delete(TipoContrato tipoContrato) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends TipoContrato> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends TipoContrato> S save(S s) {
        return null;
    }

    @Override
    public <S extends TipoContrato> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<TipoContrato> findById(String s) {
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
    public <S extends TipoContrato> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends TipoContrato> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<TipoContrato> iterable) {

    }

    @Override
    public void deleteAllInBatch(Iterable<TipoContrato> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public TipoContrato getOne(String s) {
        return null;
    }

    @Override
    public TipoContrato getById(String s) {
        return null;
    }

    @Override
    public <S extends TipoContrato> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends TipoContrato> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends TipoContrato> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends TipoContrato> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends TipoContrato> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends TipoContrato> boolean exists(Example<S> example) {
        return false;
    }
}
