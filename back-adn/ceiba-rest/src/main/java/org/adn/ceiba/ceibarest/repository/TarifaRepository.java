package org.adn.ceiba.ceibarest.repository;

import java.util.Optional;

import org.adn.ceiba.ceibarest.entity.Tarifa;
import org.springframework.data.repository.CrudRepository;


/**
 * repository de tipo parqueadero
 * 
 * @author jose.lozano
 *
 */
public interface TarifaRepository extends CrudRepository<Tarifa, Integer> {
	
	public Optional<Tarifa> findByCodigoTipoVehiculo(String codigoTipoVehiculo);

}
