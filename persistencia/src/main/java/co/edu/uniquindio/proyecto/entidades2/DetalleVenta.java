package co.edu.uniquindio.proyecto.entidades2;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class DetalleVenta implements Serializable {


    @Id
    @EqualsAndHashCode.Include
    private String codigo;


    @Column(nullable = false)
    private int cantidad;

    @ManyToOne
    private Venta venta;

    @ManyToOne
    private Producto2 producto;

    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "detalleVenta")
    private List<Producto2> productos;


}
