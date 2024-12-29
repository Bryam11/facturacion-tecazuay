package tecazuay.edu.ec.facturacion.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tecazuay.edu.ec.facturacion.repository.ProveedorRepository;
import tecazuay.edu.ec.facturacion.resources.model.response.ProveedoresDto;
import tecazuay.edu.ec.facturacion.service.ProveedorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {

    private final ProveedorRepository proveedorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProveedoresDto> getProveedores() {
        return proveedorRepository.findAll().stream().map(proveedor -> {
            return ProveedoresDto.builder()
                    .idProveedor(proveedor.getId())
                    .pais(proveedor.getPais())
                    .telefono(proveedor.getTelefono())
                    .correo(proveedor.getCorreo())
                    .ruc(proveedor.getRuc())
                    .moneda(proveedor.getMoneda())
                    .build();
        }).toList();
    }
}
