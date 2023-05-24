package co.edu.uniquindio.proyecto.bean;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Component
@ViewScoped
public class InicioBean implements Serializable {






    public String irADetalle(String id) {
        return "/detalleProducto?faces-redirect=true&amp;producto=" + id;
    }






}

