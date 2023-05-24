package co.edu.uniquindio.proyecto.test;


import co.edu.uniquindio.proyecto.entidades2.Producto2;
import co.edu.uniquindio.proyecto.repo.ProductoRepo2;
import co.edu.uniquindio.proyecto.repo.ProductoRepo2Impl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductoTest {

    @Autowired
    ProductoRepo2 productoRepo2;


    @Test
   void guardarProducto() {
        //    Integer guardarProducto(String codigo,int cantidad, String categoria, String nombre, double precioCompra, double precioVenta);
        String codigo = "23";
        int cantidad = 4;
        String categoria = "Hilos";
        String nombre = "Tela";
        double precioCompra = 230000;
        double precioVenta = 600000;

        int guardo = productoRepo2.guardarProducto(codigo, cantidad, categoria, nombre, precioCompra, precioVenta);

        Assertions.assertNotNull(guardo);


    }

    @Test
     void actualizarProducto() {
        String codigo = "23";
        int cantidad = 4;
        String categoria = "Hilos";
        String nombre = "Tela";
        double precioCompra = 230000;
        double precioVenta = 600000;

        int guardo = productoRepo2.guardarProducto(codigo, cantidad, categoria, nombre, precioCompra, precioVenta);


        int actualizo = productoRepo2.actualizarProducto(codigo, cantidad + 5, categoria, nombre, precioCompra, precioVenta);
        System.out.println("Los productos actualizados fueron " + actualizo);
        Assertions.assertNotNull(actualizo);


    }


    @Test
     void buscarProducto() {


        String codigo = "23";
        int cantidad = 4;
        String categoria = "Hilos";
        String nombre = "Tela";
        double precioCompra = 230000;
        double precioVenta = 600000;

        int guardo = productoRepo2.guardarProducto(codigo, cantidad, categoria, nombre, precioCompra, precioVenta);
        Producto2 productoBuscado = productoRepo2.buscarProducto("23");
        Assertions.assertNotNull(productoBuscado);

    }

    @Test
     void eliminarProducto() {

        String codigo = "23";
        int cantidad = 4;
        String categoria = "Hilos";
        String nombre = "Tela";
        double precioCompra = 230000;
        double precioVenta = 600000;

        int guardo = productoRepo2.guardarProducto(codigo, cantidad, categoria, nombre, precioCompra, precioVenta);
        int productosEliminados= productoRepo2.eliminarProducto("23");

        System.out.println("Los productos eliminados fueron " + productosEliminados);
        Assertions.assertNotNull(productosEliminados);


    }
}
