package org.adn.ceiba.ceibarest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the tarifa database table.
 * 
 */
@Entity
@NamedQuery(name="Tarifa.findAll", query="SELECT t FROM Tarifa t")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="cilindro_vehiculo")
	private Long cilindroVehiculo;

	private String codigo;

	@Column(name="codigo_tipo_vehiculo")
	private String codigoTipoVehiculo;

	private Long dia;

	private Long hora;

	@Column(name="precio_cilindro")
	private Long precioCilindro;

	@Column(name="valor_dia")
	private Long valorDia;

	@Column(name="valor_hora")
	private Long valorHora;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCilindroVehiculo() {
		return this.cilindroVehiculo;
	}

	public void setCilindroVehiculo(Long cilindroVehiculo) {
		this.cilindroVehiculo = cilindroVehiculo;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigoTipoVehiculo() {
		return this.codigoTipoVehiculo;
	}

	public void setCodigoTipoVehiculo(String codigoTipoVehiculo) {
		this.codigoTipoVehiculo = codigoTipoVehiculo;
	}

	public Long getDia() {
		return this.dia;
	}

	public void setDia(Long dia) {
		this.dia = dia;
	}

	public Long getHora() {
		return this.hora;
	}

	public void setHora(Long hora) {
		this.hora = hora;
	}

	public Long getPrecioCilindro() {
		return this.precioCilindro;
	}

	public void setPrecioCilindro(Long precioCilindro) {
		this.precioCilindro = precioCilindro;
	}

	public Long getValorDia() {
		return this.valorDia;
	}

	public void setValorDia(Long valorDia) {
		this.valorDia = valorDia;
	}

	public Long getValorHora() {
		return this.valorHora;
	}

	public void setValorHora(Long valorHora) {
		this.valorHora = valorHora;
	}

}