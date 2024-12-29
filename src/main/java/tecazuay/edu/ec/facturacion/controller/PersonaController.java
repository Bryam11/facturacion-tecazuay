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
import tecazuay.edu.ec.facturacion.resources.entity.Persona;
import tecazuay.edu.ec.facturacion.resources.model.request.RequestPersona;
import tecazuay.edu.ec.facturacion.service.PersonaService;

@RestController
@Description("Controlador de personas")
@Tag(name = "Persona", description = "Controlador de personas")
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @PostMapping("/guardar")
    @Operation(summary = "Guardar persona", description = "Guarda una persona")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = String.class))})
    })
    public ResponseEntity<?> guardarPersona(@Valid @RequestBody RequestPersona requestPersona) {
        return ResponseEntity.ok(personaService.savePersona(requestPersona));
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar personas", description = "Lista todas las personas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Persona.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Persona.class))})
    })
    public ResponseEntity<?> listarPersonas() {
        return ResponseEntity.ok(personaService.getPersonas());
    }


    @PutMapping("/actualizar")
    @Operation(summary = "Actualizar persona", description = "Actualiza una persona")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = String.class))})
    })
    public ResponseEntity<?> actualizarPersona(@Valid @RequestBody RequestPersona requestPersona) {
        return ResponseEntity.ok(personaService.updatePersona(requestPersona));
    }


}
