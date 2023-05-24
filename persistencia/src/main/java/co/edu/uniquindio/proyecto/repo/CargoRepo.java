package co.edu.uniquindio.proyecto.repo;


import co.edu.uniquindio.proyecto.entidades2.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CargoRepo extends JpaRepository<Cargo, String> {


    Integer guardarCargo(String codigo,String descripcion);
   Integer actualizarCargo(String codigo,String descripcion);
   Object buscarCargo(String codigo);
   Integer eliminarCargo(String codigo);


    @Override
    List<Cargo> findAll();

    @Query("select c from Cargo c")
    List<Cargo>listarCargos();

    @Query("select c from Cargo c where c.codigo=:codigo")
    Cargo buscarCargoId(String codigo);

    @Query("select c.codigo from Cargo c where c.descripcion=:nombre")

    String buscarIdCargo(String nombre);

    void deleteAllById(Iterable<? extends String> iterable);

    <S extends Cargo> List<S> saveAllAndFlush(Iterable<S> iterable);

    void deleteAllInBatch(Iterable<Cargo> iterable);

    void deleteAllByIdInBatch(Iterable<String> iterable);

    Cargo getById(String s);
}
