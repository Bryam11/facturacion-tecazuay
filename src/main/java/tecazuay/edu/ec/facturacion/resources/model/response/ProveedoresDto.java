package tecazuay.edu.ec.facturacion.resources.model.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProveedoresDto {
    private Integer idProveedor;
    private String pais;
    private String telefono;
    private String correo;
    private String ruc;
    private String moneda;
}
