package tecazuay.edu.ec.facturacion.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jdk.jfr.Description;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tecazuay.edu.ec.facturacion.resources.entity.Clasificacion;
import tecazuay.edu.ec.facturacion.resources.model.request.RequestClasificacion;
import tecazuay.edu.ec.facturacion.service.ClasificacionService;

@RestController
@Description("Controlador de clasificaciones")
@Tag(name = "Clasificaciones", description = "Controlador de clasificaciones")
@RequestMapping("/clasificacion")
@RequiredArgsConstructor
public class ClasificacionController {

    private final ClasificacionService clasificacionService;

    @GetMapping("/listar")
    @Operation(summary = "Listar clasificaciones", description = "Listar clasificaciones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Clasificacion.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Clasificacion.class))})
    })
    public ResponseEntity<?> listarClasificaciones() {
        return ResponseEntity.ok(clasificacionService.getClasificacion());
    }

    @PostMapping("/crear")
    @Operation(summary = "Crear clasificacion", description = "Crear clasificacion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Clasificacion.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Clasificacion.class))})
    })
    public ResponseEntity<?> crearClasificacion(RequestClasificacion clasificacion) {
        return ResponseEntity.ok(clasificacionService.saveClasificacion(clasificacion));
    }

    @PutMapping("/actualizar")
    @Operation(summary = "Actualizar clasificacion", description = "Actualizar clasificacion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Clasificacion.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Clasificacion.class))})
    })
    public ResponseEntity<?> actualizarClasificacion(RequestClasificacion clasificacion) {
        return ResponseEntity.ok(clasificacionService.updateClasificacion(clasificacion));
    }
}
