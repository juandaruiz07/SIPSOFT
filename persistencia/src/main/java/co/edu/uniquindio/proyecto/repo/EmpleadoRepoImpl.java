package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades2.Empleado;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
public class EmpleadoRepoImpl implements EmpleadoRepo {


    @PersistenceContext
    EntityManager entityManager = null;



    @Override
    public Integer guardarEmpleado(String cedula, String direccion, String nombre, LocalDateTime fechaContratacion,String clave,String correo) {

        System.out.println("Entro al metodo guardarRepo");
        int r = entityManager.createNativeQuery("INSERT INTO Empleado (cedula, direccion,nombre,clave,fecha_contratacion,correo) VALUES (?,?,?,?,?,?)")
                .setParameter(1, cedula)
                .setParameter(2, direccion)
                .setParameter(3, nombre)
                .setParameter(4, clave)
                .setParameter(5,fechaContratacion)
                .setParameter(6,correo)
                .executeUpdate();

        return r;
    }

    @Override
    public Integer actualizarEmpleado(String cedula, String direccion,String correo, String idCargo, String jefeInmediato, String tipoContrato,String clave,String nombre) {

        int r;
        r = entityManager.createNativeQuery("UPDATE empleado SET direccion = ?,correo=?,cargo_codigo=?,jefe_inmediato_cedula=?,tipo_contrato_codigo=?,clave=?,nombre=? WHERE cedula=?")
                .setParameter(1, direccion)
                .setParameter(2,correo)
                .setParameter(3, idCargo)
                .setParameter(4, jefeInmediato)
                .setParameter(5, tipoContrato)
                .setParameter(6,clave)
                .setParameter(7,nombre)
                .setParameter(8, cedula)
                .executeUpdate();


        return r;
    }

    @Override
    public Object buscarEmpleado(String cedula) {

        Empleado empleadoEncontrado = new Empleado();

        List<Object> e = null;

        e = entityManager.createNativeQuery("SELECT * FROM  empleado  WHERE cedula=?")
                .setParameter(1, cedula)
                .getResultList();


        if (!e.isEmpty()) {
            return e.get(0);
        }

        return null;
    }

    @Override
    public Empleado buscarEmpleadoCorreo(String correo) {
        return null;
    }


    @Override
    public Integer eliminarEmpleado(String cedula) {

        int r = entityManager.createNativeQuery("DELETE FROM empleado WHERE cedula = ?")
                .setParameter(1, cedula)
                .executeUpdate();


        return r;
    }

    @Override
    public List<Empleado> listarEmpleados() {
        return null;
    }

    @Override
    public Empleado buscarEmpleadoId(String cedula) {
        return null;
    }

    @Override
    public Empleado buscarEmpleadoC(String cedula) {
        return null;
    }

    @Override
    public Empleado login(String cedula, String clave) {
        return null;
    }

    @Override
    public List<Empleado> empleadoCargo(String cargo) {
        return null;
    }


    @Override
    public List<Empleado> findAll() {
        return null;
    }

    @Override
    public List<Empleado> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Empleado> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Empleado> findAllById(Iterable<String> iterable) {
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
    public void delete(Empleado empleado) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends Empleado> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Empleado> S save(S s) {
        return null;
    }

    @Override
    public <S extends Empleado> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Empleado> findById(String s) {
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
    public <S extends Empleado> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends Empleado> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Empleado> iterable) {

    }

    @Override
    public void deleteAllInBatch(Iterable<Empleado> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Empleado getOne(String s) {
        return null;
    }

    @Override
    public Empleado getById(String s) {
        return null;
    }

    @Override
    public <S extends Empleado> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Empleado> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Empleado> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Empleado> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Empleado> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Empleado> boolean exists(Example<S> example) {
        return false;
    }


    //-----------------------------------------------------------------------------------------------------






}
