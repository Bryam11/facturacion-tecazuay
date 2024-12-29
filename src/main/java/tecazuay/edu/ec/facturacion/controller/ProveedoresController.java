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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tecazuay.edu.ec.facturacion.resources.model.response.ProveedoresDto;
import tecazuay.edu.ec.facturacion.service.ProveedorService;

@RestController
@Description("Controlador de proveedores")
@Tag(name = "Proveedores", description = "Controlador de proveedores")
@RequestMapping("/proveedores")
@RequiredArgsConstructor
public class ProveedoresController {

    private final ProveedorService proveedorService;

    @GetMapping(value = "/listar")
    @Operation(summary = "Listar proveedores", description = "Listar todos los proveedores")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProveedoresDto.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProveedoresDto.class))})
    })
    public ResponseEntity<?> listarProveedores() {
        return ResponseEntity.ok(proveedorService.getProveedores());
    }
}
