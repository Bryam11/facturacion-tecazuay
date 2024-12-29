package tecazuay.edu.ec.facturacion.resources.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "clasificacion")
public class Clasificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clasificacion", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull
    @Column(name = "grupo", nullable = false, length = 100)
    private String grupo;

    @OneToMany(mappedBy = "idClasificacion", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<Producto> productos = new LinkedHashSet<>();

}