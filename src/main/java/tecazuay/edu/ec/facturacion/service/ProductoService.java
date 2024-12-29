package tecazuay.edu.ec.facturacion.service;

import tecazuay.edu.ec.facturacion.resources.model.request.RequestProducto;
import tecazuay.edu.ec.facturacion.resources.model.response.ProductoDto;

import java.util.List;

public interface ProductoService {

    List<ProductoDto> getAll();

    String create(RequestProducto productoDto);

    String update(RequestProducto productoDto);

    String delete(Integer id);
}
