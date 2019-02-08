package org.adn.ceiba.ceibarest.dto;

import java.io.Serializable;
import java.sql.Timestamp;

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

	private Long cilindraje;

	private String estado;

	private Timestamp horaIngreso;

	private Timestamp horaSalida;

	private String nombresPropietario;

	private String placaVehiculo;

	private EmpleadoDTO empleado;

	private TipoVehiculoDTO tipoVehiculo;
	
	private Long pagoCancelado;
	
	private Long valorCilindraje;
	
	private Long pagoTotal;
}
