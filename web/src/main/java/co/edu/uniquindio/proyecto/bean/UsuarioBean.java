package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades2.*;
import co.edu.uniquindio.proyecto.repo.*;

import co.edu.uniquindio.proyecto.servicios2.*;
import lombok.Getter;
import lombok.Setter;


import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.sound.midi.Soundbank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@ViewScoped
@Component
public class UsuarioBean implements Serializable {


    @Setter
    @Getter
    private String productoAutoCompletado;


    @Setter
    @Getter
    private int cantidadProductoBuscado;


    @Setter
    @Getter
    private String codigoProductoBuscado;


    @Setter
    @Getter
    private List<String> nombresProductos = new ArrayList<>();




    @Autowired
    private CargoRepo cargoRepo;


    @Autowired
    EnvioEmail envioEmail;


    @Autowired
    private EmpleadoRepo empleadoRepo;

    @Autowired
    private TipoContratoRepo tipoContratoRepo;

    //--------------------- Variables Cliente

    @Setter
    @Getter
    private String cedulaRegistro;

    @Setter
    @Getter
    private String direccionRegistro;
    @Setter
    @Getter
    private String nombreRegistro;
    @Setter
    @Getter
    private String correoRegistro;


    @Setter
    @Getter
    private String correoEmpleado;

    @Setter
    @Getter
    private String nitRegistro;


    @Setter
    @Getter
    private String cedulaBuscar;

    @Setter
    @Getter
    private String direccionBuscar;
    @Setter
    @Getter
    private String nombreBuscar;
    @Setter
    @Getter
    private String correoBuscar;

    @Setter
    @Getter
    private String nitBuscar;


    @Setter
    @Getter
    private String cedulaEditar;

    @Setter
    @Getter
    private String direccionEditar;
    @Setter
    @Getter
    private String nombreEditar;
    @Setter
    @Getter
    private String correoEditar;

    @Setter
    @Getter
    private String nitEditar;


    @Setter
    @Getter
    private String cedulaEliminar;

    @Setter
    @Getter
    private String codigoBuscar3;

    @Setter
    @Getter
    private boolean renderBuscarEmpleado;


    @Setter
    @Getter
    private boolean renderBuscarProducto;

    @Setter
    @Getter
    private String color;


    //---------------------- Variables Empleado  -----------------


    @Setter
    @Getter
    private String cedulaRegistro2;

    @Setter
    @Getter
    private String direccionRegistro2;
    @Setter
    @Getter
    private String nombreRegistro2;

    @Setter
    @Getter
    private LocalDateTime fechaContratacionRegistro2;

    @Setter
    @Getter
    private String cargoCodigoActualizar2;

    @Setter
    @Getter
    private String jefeInmediatoActualizar2;

    @Setter
    @Getter
    private String tipoContratoActualizar2;


    @Setter
    @Getter
    private String cedulaBuscar2;

    @Setter
    @Getter
    private String direccionBuscar2;
    @Setter
    @Getter
    private String nombreBuscar2;

    @Setter
    @Getter
    private LocalDateTime fechaContratacionBuscar2;

    @Setter
    @Getter
    private String cargoCodigoBuscar2;

    @Setter
    @Getter
    private String jefeInmediatoBuscar2;

    @Setter
    @Getter
    private String tipoContratoBuscar2;

    @Setter
    @Getter
    private String claveRegistro2;


    @Setter
    @Getter
    private String claveActualizar2;


    @Setter
    @Getter
    private List<Cargo> cargos;

    @Setter
    @Getter
    private List<String> nombresCargos;

    @Setter
    @Getter
    private List<Empleado> empleados;

    @Setter
    @Getter
    private List<String> nombresEmpleados;

    @Setter
    @Getter
    private String empleadoJefe;

    @Setter
    @Getter
    private Empleado empleado;

    @Setter
    @Getter
    private List<TipoContrato> contratos;

    @Setter
    @Getter
    private List<String> nombresContratos;

    @Setter
    @Getter
    private List<String> nombresProveedores;

    @Setter
    @Getter
    private String proveedorActualizar3;

    @Setter
    @Getter
    private String codigoEliminar3;

    @Setter
    @Getter
    private List<String> nombresInventarios;

