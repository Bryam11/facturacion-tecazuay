package tecazuay.edu.ec.facturacion.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tecazuay.edu.ec.facturacion.repository.PersonaRepository;
import tecazuay.edu.ec.facturacion.resources.entity.Persona;
import tecazuay.edu.ec.facturacion.resources.model.request.RequestPersona;
import tecazuay.edu.ec.facturacion.resources.model.response.PersonaDto;
import tecazuay.edu.ec.facturacion.service.PersonaService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;

    @Override
    @Transactional
    public String savePersona(RequestPersona requestPersona) {

        Persona persona = Persona.builder()
                .nombre(requestPersona.nombre())
                .apellido(requestPersona.apellido())
                .dni(requestPersona.dni())
                .correo(requestPersona.correo())
                .celular(requestPersona.celular())
                .build();

        personaRepository.save(persona);
        return "Persona creada";
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonaDto> getPersonas() {
        return personaRepository.findAll().stream().map(persona -> PersonaDto.builder()
                .idPersona(persona.getId())
                .nombre(persona.getNombre())
                .apellido(persona.getApellido())
                .dni(persona.getDni())
                .correo(persona.getCorreo())
                .celular(persona.getCelular())
                .build()).toList();
    }

    @Override
    public String updatePersona(RequestPersona requestPersona) {
        return personaRepository.findByDni(requestPersona.dni()).map(persona -> {
            persona.setNombre(requestPersona.nombre());
            persona.setApellido(requestPersona.apellido());
            persona.setCorreo(requestPersona.correo());
            persona.setCelular(requestPersona.celular());
            personaRepository.save(persona);
            return "Persona actualizada";
        }).orElse("Persona no encontrada");
    }
}
