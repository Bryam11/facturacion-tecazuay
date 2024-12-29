package tecazuay.edu.ec.facturacion.resources.model.request;

import java.time.LocalDate;

public record RequestFactura(
        String ruc,
        Integer idPersona,
        LocalDate fecha,
        Integer idTipoPago,
        Double descuento,
        Double total,
        Integer idProducto,
        Integer cantidad,
        Double precio,
        Double subtotal
) {
}