    @Setter
    @Getter
    private String inventarioActualizar3;


    @Setter
    @Getter
    private String contrato;


    @Setter
    @Getter
    private String cargo;

    @Setter
    @Getter
    private int unidadesVendidas;

    @Setter
    @Getter
    private String direccionActualizar2;


    @Setter
    @Getter
    private String cedulaActualizar2;


    @Setter
    @Getter
    private String cedulaEliminar2;


    @Setter
    @Getter
    private String codigoRegistro3;


    @Setter
    @Getter
    private String codigoActualizar3;


    @Setter
    @Getter
    private int cantidadRegistro3;

    @Setter
    @Getter
    private int cantidadBuscar3;


    @Setter
    @Getter
    private String proveedorBuscar3;

    @Setter
    @Getter
    private String inventarioBuscar3;

    @Setter
    @Getter
    private int cantidadActualizar3;


    @Setter
    @Getter
    private String categoriaRegistro3;

    @Setter
    @Getter
    private String categoriaBuscar3;

    @Setter
    @Getter
    private String categoriaActualizar3;

    @Setter
    @Getter
    private String nombreRegistro3;

    @Setter
    @Getter
    private String nombreActualizar3;

    @Setter
    @Getter
    private String nombreBuscar3;

    @Setter
    @Getter
    private double precioCompraRegistro3;

    @Setter
    @Getter
    private double precioCompraBuscar3;

    @Setter
    @Getter
    private double precioCompraActualizar3;


    @Setter
    @Getter
    private double precioVentaRegistro3;

    @Setter
    @Getter
    private double precioVentaBuscar3;

    @Setter
    @Getter
    private double precioVentaActualizar3;

    @Setter
    @Getter
    private String nombreActualizar2;


    @Setter
    @Getter
    private List<TipoContrato> tipoContratos;







    @Setter
    @Getter
    private Producto2 producto2;

    @Setter
    @Getter
    private String codigoBuscarProducto;


    @Setter
    @Getter
    private String codigoRegistro4;
    @Setter
    @Getter
    private String codigoBuscar4;

    @Setter
    @Getter
    private String codigoActualizar4;

    @Setter
    @Getter
    private String codigoEliminar4;

    @Setter
    @Getter
    private LocalDateTime fechaRegistro4;

    @Setter
    @Getter
    private LocalDateTime fechaBuscar4;
    @Setter
    @Getter
    private LocalDateTime fechaActualizar4;


    @Setter
    @Getter
    private String medioPagoRegistro4;

    @Setter
    @Getter
    private String medioPagoBuscar4;

    @Setter
    @Getter
    private String medioPagoActualizar4;

    @Setter
    @Getter
    private String tipoRegistro4;

    @Setter
    @Getter
    private String tipoActualizar4;

    @Setter
    @Getter
    private String tipoBuscar4;

    @Setter
    @Getter
    private double valorTotalRegistro4;

    @Setter
    @Getter
    private double valorTotalActualizar4;

    @Setter
    @Getter
    private double valorTotalBuscar4;





    @Setter
    @Getter
    private boolean requeridoRegistro;

    @Setter
    @Getter
    private boolean requeridoBuscar;

    @Setter
    @Getter
    private boolean requeridoActualizar;

    @Setter
    @Getter
    private boolean requeridoEliminar;


    @Setter
    @Getter
    private List<Producto2> productos;

    @Setter
    @Getter
    private Integer productosAgotados;


    @Setter
    @Getter
    private List<Producto2> productosLow;


    @Setter
    @Getter
    private List<String> nombresProductosCompletados ;


    @Setter
    @Getter
    private String nombreProductoSelecc;


    //rendereds

    @Setter
    @Getter
    private boolean renderFormularioGeneral;
    @Setter
    @Getter
    private boolean renderRegistrarEmpleado;


    @Setter
    @Getter
    private boolean renderActualizarEmpleado;


    @Setter
    @Getter
    private boolean renderMensajeLow = false;


    @Setter
    @Getter
    private boolean renderEliminarEmpleado;

    @Setter
    @Getter
    private boolean renderBuscar = true;

    @Setter
    @Getter
    private PieChartModel pieModel;


    @Autowired
    private final EmpleadoServicio empleadoServicio;

