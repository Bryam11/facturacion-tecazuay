package tecazuay.edu.ec.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tecazuay.edu.ec.facturacion.resources.entity.Persona;

import java.util.Optional;

public interface PersonaRepository  extends JpaRepository<Persona, Integer> {

    Optional<Persona> findByDni(String dni);
}
