package co.edu.uniquindio.proyecto.entidades2;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor

@ToString(callSuper = true)

public class Cliente extends P implements Serializable {

    @Column(nullable = false, unique = true)
    private String nit;

    @Column(nullable = false, unique = true)
    @Email
    private String correo;

    @OneToMany(mappedBy = "cliente")
    private List<DetalleVenta> detalleVenta;

}
