package org.adn.ceiba.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tarifa database table.
 * 
 */
@Entity
@NamedQuery(name="Tarifa.findAll", query="SELECT t FROM Tarifa t")
public class Tarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="cilindro_vehiculo")
	private Integer cilindroVehiculo;

	private String codigo;

	@Column(name="codigo_tipo_vehiculo")
	private String codigoTipoVehiculo;

	private Integer dia;

	private Integer hora;

	@Column(name="precio_cilindro")
	private Integer precioCilindro;

	@Column(name="valor_dia")
	private Integer valorDia;

	@Column(name="valor_hora")
	private Integer valorHora;

	public Tarifa() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCilindroVehiculo() {
		return this.cilindroVehiculo;
	}

	public void setCilindroVehiculo(Integer cilindroVehiculo) {
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

	public Integer getDia() {
		return this.dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getHora() {
		return this.hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public Integer getPrecioCilindro() {
		return this.precioCilindro;
	}

	public void setPrecioCilindro(Integer precioCilindro) {
		this.precioCilindro = precioCilindro;
	}

	public Integer getValorDia() {
		return this.valorDia;
	}

	public void setValorDia(Integer valorDia) {
		this.valorDia = valorDia;
	}

	public Integer getValorHora() {
		return this.valorHora;
	}

	public void setValorHora(Integer valorHora) {
		this.valorHora = valorHora;
	}

}