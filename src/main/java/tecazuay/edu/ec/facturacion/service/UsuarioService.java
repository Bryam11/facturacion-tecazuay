package tecazuay.edu.ec.facturacion.service;

import tecazuay.edu.ec.facturacion.resources.model.request.RequestUsuario;
import tecazuay.edu.ec.facturacion.resources.model.response.UsuarioDto;

import java.util.List;

public interface UsuarioService {

    String saveUsuario(RequestUsuario requestUsuario);

    List<UsuarioDto> getUsuarios();
}
