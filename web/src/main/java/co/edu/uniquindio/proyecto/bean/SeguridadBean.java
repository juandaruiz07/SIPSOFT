package co.edu.uniquindio.proyecto.bean;


import co.edu.uniquindio.proyecto.entidades2.Producto2;
import co.edu.uniquindio.proyecto.servicios2.EmpleadoServicio;
import co.edu.uniquindio.proyecto.servicios2.ProductoServicio2;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.implementation.bytecode.constant.FloatConstant;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

import java.io.Serializable;
import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author on 26/11/2021
 * @project
 */

@Scope("session")
@Component
public class SeguridadBean implements Serializable {


    @Autowired
    private EmpleadoServicio empleadoServicio;

    @Autowired
    private ProductoServicio2 productoServicio2;






    @Getter
    @Setter
    private boolean autenticado;

    @Getter
    @Setter
    private String formaPago;

    @Getter
    @Setter
    private String email, password;


    @Getter
    @Setter
    private String cedula;


    @Getter
    @Setter
    private String clave;


    @Getter
    @Setter
    String nombreEmpleado1;

    @Getter
    @Setter
    String nombreEmpleado2;

    @Setter
    @Getter
    List<String> telefonos;


    @Getter
    @Setter
    private Float subtotal;


    @Setter
    @Getter
    private String telefonoFijo;

    @Setter
    @Getter
    private boolean renderOpcionesAdmin;


    @Setter
    @Getter
    private String celular;

    @Setter
    @Getter
    private boolean renderMensajeAlerta=false;

    @Setter
    @Getter
    private boolean renderBotonLow;


    @PostConstruct
    public void inicializar() {
        this.subtotal = 0F;

        telefonos = new ArrayList<>();

        autenticado = false;
        renderOpcionesAdmin = false;




    }


    public String iniciarSesion2() {
        if (cedula != null && clave != null) {

            System.out.println("Entro al metodo login "+ cedula + " clave :" + clave);

            System.out.println("Entro");
            try {

                nombreEmpleado1 = empleadoServicio.login(cedula, clave);
                nombreEmpleado2 = empleadoServicio.nombreLogueado();
                nombreEmpleado1 = nombreEmpleado1.trim();

                String[] cargo = nombreEmpleado1.split("-");
                System.out.println("tamaño cargoSplit" + cargo.length + " nombreEmpleado2 :" + nombreEmpleado1);

                for (String c : cargo) {
                    if (c.equalsIgnoreCase("Administrador")) {
                        renderOpcionesAdmin = true;
                    }
                }

                autenticado = true;
              validarExistenciasBajas();
                return "/index?faces-redirect=true";
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }
        }
        return null;
    }


    public String cerrarSesion2() {

        autenticado = false;
        return "/index?faces-redirect=true";
    }


    public String cerrarSesion() {

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }



    public void validarExistenciasBajas(){

        try {
            List<Producto2> p=productoServicio2.productosBajaCantidad();

            if(!p.isEmpty()){
                renderMensajeAlerta=true;
            }
        } catch (Exception e) {
            System.out.println("No hay productos con pocas existencias");;
        }


    }

}
