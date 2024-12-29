package tecazuay.edu.ec.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tecazuay.edu.ec.facturacion.resources.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
