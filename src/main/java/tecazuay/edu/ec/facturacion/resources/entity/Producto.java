package tecazuay.edu.ec.facturacion.resources.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "stock", nullable = false)
    private Integer stock;

    @NotNull
    @Column(name = "precio_unitario", nullable = false)
    private Double precioUnitario;

    @Size(max = 50)
    @NotNull
    @Column(name = "unidad", nullable = false, length = 50)
    private String unidad;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Clasificacion.class, optional = false)
    @JoinColumn(name = "id_clasificacion", nullable = false)
    @JsonBackReference
    private Clasificacion idClasificacion;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_proveedor", nullable = false)
    private Proveedor idProveedor;

    @NotNull
    @Column(name = "iva", nullable = false)
    private Boolean iva = false;

    @OneToMany(mappedBy = "idProducto")
    private Set<ItemFactura> itemFacturas = new LinkedHashSet<>();

}