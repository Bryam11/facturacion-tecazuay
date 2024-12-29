package tecazuay.edu.ec.facturacion.service;

import tecazuay.edu.ec.facturacion.resources.entity.Persona;
import tecazuay.edu.ec.facturacion.resources.model.request.RequestPersona;
import tecazuay.edu.ec.facturacion.resources.model.response.PersonaDto;

import java.util.List;

public interface PersonaService {
    String savePersona(RequestPersona requestPersona);

    List<PersonaDto> getPersonas();

    String updatePersona(RequestPersona requestPersona);
}
