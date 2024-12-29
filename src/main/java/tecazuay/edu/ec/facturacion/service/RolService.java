package tecazuay.edu.ec.facturacion.service;

import tecazuay.edu.ec.facturacion.resources.model.request.RequestRol;
import tecazuay.edu.ec.facturacion.resources.model.response.RolDto;

import java.util.List;

public interface RolService {

    String saveRol(RequestRol requestRol);

    List<RolDto> getRoles();
}
