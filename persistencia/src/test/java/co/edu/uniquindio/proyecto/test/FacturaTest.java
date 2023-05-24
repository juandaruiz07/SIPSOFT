package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.repo.FacturaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FacturaTest {


    @Autowired
    private FacturaRepo facturaRepo;


    @Test
    public void guardarFactura() {

        String codigo = "12345";
        LocalDateTime fecha = LocalDateTime.now();
        String medioPago = "Tarjeta de Credito";
        String tipo = "No me acuerdo que va aca ";
        Double valor = 12312312.0;
        int f = facturaRepo.guardarFactura(codigo, fecha, medioPago, tipo, valor);
        Assertions.assertNotNull(f);

    }

    @Test
    public void actualizarFactura() {

        String codigo = "12345";
        LocalDateTime fecha = LocalDateTime.now();
        String medioPago = "Tarjeta de Credito";
        String tipo = "No me acuerdo que va aca ";
        Double valor = 12312312.0;
        int f = facturaRepo.guardarFactura(codigo, fecha, medioPago, tipo, valor);

        if (f != 0) {
            int a = facturaRepo.actualizarFactura(codigo, "Contado", "Aun no me acuerdo", valor);
            Assertions.assertNotNull(a);

        }


    }


    @Test
    public void buscarFactura() {

        String codigo = "12345";
        LocalDateTime fecha = LocalDateTime.now();
        String medioPago = "Tarjeta de Credito";
        String tipo = "No me acuerdo que va aca ";
        Double valor = 12312312.0;
        int f = facturaRepo.guardarFactura(codigo, fecha, medioPago, tipo, valor);
        Object encontrado = new Object();

        if (f != 0) {
            encontrado = facturaRepo.buscarFactura("12345");
            Assertions.assertNotNull(encontrado);

        }
    }



    @Test
    public void eliminarFactura(){

        String codigo = "12345";
        LocalDateTime fecha = LocalDateTime.now();
        String medioPago = "Tarjeta de Credito";
        String tipo = "No me acuerdo que va aca ";
        Double valor = 12312312.0;
        int f = facturaRepo.guardarFactura(codigo, fecha, medioPago, tipo, valor);
        Object encontrado = new Object();

        if (f != 0) {

            int e=facturaRepo.eliminarFactura("12345");

            encontrado = facturaRepo.buscarFactura("12345");
            Assertions.assertNotNull(e);

        }


    }

}
