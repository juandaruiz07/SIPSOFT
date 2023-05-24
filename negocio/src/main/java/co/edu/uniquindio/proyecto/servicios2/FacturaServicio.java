package co.edu.uniquindio.proyecto.servicios2;

import co.edu.uniquindio.proyecto.entidades2.Factura;

public interface FacturaServicio {


    int registrarFactura(Factura f) throws Exception;
    int actualizarFactura(Factura f)throws Exception;
    Object BuscarFactura(String factura)throws Exception;
    Boolean eliminarFactura(String factura)throws Exception;

}
