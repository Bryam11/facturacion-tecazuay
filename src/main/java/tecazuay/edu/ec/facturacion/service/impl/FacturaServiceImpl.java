package tecazuay.edu.ec.facturacion.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tecazuay.edu.ec.facturacion.repository.*;
import tecazuay.edu.ec.facturacion.resources.entity.Factura;
import tecazuay.edu.ec.facturacion.resources.entity.ItemFactura;
import tecazuay.edu.ec.facturacion.resources.model.request.RequestFactura;
import tecazuay.edu.ec.facturacion.resources.model.response.FacturaDto;
import tecazuay.edu.ec.facturacion.service.FacturaService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FacturaServiceImpl implements FacturaService {

    private final FacturaRepository facturaRepository;
    private final ItemFacturaRepository itemFacturaRepository;
    private final ProductoRepository productoRepository;
    private final PersonaRepository personaRepository;
    private final TipoPagoRepository tipoPagoRepository;

    @Override
    @Transactional
    public String saveFactura(RequestFactura requestFactura) {

        Factura factura = Factura.builder()
                .ruc(requestFactura.ruc())
                .idPersona(personaRepository.findById(requestFactura.idPersona()).orElseThrow(() -> new RuntimeException("Persona no encontrada")))
                .idTipoPago(tipoPagoRepository.findById(requestFactura.idTipoPago()).orElseThrow(() -> new RuntimeException("Tipo de pago no encontrado")))
                .fecha(requestFactura.fecha())
                .total(requestFactura.total())
                .descuento(requestFactura.descuento())
                .build();

        facturaRepository.save(factura);

        ItemFactura itemFactura = ItemFactura.builder()
                .idFactura(factura)
                .idProducto(productoRepository.findById(requestFactura.idProducto()).orElseThrow(() -> new RuntimeException("Producto no encontrado")))
                .cantidad(requestFactura.cantidad())
                .precio(requestFactura.precio())
                .subtotal(requestFactura.subtotal())
                .idFactura(factura)
                .build();

        itemFacturaRepository.save(itemFactura);

        return "Factura creada";
    }

    @Override
    @Transactional(readOnly = true)
    public List<FacturaDto> getAllFacturas() {
        return facturaRepository.findAll().stream().map(factura -> FacturaDto.builder()
                .idFactura(factura.getId())
                .ruc(factura.getRuc())
                .fecha(factura.getFecha())
                .descripcionTipoPago(factura.getIdTipoPago().getDescrip())
                .nombreCliente(factura.getIdPersona().getNombre() + " " + factura.getIdPersona().getApellido())
                .cedulaCliente(factura.getIdPersona().getDni())
                .total(factura.getTotal())
                .descuento(factura.getDescuento())
                .cantidad(factura.getItemFacturas().stream().map(ItemFactura::getCantidad).reduce(0, Integer::sum))
                .precio(factura.getItemFacturas().stream().map(ItemFactura::getPrecio).reduce(0.0, Double::sum))
                .subtotal(factura.getItemFacturas().stream().map(ItemFactura::getSubtotal).reduce(0.0, Double::sum))
                .nombreClasifiacion(factura.getItemFacturas().stream()
                        .map(itemFactura -> itemFactura.getIdProducto().getIdClasificacion().getGrupo())
                        .collect(Collectors.joining(", ")))
                .build()).toList();
    }
}
