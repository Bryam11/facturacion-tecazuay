package tecazuay.edu.ec.facturacion.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tecazuay.edu.ec.facturacion.resources.model.request.RequestUsuario;
import tecazuay.edu.ec.facturacion.resources.model.response.UsuarioDto;
import tecazuay.edu.ec.facturacion.service.UsuarioService;

@RestController
@Description("Controlador de usuarios")
@Tag(name = "Usuario", description = "Controlador de usuarios")
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/guardar")
    @Operation(summary = "Crear un usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = String.class))})
    })
    public ResponseEntity<?> guardarRol(@Valid @RequestBody RequestUsuario requestUsuario) {
        return ResponseEntity.ok(usuarioService.saveUsuario(requestUsuario));
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar usuarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = UsuarioDto.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = UsuarioDto.class))})
    })
    public ResponseEntity<?> listarUsuarios() {
        return ResponseEntity.ok(usuarioService.getUsuarios());
    }
}
