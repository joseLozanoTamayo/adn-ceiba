package org.adn.ceiba.ceibarest.repository;

import org.adn.ceiba.ceibarest.entity.Empleado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * repository de empleado
 * 
 * @author jose.lozano
 *
 */
@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Integer> {

}
