package org.adn.ceiba.ceibarest.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author jose.lozano
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDTO implements Serializable {
	
	private static final long serialVersionUID = 2790704236408771530L;

	private Integer id;

	private String apellidos;

	private String cargo;

	private String nombres;

}
