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
import tecazuay.edu.ec.facturacion.resources.model.request.RequestFactura;
import tecazuay.edu.ec.facturacion.resources.model.response.FacturaDto;
import tecazuay.edu.ec.facturacion.service.FacturaService;

@RestController
@Description("Controlador de Facturas")
@Tag(name = "Facturas", description = "Controlador de Facturas")
@RequestMapping("/factura")
@RequiredArgsConstructor
public class FacturaController {

    private final FacturaService facturaService;

    @PostMapping("/generar")
    @Operation(summary = "Generar Factura", description = "Generar Factura")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = String.class))})
    })
    public ResponseEntity<?> generarFactura(@Valid @RequestBody RequestFactura requestFactura) {
        return ResponseEntity.ok(facturaService.saveFactura(requestFactura));
    }

    @GetMapping("/listar")
    @Operation(summary = "Listar Facturas", description = "Listar Facturas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = FacturaDto.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = FacturaDto.class))})
    })
    public ResponseEntity<?> listarFacturas() {
        return ResponseEntity.ok(facturaService.getAllFacturas());
    }
}
