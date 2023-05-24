package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades2.TipoContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoContratoRepo extends JpaRepository<TipoContrato, String> {

   Integer guardarTipoContrato(String codigo,String descripcion);



   Integer actualizarTipoContrato(String codigo,String descripcion);


   Object buscarTipoContrato(String codigo);

   Integer eliminarTipoContrato(String codigo);

   @Query("select tc from TipoContrato tc ")
   List<TipoContrato> listarContratos();

   @Query("select tc from TipoContrato tc where tc.tipo=:id")
   TipoContrato buscarContratoPorId(String id);


    void deleteAllById(Iterable<? extends String> iterable);

   <S extends TipoContrato> List<S> saveAllAndFlush(Iterable<S> iterable);

   void deleteAllInBatch(Iterable<TipoContrato> iterable);

   void deleteAllByIdInBatch(Iterable<String> iterable);

   TipoContrato getById(String s);
}
