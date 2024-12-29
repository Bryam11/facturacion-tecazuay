package tecazuay.edu.ec.facturacion.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tecazuay.edu.ec.facturacion.repository.CompetenciaRepository;
import tecazuay.edu.ec.facturacion.repository.RolRepository;
import tecazuay.edu.ec.facturacion.resources.entity.Rol;
import tecazuay.edu.ec.facturacion.resources.model.request.RequestRol;
import tecazuay.edu.ec.facturacion.resources.model.response.RolDto;
import tecazuay.edu.ec.facturacion.service.RolService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;
    private final CompetenciaRepository competenciaRepository;

    @Override
    @Transactional
    public String saveRol(RequestRol requestRol) {

        Rol rol = Rol.builder()
                .rol(requestRol.nombre())
                .estado(true)
                .idCompetencia(competenciaRepository.findById(requestRol.idCompetencia()).orElseThrow(() -> new RuntimeException("Competencia no encontrada")))
                .build();

        return rolRepository.save(rol).getRol() + " creado";
    }

    @Override
    @Transactional(readOnly = true)
    public List<RolDto> getRoles() {
        return rolRepository.findAll().stream().map(rol -> RolDto.builder()
                .idRol(rol.getId())
                .nombre(rol.getRol())
                .descripcion(rol.getRol())
                .competencia(rol.getIdCompetencia().getDescrip())
                .idCompetencia(rol.getIdCompetencia().getId())
                .build()).toList();
    }
}
