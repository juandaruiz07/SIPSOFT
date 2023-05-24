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
public class Proveedor implements Serializable {


    @Id
    @EqualsAndHashCode.Include
    private String nit;


    @Column(nullable = false, length = 50)
    private String direccion;

    @Length(min = 8, max = 12)
    @Column(nullable = false)
    private String telefono;


    @Column(nullable = false)
    private String contacto;


    @OneToMany(mappedBy ="proveedor")
    List<Producto2> productos;


}
