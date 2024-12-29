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
import tecazuay.edu.ec.facturacion.resources.model.request.RequestRol;
import tecazuay.edu.ec.facturacion.resources.model.response.RolDto;
import tecazuay.edu.ec.facturacion.service.RolService;

@RestController
@Description("Controlador de roles")
@Tag(name = "Rol", description = "Controlador de roles")
@RequestMapping("/rol")
@RequiredArgsConstructor
public class RolController {

    private final RolService rolService;

    @PostMapping("/crear")
    @Operation(summary = "Crear un rol", description = "Crea un rol")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = String.class))})
    })
    public ResponseEntity<?> guardarRol(@Valid @RequestBody RequestRol requestRol) {
        return ResponseEntity.ok(rolService.saveRol(requestRol));
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar roles", description = "Lista todos los roles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = RolDto.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = RolDto.class))})
    })
    public ResponseEntity<?> listarRoles() {
        return ResponseEntity.ok(rolService.getRoles());
    }
}