    @Autowired
    private final ProductoServicio2 productoServicio2;


    public UsuarioBean(EmpleadoServicio empleadoServicio, ProductoServicio2 productoServicio2) {


        this.empleadoServicio = empleadoServicio;
        this.productoServicio2 = productoServicio2;

    }


    @PostConstruct
    public void inicializar() {

        System.out.println("Entro a inicializar UsuarioBean");


        //crearCargosIniciales();
        //crearTipoContrato();
        //crearAdiministrador();
        color = "white";
        codigoProductoBuscado = "#####";
        nombresProductosCompletados = new ArrayList<>();

        llenarNombresCargos();
        llenarNombresEmpleados();
        llenarNombresContratos();


        createPieModel();
        cargarNombres();
        validarExistenciaProductos();

        requeridoRegistro = true;
        requeridoBuscar = true;
        requeridoActualizar = true;
        requeridoEliminar = true;
        renderBuscarEmpleado = false;
        renderFormularioGeneral = false;
        renderRegistrarEmpleado = false;
        renderBuscarProducto = false;


    }


    public void registrarEmpleado() {


        empleado = new Empleado();
        empleado.setCedula(cedulaRegistro2);

        empleado.setDireccion(direccionRegistro2);

        empleado.setNombre(nombreRegistro2);

        empleado.setClave(claveRegistro2);

        empleado.setFechaContratacion(fechaContratacionRegistro2);
        empleado.setCorreo(correoEmpleado);


        try {
            int r = empleadoServicio.registrarEmpleado(empleado);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro Exitoso");
            FacesContext.getCurrentInstance().addMessage("mensajeEmpleado", msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensajeEmpleado", msg);
        }


    }


    public void actualizarEmpleado() {


        TipoContrato contratoR = tipoContratoRepo.buscarContratoPorId(tipoContratoActualizar2);


        String idCargo = cargoRepo.buscarIdCargo(cargoCodigoActualizar2);
        Cargo cargoR = cargoRepo.buscarCargoId(idCargo);
        Empleado jefeR = empleadoRepo.buscarEmpleadoId(jefeInmediatoActualizar2);


        empleado = new Empleado();
        empleado.setCorreo(correoEmpleado);
        empleado.setCargo(cargoR);
        empleado.setTipoContrato(contratoR);
        empleado.setJefeInmediato(jefeR);
        empleado.setCedula(cedulaActualizar2);
        empleado.setNombre(nombreActualizar2);
        empleado.setClave(claveActualizar2);
        empleado.setDireccion(direccionActualizar2);


        try {
            int e = empleadoServicio.actualizarEmpleado(empleado);


            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Actualizacion Exitosa");
            FacesContext.getCurrentInstance().addMessage("mensajeEmpleado", msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensajeEmpleado", msg);
        }


    }


    public void buscarEmpleado() {

        empleado = new Empleado();
        try {
            empleado = empleadoServicio.BuscarEmpleado(cedulaActualizar2);
            cedulaActualizar2 = empleado.getCedula();
            nombreActualizar2 = empleado.getNombre();
            correoEmpleado = empleado.getCorreo();
            direccionActualizar2 = empleado.getDireccion();
            tipoContratoActualizar2 = empleado.getTipoContrato().getTipo();

            jefeInmediatoActualizar2 = empleado.getJefeInmediato().getNombre();
            cargoCodigoActualizar2 = empleado.getCargo().getDescripcion();
            claveActualizar2 = empleado.getClave();

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Busqueda Exitosa");
            FacesContext.getCurrentInstance().addMessage("mensajeEmpleado", msg);


        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensajeEmpleado", msg);
        }


    }


    public void buscarEmpleado2() {

        empleado = new Empleado();
        try {
            empleado = empleadoServicio.BuscarEmpleado(cedulaBuscar2);

            if (empleado != null) {
                renderBuscarEmpleado = true;

            }
            cedulaBuscar2 = empleado.getCedula();
            nombreBuscar2 = empleado.getNombre();
            direccionBuscar2 = empleado.getDireccion();
            correoEmpleado = empleado.getCorreo();
            tipoContratoBuscar2 = empleado.getTipoContrato().getTipo();
            jefeInmediatoBuscar2 = empleado.getJefeInmediato().getNombre();
            cargoCodigoBuscar2 = empleado.getCargo().getDescripcion();
            //  fechaContratacionBuscar2 = empleado.getFechaContratacion();


            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Busqueda Exitosa");
            FacesContext.getCurrentInstance().addMessage("mensajeEmpleado", msg);


        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensajeEmpleado", msg);
        }


    }


    public void eliminarEmpleado() {

        try {
            boolean elimino = empleadoServicio.eliminarEmpleado(cedulaEliminar2);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Eliminacion Exitosa");
            FacesContext.getCurrentInstance().addMessage("mensajeCliente", msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensajeCliente", msg);
        }

    }

    public void llenarNombresCargos() {
        nombresCargos = new ArrayList<>();
        cargos = new ArrayList<>();
        cargos = cargoRepo.listarCargos();
        for (Cargo c : cargos) {
            nombresCargos.add(c.getDescripcion());
        }


    }


    public void llenarNombresEmpleados() {

        nombresEmpleados = new ArrayList<>();
        empleados = new ArrayList<>();
        empleados = empleadoRepo.listarEmpleados();

        for (Empleado e : empleados) {
            nombresEmpleados.add(e.getNombre());
        }

    }


    public void llenarNombresContratos() {

        nombresContratos = new ArrayList<>();
        contratos = new ArrayList<>();
        contratos = tipoContratoRepo.listarContratos();

        for (TipoContrato tc : contratos) {

            nombresContratos.add(tc.getTipo());


        }


    }


    public void registrarProducto() {

        producto2 = new Producto2();
        producto2.setCantidad(cantidadRegistro3);
        producto2.setCodigo(codigoRegistro3);
        producto2.setCategoria(categoriaRegistro3);
        producto2.setNombre(nombreRegistro3);
        producto2.setPrecioCompra(precioCompraRegistro3);
        producto2.setPrecioVenta(precioVentaRegistro3);


        try {
            int r = productoServicio2.registrarProducto(producto2);

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Registro Exitoso");
            FacesContext.getCurrentInstance().addMessage("mensajeProducto", msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensajeProducto", msg);
        }


    }


    public void buscarCantidadUnidades() {


        if (productoAutoCompletado != null && !productoAutoCompletado.equalsIgnoreCase("")) {


            try {
                Producto2 productoEncontrado = productoServicio2.buscarProducto(productoAutoCompletado);
                System.out.printf("Nombre producto encontrado " + productoEncontrado.getNombre());
                cantidadProductoBuscado = productoEncontrado.getCantidad();
                codigoProductoBuscado = productoEncontrado.getCodigo();
                System.out.printf("Nombre producto encontrado " + productoEncontrado.getNombre() + " cantidad :" + productoEncontrado.getCantidad());


                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Consulta exitosa");
                FacesContext.getCurrentInstance().addMessage("mensajeVenta", msg);

            } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("mensajeVenta", msg);
            }


        }


    }

    public List<String> completeText(String query) {
        String queryLowerCase = query.toLowerCase();
        List<String> countryList = new ArrayList<>();
        try {
            List<Producto2> productos = productoServicio2.obtenerProductos();

            for (Producto2 p : productos) {
                countryList.add(p.getNombre());
            }
            return countryList.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());

        } catch (Exception e) {
            System.out.printf("Error en CompletText :" + e.getMessage());
        }

        return countryList;
    }

    public void buscarProducto() {
        System.out.println("Entro a buscar producto");
        try {
            Producto2 productob = productoServicio2.BuscarProducto(codigoActualizar3);
            if (productob != null) {

            }
            codigoActualizar3 = productob.getCodigo();
            cantidadActualizar3 = productob.getCantidad();
            categoriaActualizar3 = productob.getCategoria();
            nombreActualizar3 = productob.getNombre();
            precioCompraActualizar3 = productob.getPrecioCompra();
            precioVentaActualizar3 = productob.getPrecioVenta();


            renderBuscarProducto = true;


            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Busquedad Exitosa");
            FacesContext.getCurrentInstance().addMessage("mensajeProducto", msg);

        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensajeProducto", msg);
        }


    }


    public void actualizarProducto() {


        producto2 = new Producto2();
        producto2.setCodigo(codigoActualizar3);
        producto2.setPrecioVenta(precioVentaActualizar3);
        producto2.setCantidad(cantidadActualizar3);
        producto2.setNombre(nombreActualizar3);
        producto2.setPrecioCompra(precioCompraActualizar3);
        producto2.setCategoria(categoriaActualizar3);


        try {
            int e = productoServicio2.actualizarProducto(producto2);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Actualizacion Exitosa");
            FacesContext.getCurrentInstance().addMessage("mensajeProducto", msg);
        } catch (Exception ex) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", ex.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensajeProducto", msg);
        }

    }


