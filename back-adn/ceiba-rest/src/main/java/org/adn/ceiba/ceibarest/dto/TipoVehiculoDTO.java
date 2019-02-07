package org.adn.ceiba.ceibarest.dto;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoVehiculoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String vehiculo;
    private String codigo;
	private Integer cupo;
	private String placaBloqueada;
	private String diasPermitidos;
	private Long pagoCilindraje;
}

