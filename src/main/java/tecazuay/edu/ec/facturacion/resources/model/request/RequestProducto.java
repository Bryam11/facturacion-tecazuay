package tecazuay.edu.ec.facturacion.resources.model.request;

public record RequestProducto(
        int stock,
        double precioUnitario,
        String unidad,
        Integer idClasificacion,
        Integer IdProveedor,
        Boolean iva,
        int idProducto
) {
}
