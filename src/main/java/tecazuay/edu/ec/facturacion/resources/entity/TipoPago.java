package tecazuay.edu.ec.facturacion.resources.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tipo_pago")
public class TipoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_pago", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "tpo", nullable = false, length = 50)
    private String tpo;

    @Size(max = 255)
    @Column(name = "descrip")
    private String descrip;

    @OneToMany(mappedBy = "idTipoPago")
    private Set<Factura> facturas = new LinkedHashSet<>();

}