package org.adn.ceiba.ceibarest.repository;

import java.util.Collection;
import java.util.Optional;

import org.adn.ceiba.ceibarest.entity.Parqueadero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


/**
 * repository de parqueadero
 * 
 * @author jose.lozano
 *
 */
public interface ParqueaderoRepository extends CrudRepository<Parqueadero, Integer> {
	
	@Query(value = "select count(id) from parqueadero where estado = :estado " 
			+ "and fk_tipo_vehiculo = :tipoVehiculo ", nativeQuery = true)
	public Optional<Integer> obtenerCupoParqueadero(@Param("estado") String estado, @Param("tipoVehiculo") Integer tipoVehiculo);

	
	public Collection<Parqueadero> findByEstado(String estado);
	
}
