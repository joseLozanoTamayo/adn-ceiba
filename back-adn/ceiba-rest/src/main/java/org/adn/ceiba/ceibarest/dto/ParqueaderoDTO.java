package org.adn.ceiba.ceibarest.dto;

import java.io.Serializable;

import org.adn.ceiba.ceibarest.entity.Empleado;
import org.adn.ceiba.ceibarest.entity.TipoParqueadero;
import org.adn.ceiba.ceibarest.entity.TipoVehiculo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParqueaderoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer cilindraje;

	private String nombresPropietario;

	private String placaVehiculo;

	private Empleado empleado;

	private TipoParqueadero tipoParqueadero;

	private TipoVehiculo tipoVehiculo;
}
