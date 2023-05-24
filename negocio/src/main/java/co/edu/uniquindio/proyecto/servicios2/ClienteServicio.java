package co.edu.uniquindio.proyecto.servicios2;

import co.edu.uniquindio.proyecto.entidades2.Cliente;

public interface ClienteServicio {



    int registrarCliente(Cliente c) throws Exception;
    int actualizarCliente(Cliente c)throws Exception;


    Cliente BuscarCliente(String cedula)throws Exception;
    Boolean eliminarCliente(String cedula)throws Exception;

    Cliente buscarC(String cedula)throws Exception;

}
