package co.edu.uniquindio.proyecto.repo;


import co.edu.uniquindio.proyecto.entidades2.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProveedorRepo extends JpaRepository<Proveedor, String> {


    @Query("select p from Proveedor p where p.nit=:nombre")
    Proveedor buscarProveedor(String nombre);


    @Override
    List<Proveedor> findAll();
}
