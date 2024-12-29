package tecazuay.edu.ec.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tecazuay.edu.ec.facturacion.resources.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
