package tecazuay.edu.ec.facturacion.resources.model.request;

public record RequestPersona(
        String dni,
        String nombre,
        String apellido,
        String celular,
        String correo
) {
}
