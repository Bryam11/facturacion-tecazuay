package tecazuay.edu.ec.facturacion.service;

import tecazuay.edu.ec.facturacion.resources.model.request.RequestFactura;
import tecazuay.edu.ec.facturacion.resources.model.response.FacturaDto;

import java.util.List;

public interface FacturaService {

    String saveFactura(RequestFactura requestFactura);

    List<FacturaDto> getAllFacturas();


}
