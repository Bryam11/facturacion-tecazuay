package tecazuay.edu.ec.facturacion.resources.model.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RolDto {
    private Integer idRol;
    private String nombre;
    private String descripcion;
    private Integer idCompetencia;
    private String competencia;
}
