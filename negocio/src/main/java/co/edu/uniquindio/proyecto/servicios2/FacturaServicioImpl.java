package co.edu.uniquindio.proyecto.servicios2;

import co.edu.uniquindio.proyecto.entidades2.Factura;
import co.edu.uniquindio.proyecto.repo.FacturaRepo;
import org.springframework.stereotype.Service;


@Service
public class FacturaServicioImpl implements FacturaServicio {

    private final FacturaRepo facturaRepo;

    public FacturaServicioImpl(FacturaRepo facturaRepo) {
        this.facturaRepo = facturaRepo;
    }


    @Override
    public int registrarFactura(Factura f) throws Exception {

        int g = 0;


        Object facturaBuscada = null;

        facturaBuscada = facturaRepo.buscarFactura(f.getCodigo());

        if (facturaBuscada != null) {

            throw new Exception("La Factura ya se encuentra registrada");
        } else {

            g = facturaRepo.guardarFactura(f.getCodigo(), f.getFecha(), f.getMedioDePago(), f.getTipo(), f.getValorTotal());
            return g;

        }
    }

    @Override
    public int actualizarFactura(Factura f) throws Exception {


        Object facturaBuscada = null;
        int e = 0;
        facturaBuscada = facturaRepo.buscarFactura(f.getCodigo());

        if (facturaBuscada == null) {

            throw new Exception("La Factura que desea modificar no se encuentra registrada");
        } else {
            e = facturaRepo.actualizarFactura(f.getCodigo(), f.getMedioDePago(), f.getTipo(), f.getValorTotal());
            return e;

        }

    }

    @Override
    public Object BuscarFactura(String factura) throws Exception {

        Object facturaBuscada = null;

        facturaBuscada = facturaRepo.buscarFactura(factura);

        if (factura == null) {

            throw new Exception("La Factura que esta consultando no se encuentra registrada");

        } else {
            return facturaBuscada;
        }

    }

    @Override
    public Boolean eliminarFactura(String factura) throws Exception {
        Object facturaBuscada = null;

        facturaBuscada = facturaRepo.buscarFactura(factura);
        int elimino = 0;

        if (factura == null) {

            throw new Exception("La Factura que desea eliminar no se encuentra registrada");

        } else {

            elimino = facturaRepo.eliminarFactura(factura);
            if (elimino != 0) {
                return true;
            }

        }
        return false;
    }
}
