package tecazuay.edu.ec.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tecazuay.edu.ec.facturacion.resources.entity.Competencia;

public interface CompetenciaRepository extends JpaRepository<Competencia, Integer> {
}
