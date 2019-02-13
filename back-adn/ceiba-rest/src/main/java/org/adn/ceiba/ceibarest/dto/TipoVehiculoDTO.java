package org.adn.ceiba.ceibarest.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

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
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getCupo() {
		return cupo;
	}
	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}
	public String getPlacaBloqueada() {
		return placaBloqueada;
	}
	public void setPlacaBloqueada(String placaBloqueada) {
		this.placaBloqueada = placaBloqueada;
	}
	public String getDiasPermitidos() {
		return diasPermitidos;
	}
	public void setDiasPermitidos(String diasPermitidos) {
		this.diasPermitidos = diasPermitidos;
	}
	
	
}

