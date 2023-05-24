package co.edu.uniquindio.proyecto.entidades2;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Producto2 implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = false)
    private Double precioVenta;


    @Column(nullable = false)
    private Double precioCompra;


    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 20)
    private String categoria;

    @Column(nullable = false)
    private int cantidad;




}
