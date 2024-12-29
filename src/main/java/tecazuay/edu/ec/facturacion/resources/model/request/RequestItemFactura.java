package tecazuay.edu.ec.facturacion.resources.model.request;

public record RequestItemFactura(
        Integer idProducto,
        Integer idFactura,
        Integer cantidad,
        Double precio,
        Double subtotal
) {
}
