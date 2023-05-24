package co.edu.uniquindio.proyecto.entidades2;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

@ToString(callSuper = true)

public class Empleado extends P implements Serializable {

    @Column
    private LocalDateTime fechaContratacion;

    @ManyToOne
    private Empleado jefeInmediato;

    @ManyToOne
    @ToString.Exclude
    private Cargo cargo;

    @ManyToOne
    private TipoContrato tipoContrato;


    @Column(nullable = false)
    private String clave;


    @Column(nullable = false, unique = true)
    @Email
    private String correo;


}
