package co.edu.uniquindio.proyecto.entidades2;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@ToString
public class Cargo implements Serializable {


    @Id
    @EqualsAndHashCode.Include
    private String codigo;

    @Length(max = 255, min = 10)
    @Column(nullable = false)
    private String descripcion;

@ToString.Exclude
    @OneToMany(mappedBy = "cargo")
    private List<Empleado> empleados;




}
