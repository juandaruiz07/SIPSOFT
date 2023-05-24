package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.repo.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    public void guardarCliente() {

        String cedula = "111111";
        String direccion = "Centro Armenia";
        String nombre = "Juan";
        String correo = "Juan@mail.com";
        String nit = "3333333";


        int r = clienteRepo.guardarCliente(cedula, direccion, nombre, correo, nit);

        Assertions.assertNotNull(r);


    }

    @Test
    public void actualizarCliente() {


        String cedula = "111111";
        String direccion = "Centro Armenia";
        String nombre = "Juan";
        String correo = "Juan@mail.com";
        String nit = "3333333";

        String nombreModificado = "David";
        int r = clienteRepo.guardarCliente(cedula, direccion, nombre, correo, nit);
        if (r != 0) {
          //  int m = clienteRepo.actualizarCliente(cedula, direccion, nombreModificado);
            //Assertions.assertNotNull(m);

        }

    }

    @Test
    public void buscarCliente() {

        String cedula = "123";
        String direccion = "Centro Armenia";
        String nombre = "Juan";
        String correo = "Juan@mail.com";
        String nit = "3333333";

        String nombreModificado = "David";
        int r = clienteRepo.guardarCliente(cedula, direccion, nombre, correo, nit);
        Object clienteEncontrado = new Object();
        clienteEncontrado = clienteRepo.buscarCliente("123");
        Assertions.assertNotNull(clienteEncontrado);
    }

    @Test
    public void eliminarCliente() {

        String cedula = "123";
        String direccion = "Centro Armenia";
        String nombre = "Juan";
        String correo = "Juan@mail.com";
        String nit = "3333333";
        String nombreModificado = "David";
        int r = clienteRepo.guardarCliente(cedula, direccion, nombre, correo, nit);

        if (r != 0) {
            Integer eliminados = null;
            eliminados = clienteRepo.eliminarCliente("123");
            Assertions.assertNotNull(eliminados);
        }


    }


}
