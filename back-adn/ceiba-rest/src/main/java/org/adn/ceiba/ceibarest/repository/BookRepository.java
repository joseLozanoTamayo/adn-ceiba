package org.adn.ceiba.ceibarest.repository;

import org.adn.ceiba.ceibarest.entity.Publication;
import org.springframework.data.repository.CrudRepository;

/**
 * repository de empleado
 * 
 * @author jose.lozano
 *
 */
public interface BookRepository extends CrudRepository<Publication, Integer> {

}
