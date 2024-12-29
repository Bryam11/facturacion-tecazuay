package tecazuay.edu.ec.facturacion.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tecazuay.edu.ec.facturacion.repository.PersonaRepository;
import tecazuay.edu.ec.facturacion.repository.UsuarioRepository;
import tecazuay.edu.ec.facturacion.resources.entity.Usuario;
import tecazuay.edu.ec.facturacion.resources.model.request.RequestUsuario;
import tecazuay.edu.ec.facturacion.resources.model.response.UsuarioDto;
import tecazuay.edu.ec.facturacion.service.UsuarioService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PersonaRepository personaRepository;

    @Override
    @Transactional
    public String saveUsuario(RequestUsuario requestUsuario) {
        Usuario usuario = Usuario.builder()
                .username(requestUsuario.usuario())
                .password(requestUsuario.contrasena())
                .idPersona(personaRepository.findById(requestUsuario.idPersona()).orElseThrow(() -> new RuntimeException("Persona no encontrada")))
                .build();
        return usuarioRepository.save(usuario).getUsername() + " creado";
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDto> getUsuarios() {
        return usuarioRepository.findAll().stream().map(usuario -> UsuarioDto.builder()
                .idUsuario(usuario.getId())
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .rol(usuario.getIdRol().getRol())
                .build()).toList();
    }
}
