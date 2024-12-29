package tecazuay.edu.ec.facturacion.resources.model.request;

public record RequestUsuario(
        Integer idPersona,
        String usuario,
        String contrasena,
        Integer idRol
) {
}
