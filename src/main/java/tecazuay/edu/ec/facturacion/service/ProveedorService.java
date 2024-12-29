package tecazuay.edu.ec.facturacion.service;

import tecazuay.edu.ec.facturacion.resources.model.response.ProveedoresDto;

import java.util.List;

public interface ProveedorService {

    List<ProveedoresDto> getProveedores();
}
