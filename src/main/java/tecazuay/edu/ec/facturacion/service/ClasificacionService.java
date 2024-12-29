package tecazuay.edu.ec.facturacion.service;


import tecazuay.edu.ec.facturacion.resources.model.request.RequestClasificacion;
import tecazuay.edu.ec.facturacion.resources.model.response.ClasificacionDto;

import java.util.List;

public interface ClasificacionService {

    String saveClasificacion(RequestClasificacion requestClasificacion);

    String updateClasificacion(RequestClasificacion requestClasificacion);

    List<ClasificacionDto> getClasificacion();
}
