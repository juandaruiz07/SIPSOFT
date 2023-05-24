package co.edu.uniquindio.proyecto.bean;

import co.edu.uniquindio.proyecto.entidades2.Producto2;
import co.edu.uniquindio.proyecto.servicios2.ProductoServicio2;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.*;
import java.util.*;


@ViewScoped
@Component
public class ProductoBean implements Serializable {

    @Value("${upload.url}")
    private String urlUploads;

    @Getter
    @Setter
    private String opcionSeleccionada;


//    @Value("#{seguridadBean.usuarioSesion}")
    //  private Usuario usuarioSesion;

    @Getter
    @Setter
    private Producto2 producto;

    @Getter
    @Setter
    private PieChartModel pieModel;


    @Autowired
    private final ProductoServicio2 productoServicio2;
    //@Getter @Setter
    //private Usuario usuario;

    @Getter
    @Setter
    private ArrayList<String> imagenes;

    @Getter
    @Setter
    private List<String> imagenesProducto;

    public ProductoBean(ProductoServicio2 productoServicio2) {
        this.productoServicio2 = productoServicio2;
    }


    @PostConstruct
    public void inicializar() {

        this.producto = new Producto2();
        this.imagenes = new ArrayList<>();


    }


}
