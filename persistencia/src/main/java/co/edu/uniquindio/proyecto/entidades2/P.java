package co.edu.uniquindio.proyecto.entidades2;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class P implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String cedula;

    @Length(min = 5, max = 30, message = "El nombre debe tener entre 5 y 30 caracteres")
    @Column(nullable = false)
    private String nombre;

    @Length(min = 5, max = 30, message = "La direccion debe tener entre 5 y 30 caracteres")
    @Column(nullable = false)
    private String direccion;

    @ToString.Exclude
    @ElementCollection
    private List<String> Telefono;


}
