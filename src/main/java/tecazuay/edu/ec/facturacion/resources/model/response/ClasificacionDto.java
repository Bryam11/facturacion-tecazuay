package tecazuay.edu.ec.facturacion.resources.model.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClasificacionDto {
    private Integer idClasificacion;
    private String grupo;
}
