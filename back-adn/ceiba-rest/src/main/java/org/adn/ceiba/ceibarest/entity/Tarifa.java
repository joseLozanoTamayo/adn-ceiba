package org.adn.ceiba.ceibarest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tarifa database table.
 * 
 */
@Entity
@NamedQuery(name="Tarifa.findAll", query="SELECT t FROM Tarifa t")
public class Tarifa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="cilindro_vehiculo")
	private Integer cilindroVehiculo;

	private String codigo;

	@Column(name="dia_horas")
	private Integer diaHoras;

	private Integer hora;

	@Column(name="precio_cilindro")
	private Integer precioCilindro;

	@Column(name="valor_dia")
	private Integer valorDia;

	@Column(name="valor_hora")
	private Integer valorHora;

	//bi-directional many-to-one association to TipoVehiculo
	@ManyToOne
	@JoinColumn(name="fk_tipo_vehiculo")
	private TipoVehiculo tipoVehiculo;

	//bi-directional many-to-one association to TipoParqueadero
	@OneToMany(mappedBy="tarifa")
	private List<TipoParqueadero> tipoParqueaderos;

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

	public Integer getDiaHoras() {
		return this.diaHoras;
	}

	public void setDiaHoras(Integer diaHoras) {
		this.diaHoras = diaHoras;
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

	public TipoVehiculo getTipoVehiculo() {
		return this.tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public List<TipoParqueadero> getTipoParqueaderos() {
		return this.tipoParqueaderos;
	}

	public void setTipoParqueaderos(List<TipoParqueadero> tipoParqueaderos) {
		this.tipoParqueaderos = tipoParqueaderos;
	}

	public TipoParqueadero addTipoParqueadero(TipoParqueadero tipoParqueadero) {
		getTipoParqueaderos().add(tipoParqueadero);
		tipoParqueadero.setTarifa(this);

		return tipoParqueadero;
	}

	public TipoParqueadero removeTipoParqueadero(TipoParqueadero tipoParqueadero) {
		getTipoParqueaderos().remove(tipoParqueadero);
		tipoParqueadero.setTarifa(null);

		return tipoParqueadero;
	}

}