    public void buscarProducto2() {


        try {


            //  Producto2 productob = productoServicio2.BuscarProducto(codigoBuscar3);
            Producto2 productob = productoServicio2.BuscarProducto(codigoBuscarProducto);


            codigoBuscar3 = productob.getCodigo();
            cantidadBuscar3 = productob.getCantidad();
            categoriaBuscar3 = productob.getCategoria();
            nombreBuscar3 = productob.getNombre();
            precioCompraBuscar3 = productob.getPrecioCompra();
            precioVentaBuscar3 = productob.getPrecioVenta();



            renderBuscarProducto = true;


            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Busquedad Exitosa");
            FacesContext.getCurrentInstance().addMessage("mensajeProducto", msg);

        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensajeProducto", msg);
        }


    }


    public void eliminarProducto() {

        try {
            boolean elimino = productoServicio2.eliminarPrducto(codigoEliminar3);

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Eliminacion Exitosa");
            FacesContext.getCurrentInstance().addMessage("mensajeProducto", msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensajeProducto", msg);
        }


    }


    private void createPieModel() {

        productosAgotados = 0;
        pieModel = new PieChartModel();
        ChartData data = new ChartData();
        PieChartDataSet dataSet = new PieChartDataSet();
        List<Number> values = new ArrayList<>();
        List<String> bgColors = new ArrayList<>();
        List<String> labels = new ArrayList<>();

        try {
            productos = productoServicio2.obtenerProductos();


            for (Producto2 p : productos) {


                int n1 = (int) (Math.random() * 255) + 0, n2 = (int) (Math.random() * 255) + 0, n3 = (int) (Math.random() * 255) + 0;
                if (p.getCantidad() <= 10) {

                    n1 = 255;
                    n2 = 0;
                    n3 = 0;
                    productosAgotados += 1;
                    traerProductosLow();


                }

                values.add(p.getCantidad());

                labels.add(p.getNombre());

                bgColors.add("rgb(" + n1 + "," + n2 + "," + n3 + ")");

            }

            dataSet.setData(values);
            dataSet.setBackgroundColor(bgColors);

            data.addChartDataSet(dataSet);
            data.setLabels(labels);

            pieModel.setData(data);


        } catch (Exception e) {
            System.out.println("Error en createPieModel trayendo los productos: " + e.getMessage());
        }
    }

    public void cargarNombres() {

        for (Producto2 p : productos) {
            nombresProductos.add(p.getNombre());
        }

    }


    public void ingresarVenta() {
        try {
            Producto2 productoVendido = productoServicio2.buscarProducto(nombreProductoSelecc);

            int cantidadActual = productoVendido.getCantidad();
            int cantidadVendida = unidadesVendidas;
            System.out.println("Producto vendido " + productoVendido.getNombre() + "Cantidad Vendida " + unidadesVendidas + "Cantidad Actual " + cantidadActual);


            productoVendido.setCantidad(cantidadActual - cantidadVendida);

            int e = productoServicio2.actualizarProductoVendido(productoVendido);


            if (e != 0) {

                validarExistenciaProductos();
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Se ingreso la venta satisfactoriamente");
                FacesContext.getCurrentInstance().addMessage("mensajeVenta", msg);


            }


        } catch (Exception e) {


            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensajeVenta", msg);
        }

    }

    public void validarExistenciaProductos() {
        System.out.println("Entro a validarExistencias");

        List<Producto2> productosLow = new ArrayList<>();


        try {
            List<Producto2> productos2 = productoServicio2.obtenerProductos();

            for (Producto2 p : productos2) {
                if (p.getCantidad() <= 10) {
                    color = "red";
                    productosLow.add(p);
                    renderMensajeLow = true;
                }
            }


            if (renderMensajeLow == true) {

                enviarProductosLow(productosLow);
            }

        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensajeVenta", msg);
        }
    }

    public void crearCargosIniciales() {


        cargoRepo.guardarCargo("1", "Administrador");
        cargoRepo.guardarCargo("2", "Gerencial");
        cargoRepo.guardarCargo("3", "Vendedor");
        System.out.println("Creo los cargos en el PostConstruct");

    }

    public void crearTipoContrato() {

        tipoContratoRepo.guardarTipoContrato("1", "Indefinido");
        tipoContratoRepo.guardarTipoContrato("2", "Termino Fijo");
        tipoContratoRepo.guardarTipoContrato("3", "Obra y Labor");
        tipoContratoRepo.guardarTipoContrato("4", "P.Servicios");
        System.out.println("Creo los contratos en el PostConstruct");

    }

    public void crearAdiministrador() {

        Cargo c1 = new Cargo();
        TipoContrato tp1 = new TipoContrato();

        c1.setCodigo("1");
        c1.setDescripcion("Administrador");
        tp1.setCodigo("1");
        tp1.setTipo("Indefinido");

        empleado = new Empleado();
        empleado.setCedula("1094958393");
        empleado.setDireccion("Centro Armenia");
        empleado.setNombre("Juan David");
        empleado.setClave("12345");
        empleado.setCorreo("juandaruiz07@gmail.com");
        empleado.setFechaContratacion(LocalDateTime.now());

        empleado.setCargo(c1);
        empleado.setTipoContrato(tp1);


        try {
            int r = empleadoServicio.registrarEmpleado(empleado);
            System.out.println("Creo el administrador en el PostConstruct");


        } catch (Exception e) {
            System.out.println("Error cuando intetaba crear el administrador: " + e.getMessage());
        }


    }


    public void traerProductosLow() {


        try {
            productosLow = productoServicio2.productosBajaCantidad();
            renderMensajeLow = true;
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Alerta", "Hay productos con baja cantidad de unidades");
            FacesContext.getCurrentInstance().addMessage("mensajeVenta", msg);


        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "No hay productos con baja cantidad de unidades");
            FacesContext.getCurrentInstance().addMessage("mensajeVenta", msg);
        }


    }


