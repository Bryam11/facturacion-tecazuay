package tecazuay.edu.ec.facturacion.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tecazuay.edu.ec.facturacion.repository.ClasificacionRepository;
import tecazuay.edu.ec.facturacion.resources.entity.Clasificacion;
import tecazuay.edu.ec.facturacion.resources.model.request.RequestClasificacion;
import tecazuay.edu.ec.facturacion.resources.model.response.ClasificacionDto;
import tecazuay.edu.ec.facturacion.service.ClasificacionService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClasificacionServiceImpl implements ClasificacionService {

    private final ClasificacionRepository clasificacionRepository;

    @Override
    public String saveClasificacion(RequestClasificacion requestClasificacion) {
        Clasificacion clasificacion = Clasificacion.builder()
                .grupo(requestClasificacion.grupo())
                .build();
        clasificacionRepository.save(clasificacion);
        return "Clasificacion creada";
    }

    @Override
    public String updateClasificacion(RequestClasificacion requestClasificacion) {
        return clasificacionRepository.findById(requestClasificacion.idClasificacion()).map(clasificacion -> {
            clasificacion.setGrupo(requestClasificacion.grupo());
            clasificacionRepository.save(clasificacion);
            return "Clasificacion actualizada";
        }).orElse("Clasificacion no encontrada");
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClasificacionDto> getClasificacion() {
        return clasificacionRepository.findAll().stream().map(clasificacion -> ClasificacionDto.builder()
                .idClasificacion(clasificacion.getId())
                .grupo(clasificacion.getGrupo())
                .build()).toList();
    }
}
