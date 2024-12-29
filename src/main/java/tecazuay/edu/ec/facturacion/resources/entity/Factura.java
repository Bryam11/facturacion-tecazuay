package tecazuay.edu.ec.facturacion.resources.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Column(name = "ruc", nullable = false, length = 20)
    private String ruc;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_persona", nullable = false)
    private Persona idPersona;

    @NotNull
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_tipo_pago", nullable = false)
    private TipoPago idTipoPago;

    @Column(name = "descuento")
    private Double descuento;

    @NotNull
    @Column(name = "total", nullable = false)
    private Double total;

    @OneToMany(mappedBy = "idFactura")
    private Set<ItemFactura> itemFacturas = new LinkedHashSet<>();

}