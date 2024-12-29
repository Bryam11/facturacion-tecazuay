package tecazuay.edu.ec.facturacion.resources.model.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    private Integer idUsuario;
    private String username;
    private String password;
    private String rol;
}
