package co.edu.uniquindio.proyecto.entidades2;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
public class TipoContrato implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String codigo;


    @Length(max = 20, min = 5)
    @Column(nullable = false)
    private String tipo;


    @OneToMany(mappedBy = "tipoContrato")
    private List<Empleado> empleados;

}
