package org.adn.ceiba.ceibarest.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TipoVehiculoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String tipo;

}
