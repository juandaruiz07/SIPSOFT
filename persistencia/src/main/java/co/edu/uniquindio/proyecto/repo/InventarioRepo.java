package co.edu.uniquindio.proyecto.repo;

import co.edu.uniquindio.proyecto.entidades2.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface InventarioRepo extends JpaRepository<Inventario,String> {



    @Query("select i from Inventario i where i.categoria=:categoria")
    Inventario buscarPorid(String categoria);


    @Override
    List<Inventario> findAll();
}
