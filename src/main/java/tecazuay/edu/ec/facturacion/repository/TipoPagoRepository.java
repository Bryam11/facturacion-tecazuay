package tecazuay.edu.ec.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tecazuay.edu.ec.facturacion.resources.entity.TipoPago;

public interface TipoPagoRepository extends JpaRepository<TipoPago, Integer> {
}
