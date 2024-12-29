package tecazuay.edu.ec.facturacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tecazuay.edu.ec.facturacion.resources.entity.Clasificacion;

import java.util.List;

public interface ClasificacionRepository extends JpaRepository<Clasificacion, Integer> {

    @Query("SELECT c FROM Clasificacion c LEFT JOIN FETCH c.productos")
    List<Clasificacion> findAllWithProductos();

}

