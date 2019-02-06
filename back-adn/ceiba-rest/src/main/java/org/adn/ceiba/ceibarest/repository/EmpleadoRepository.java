package org.adn.ceiba.ceibarest.repository;

import org.adn.ceiba.ceibarest.entity.Empleado;
import org.springframework.data.repository.CrudRepository;

/**
 * repository de empleado
 * 
 * @author jose.lozano
 *
 */
public interface EmpleadoRepository extends CrudRepository<Empleado, Integer> {

}
