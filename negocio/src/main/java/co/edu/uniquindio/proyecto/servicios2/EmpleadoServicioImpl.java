package co.edu.uniquindio.proyecto.servicios2;

import co.edu.uniquindio.proyecto.entidades2.Empleado;
import co.edu.uniquindio.proyecto.repo.EmpleadoRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class EmpleadoServicioImpl implements EmpleadoServicio {

    private final EmpleadoRepo empleadoRepo;


    private String nombreEmpleado;

    public EmpleadoServicioImpl(EmpleadoRepo empleadoRepo) {


        this.empleadoRepo = empleadoRepo;
    }

    @Override
    public int registrarEmpleado(Empleado e) throws Exception {


        int g = 0;

        Empleado empleadoBuscado = null;


        empleadoBuscado = empleadoRepo.buscarEmpleadoC(e.getCedula());
        if (empleadoBuscado == null) {

            empleadoRepo.guardarEmpleado(e.getCedula(), e.getDireccion(), e.getNombre(), e.getFechaContratacion(), e.getClave(), e.getCorreo());

            System.out.println("Entro al else de servicio" + e.getCedula() + " ," + e.getDireccion() + " ," + e.getNombre() + " ," + e.getFechaContratacion());


            return g;

        } else {
            throw new Exception("El empleado ya se encuentra registrado");


        }


    }

    @Override
    public int actualizarEmpleado(Empleado e) throws Exception {

        System.out.println("Entro a actualizarEmpeladoServicio");
        int ed = 0;

        Empleado empleadoBuscado = new Empleado();


        empleadoBuscado = empleadoRepo.buscarEmpleadoC(e.getCedula());
        if (empleadoBuscado != null) {

            String cargo = e.getCargo().getCodigo();
            String jefe = e.getJefeInmediato().getCedula();
            String tipoContrato = e.getTipoContrato().getCodigo();

            ed = empleadoRepo.actualizarEmpleado(e.getCedula(), e.getDireccion(), e.getCorreo(), cargo, jefe, tipoContrato, e.getClave(), e.getNombre());
            System.out.println("Actualizo el empleado");
            return ed;

        } else {
            throw new Exception("El empleado que desea modificar no se encuentra registrado");


        }


    }

    @Override
    public Empleado BuscarEmpleado(String cedula) throws Exception {

        Empleado empleadoBuscado = new Empleado();

        empleadoBuscado = empleadoRepo.buscarEmpleadoC(cedula);

        if (empleadoBuscado != null) {
            return empleadoBuscado;


        } else {

            throw new Exception("El empleado buscado no se encuentra registrado");
        }


    }

    @Override
    public Boolean eliminarEmpleado(String cedula) throws Exception {

        Empleado empleadoBuscado = null;

        empleadoBuscado = empleadoRepo.buscarEmpleadoC(cedula);

        if (empleadoBuscado == null) {

            throw new Exception("El empleado que desea eliminar  no se encuentra registrado");
        } else {


            int eliminar = empleadoRepo.eliminarEmpleado(cedula);

            return true;

        }

    }

    @Override
    public String login(String cedula, String clave) throws Exception {
        Empleado e = empleadoRepo.login(cedula, clave);

        nombreEmpleado = e.getNombre();
        if (e == null) {
            throw new Exception("Cedula o Clave incorrecta");
        } else {
            return e.getNombre() + "-" + e.getCargo().getDescripcion();
        }


    }

    @Override
    public String nombreLogueado() {
        return nombreEmpleado;
    }

    @Override
    public Empleado encontrarEmpleadoCorreo(String correo) throws Exception {
        Empleado empleadoEncontrado;

        empleadoEncontrado = empleadoRepo.buscarEmpleadoCorreo(correo);

        if (empleadoEncontrado == null) {
            throw new Exception("El correo que ingreso no se encuentra asociado a ninguna cuenta");
        } else {
            return empleadoEncontrado;
        }


    }

    @Override
    public List<Empleado> buscarEmpleadoCargo(String cargo) throws Exception {

        List<Empleado> empleadosEncontrados = new ArrayList<>();

        empleadosEncontrados = empleadoRepo.empleadoCargo(cargo);

        if (empleadosEncontrados.isEmpty()) {

            throw new Exception("No hay ningun empleado con el cargo buscado");

        } else {

            return empleadosEncontrados;
        }

    }
}
