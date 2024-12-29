package tecazuay.edu.ec.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tecazuay.edu.ec.facturacion.resources.entity.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}
