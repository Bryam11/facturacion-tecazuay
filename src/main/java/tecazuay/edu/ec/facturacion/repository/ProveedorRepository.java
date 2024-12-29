package tecazuay.edu.ec.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tecazuay.edu.ec.facturacion.resources.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {
}
