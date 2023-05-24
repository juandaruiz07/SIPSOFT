package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.repo.CargoRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CargoTest {


    @Autowired
    private CargoRepo cargoRepo;

    // Importante: No hacer las pruebas con datos registrados en la BD


    @Test
     void guardarCargo() {
        int r;
        String codigo = "6";
        String descripcion = "Administrador";
        r = cargoRepo.guardarCargo(codigo,descripcion);
        Assertions.assertNotNull(r);
    }


    @Test
     void actualizarCargo() {
        String codigo = "6";
        String descripcion = "Administrador";
        int r = cargoRepo.guardarCargo("6", descripcion);

        int a = cargoRepo.actualizarCargo("6", "SubAdministrador");

        Assertions.assertNotNull(a);

    }

    @Test
     void buscarCargo() {

        Object encontrado = new Object();
        String codigo = "6";
        String descripcion = "Administrador";
        int r = cargoRepo.guardarCargo(codigo, descripcion);

        encontrado = cargoRepo.buscarCargo("1");

        Assertions.assertNotNull(encontrado);

    }

    @Test
    void eliminarCargo(){

        Object encontrado = new Object();
        String codigo = "6";
        String descripcion = "Administrador";
        int r = cargoRepo.guardarCargo(codigo, descripcion);

        int e= cargoRepo.eliminarCargo("6");
        Assertions.assertNotNull(e);
    }


}
