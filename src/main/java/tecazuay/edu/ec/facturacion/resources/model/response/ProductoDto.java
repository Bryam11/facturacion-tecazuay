package tecazuay.edu.ec.facturacion.resources.model.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {
    private Integer idProducto;
    private Double precioUnitario;
    private Integer stock;
    private String unidad;
    private Integer idClasificacion;
    private String grupoClasificacion;
    private Integer idProveedor;
    private String rucProveedor;
}
