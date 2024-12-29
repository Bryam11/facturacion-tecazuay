package tecazuay.edu.ec.facturacion.service.impl;

import tecazuay.edu.ec.facturacion.repository.CompetenciaRepository;
import tecazuay.edu.ec.facturacion.resources.entity.Competencia;
import tecazuay.edu.ec.facturacion.resources.model.request.RequestCompetencia;
import tecazuay.edu.ec.facturacion.service.CompetenciaService;

public class CompetenciaServiceImpl implements CompetenciaService {

    private CompetenciaRepository competenciaRepository;

    @Override
    public String saveCompetencia(RequestCompetencia requestCompetencia) {

        Competencia competencia = Competencia.builder()
                .nombre(requestCompetencia.nombre())
                .descrip(requestCompetencia.descripcion())
                .build();
        return competenciaRepository.save(competencia).getNombre() + " guardado";
    }
}
