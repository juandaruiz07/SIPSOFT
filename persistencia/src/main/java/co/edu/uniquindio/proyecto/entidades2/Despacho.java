package co.edu.uniquindio.proyecto.entidades2;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Despacho implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String numeroGuia;


    @Column(nullable = false)
    private LocalDateTime fechaEnvio;

    @Column(nullable = false)
    private LocalDateTime fechaLlegada;

}
