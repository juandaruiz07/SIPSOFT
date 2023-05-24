package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades2.Factura;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
public class FacturaRepoImpl implements FacturaRepo {


    @PersistenceContext
    EntityManager entityManager = null;

    @Override
    public Integer guardarFactura(String codigo, LocalDateTime fecha, String medioPago, String tipo, double valorTotal) {
        int r = entityManager.createNativeQuery("INSERT INTO factura (codigo, fecha,medio_de_pago,tipo,valor_total) VALUES (?,?,?,?,?)")
                .setParameter(1, codigo)
                .setParameter(2, fecha)
                .setParameter(3, medioPago)
                .setParameter(4, tipo)
                .setParameter(5, valorTotal)
                .executeUpdate();

        return r;
    }

    @Override
    public Integer actualizarFactura(String codigo, String medioPago, String tipo, double valorTotal) {
        int r;
        r = entityManager.createNativeQuery("UPDATE factura SET medio_de_pago = ?,tipo=?,valor_total=? WHERE codigo=?")
                .setParameter(1, medioPago)
                .setParameter(2, tipo)
                .setParameter(3, valorTotal)
                .setParameter(4, codigo)
                .executeUpdate();


        return r;
    }

    @Override
    public Object buscarFactura(String codigo) {

        List<Object> e = null;
        e = entityManager.createNativeQuery("SELECT * FROM  factura  WHERE codigo=?")
                .setParameter(1, codigo)
                .getResultList();

        if (!e.isEmpty()) {
            return e.get(0);
        }

        return null;
    }

    @Override
    public Integer eliminarFactura(String codigo) {
        int r = entityManager.createNativeQuery("DELETE FROM factura WHERE codigo = ?")
                .setParameter(1, codigo)
                .executeUpdate();

        return r;
    }

    @Override
    public Factura buscarFacturaC(String codigo) {
        return null;
    }


    @Override
    public List<Factura> findAll() {
        return null;
    }

    @Override
    public List<Factura> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Factura> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Factura> findAllById(Iterable<String> iterable) {
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
    public void delete(Factura factura) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Factura> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Factura> S save(S s) {
        return null;
    }

    @Override
    public <S extends Factura> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Factura> findById(String s) {
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
    public <S extends Factura> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Factura> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Factura> iterable) {

    }

    @Override
    public void deleteAllInBatch(Iterable<Factura> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Factura getOne(String s) {
        return null;
    }

    @Override
    public Factura getById(String s) {
        return null;
    }

    @Override
    public <S extends Factura> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Factura> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Factura> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Factura> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Factura> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Factura> boolean exists(Example<S> example) {
        return false;
    }
}
