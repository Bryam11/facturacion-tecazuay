package tecazuay.edu.ec.facturacion.resources.model.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDto {

    private Integer idPersona;
    private String nombre;
    private String apellido;
    private String correo;
    private String celular;
    private String dni;
}
