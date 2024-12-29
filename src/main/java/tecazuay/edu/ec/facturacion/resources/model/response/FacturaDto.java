package tecazuay.edu.ec.facturacion.resources.model.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDto {

    private Integer idFactura;
    private String ruc;
    private LocalDate fecha;
    private String descripcionTipoPago;
    private String nombreCliente;
    private String cedulaCliente;
    private Double descuento;
    private Double total;
    private int cantidad;
    private double precio;
    private double subtotal;
    private String nombreClasifiacion;
}
