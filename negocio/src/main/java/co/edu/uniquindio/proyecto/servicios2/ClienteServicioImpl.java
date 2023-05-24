package co.edu.uniquindio.proyecto.servicios2;

import co.edu.uniquindio.proyecto.entidades2.Cliente;
import co.edu.uniquindio.proyecto.repo.ClienteRepo;
import org.springframework.stereotype.Service;


@Service
public class ClienteServicioImpl implements ClienteServicio {


    private final ClienteRepo clienteRepo;

    public ClienteServicioImpl(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }


    @Override
    public int registrarCliente(Cliente c) throws Exception {

        int registro = 0;
        Cliente clienteEncontrado = null;
        clienteEncontrado = clienteRepo.obtenerCliente(c.getCedula());
        if (clienteEncontrado != null) {
            throw new Exception("El cliente ya se encuentra registrado");
        } else {
            registro = clienteRepo.guardarCliente(c.getCedula(), c.getDireccion(), c.getNombre(), c.getCorreo(), c.getNit());
            System.out.println("Entro al else");
            return registro;
        }

    }

    @Override
    public int actualizarCliente(Cliente c) throws Exception {


        Cliente clienteEncontrado = clienteRepo.obtenerCliente(c.getCedula());
        if (clienteEncontrado == null) {
            throw new Exception("El cliente no se encuentra registrado");

        } else {
        int  edito = clienteRepo.actualizarCliente(c.getCedula(),c.getDireccion(),c.getNombre(),c.getNit(),c.getCorreo());
            System.out.println("El valor de edito : " + edito);
            return 1;


        }

    }

    @Override
    public Cliente BuscarCliente(String cedula) throws Exception {
        Cliente clienteEncontrado = null;

        clienteEncontrado = (Cliente) clienteRepo.obtenerCliente(cedula);

        if (clienteEncontrado == null) {

            throw new Exception("El cliente no se encuentra registrado");


        } else {


            return clienteEncontrado;
        }


    }

    @Override
    public Boolean eliminarCliente(String cedula) throws Exception {
        int elimino = 0;

        Cliente clienteEncontrado = clienteRepo.obtenerCliente(cedula);
        if (clienteEncontrado == null) {
            throw new Exception("El cliente que desea eliminar no se encuentra registrado");
        } else {
            elimino = clienteRepo.eliminarCliente(cedula);
            if (elimino != 0) {
                return true;

            }
        }

        return false;
    }

    @Override
    public Cliente buscarC(String cedula) throws Exception {
        Cliente clienteEncontrado = clienteRepo.findByCedula(cedula);
        return clienteEncontrado;


    }
}
