package tecazuay.edu.ec.facturacion.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tecazuay.edu.ec.facturacion.repository.ClasificacionRepository;
import tecazuay.edu.ec.facturacion.repository.ProductoRepository;
import tecazuay.edu.ec.facturacion.repository.ProveedorRepository;
import tecazuay.edu.ec.facturacion.resources.entity.Producto;
import tecazuay.edu.ec.facturacion.resources.model.request.RequestProducto;
import tecazuay.edu.ec.facturacion.resources.model.response.ProductoDto;
import tecazuay.edu.ec.facturacion.service.ProductoService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ClasificacionRepository clasificacionRepository;
    private final ProveedorRepository proveedorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDto> getAll() {
        return productoRepository.findAll().stream().map(producto -> ProductoDto.builder()
                .idProducto(producto.getId())
                .precioUnitario(producto.getPrecioUnitario())
                .stock(producto.getStock())
                .unidad(producto.getUnidad())
                .idClasificacion(producto.getIdClasificacion().getId())
                .grupoClasificacion(producto.getIdClasificacion().getGrupo())
                .idProveedor(producto.getIdProveedor().getId())
                .rucProveedor(producto.getIdProveedor().getRuc())
                .build()).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public String create(RequestProducto productoDto) {
        Producto producto = Producto.builder()
                .precioUnitario(productoDto.precioUnitario())
                .stock(productoDto.stock())
                .unidad(productoDto.unidad())
                .idClasificacion(clasificacionRepository.findById(productoDto.idClasificacion()).orElseThrow(() -> new RuntimeException("Clasificacion no encontrada")))
                .idProveedor(proveedorRepository.findById(productoDto.IdProveedor()).orElseThrow(() -> new RuntimeException("Proveedor no encontrado")))
                .build();
        productoRepository.save(producto);

        return "Producto creado";
    }

    @Override
    @Transactional
    public String update(RequestProducto productoDto) {
        return productoRepository.findById(productoDto.idProducto()).map(producto -> {
            producto.setPrecioUnitario(productoDto.precioUnitario());
            producto.setStock(productoDto.stock());
            producto.setUnidad(productoDto.unidad());
            producto.setIdClasificacion(clasificacionRepository.findById(productoDto.idClasificacion()).orElseThrow(() -> new RuntimeException("Clasificacion no encontrada")));
            producto.setIdProveedor(proveedorRepository.findById(productoDto.IdProveedor()).orElseThrow(() -> new RuntimeException("Proveedor no encontrado")));
            productoRepository.save(producto);
            return "Producto actualizado";
        }).orElse("Producto no encontrado para actualizar");

    }

    @Override
    public String delete(Integer id) {
        return productoRepository.findById(id).map(producto -> {
            productoRepository.delete(producto);
            return "Producto eliminado";
        }).orElse("Producto no encontrado para eliminar");
    }
}
