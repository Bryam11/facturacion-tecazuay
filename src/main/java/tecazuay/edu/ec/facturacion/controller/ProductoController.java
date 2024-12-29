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
import tecazuay.edu.ec.facturacion.resources.model.request.RequestProducto;
import tecazuay.edu.ec.facturacion.resources.model.response.ProductoDto;
import tecazuay.edu.ec.facturacion.service.ProductoService;

@RestController
@Description("Controlador de productos")
@Tag(name = "Productos", description = "Controlador de productos")
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping(value = "/listar")
    @Operation(summary = "Listar productos", description = "Listar productos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProductoDto.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProductoDto.class))})
    })
    public ResponseEntity<?> listarProveedores() {
        return ResponseEntity.ok(productoService.getAll());
    }

    @PostMapping(value = "/crear")
    @Operation(summary = "Crear producto", description = "Crear producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProductoDto.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProductoDto.class))})
    })
    public ResponseEntity<?> crearProducto(@Valid @RequestBody RequestProducto requestProducto) {
        return ResponseEntity.ok(productoService.create(requestProducto));
    }

    @PutMapping(value = "/actualizar")
    @Operation(summary = "Actualizar producto", description = "Actualizar producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProductoDto.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ProductoDto.class))})
    })
    public ResponseEntity<?> actualizarProducto(@Valid @RequestBody RequestProducto requestProducto) {
        return ResponseEntity.ok(productoService.update(requestProducto));
    }

    @DeleteMapping(value = "/eliminar/{id}")
    @Operation(summary = "Eliminar producto", description = "Eliminar producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "500", description = "Internal error", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = String.class))})
    })
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer id) {
        return ResponseEntity.ok(productoService.delete(id));
    }
}
