package co.edu.uniquindio.proyecto.entidades2;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Inventario implements Serializable {


    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Column(nullable = true)
    private LocalDateTime fechaInicio;

    @Column(nullable = true)
    private LocalDateTime fechaFin;

    @Column(nullable = false)
    private String categoria;

    @OneToMany(mappedBy = "inventario")
    private List<Producto2> productos;


}
