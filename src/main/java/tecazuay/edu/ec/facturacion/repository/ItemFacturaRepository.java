package tecazuay.edu.ec.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tecazuay.edu.ec.facturacion.resources.entity.ItemFactura;

public interface ItemFacturaRepository extends JpaRepository<ItemFactura, Integer> {
}