    public String redirigirLow() {

        return "/productosLow?faces-redirect=true";
    }


    public void enviarClave() {


        Empleado emp;

        try {


            emp = empleadoServicio.encontrarEmpleadoCorreo(correoEmpleado);

            envioEmail.enviarCorreoPassword(emp.getCorreo(), "Recordatorio Clave", emp.getNombre(), emp.getClave());
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Alerta", "Se ha enviado la contraseña a su correo de registro");
            FacesContext.getCurrentInstance().addMessage("mensajeEnvio", msg);


        } catch (Exception e) {

            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Alerta", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensajeEnvio", msg);
        }


    }


    public void enviarProductosLow(List<Producto2> productos2) {


        List<String> productos = new ArrayList<>();
        String productoNomCant = "";
        String product = "";


        for (Producto2 p : productos2) {
            productoNomCant = "Nombre: " + p.getNombre() + " Cantidad: " + p.getCantidad() + " ";
            productos.add(productoNomCant);
        }

        for (int i = 0; i < productos.size(); i++) {
            product += productos.get(i) + "\n";

        }


        List<Empleado> empleados = new ArrayList<>();
        try {
            empleados = empleadoServicio.buscarEmpleadoCargo("Gerencial");

        } catch (Exception e) {

        }
        List<Empleado> gerentes = new ArrayList<>();


        for (Empleado e : empleados
        ) {


        }


        for (Empleado e : empleados) {


            if (e.getCargo().getDescripcion().equalsIgnoreCase("Gerencial")) {

                gerentes.add(e);

            }
        }


        for (int i = 0; i < gerentes.size(); i++) {


            envioEmail.enviarCorreoLow(gerentes.get(i).getCorreo(), "Alerta - Productos baja cantidad", gerentes.get(i).getNombre(), product);
        }


    }

}


