package org.adn.ceiba.ceibarest.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the tipo_vehiculo database table.
 * 
 */
@Entity
@Table(name="tipo_vehiculo")
@NamedQuery(name="TipoVehiculo.findAll", query="SELECT t FROM TipoVehiculo t")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoVehiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private String tipo;

	//bi-directional many-to-one association to Parqueadero
	@OneToMany(mappedBy="tipoVehiculo")
	private List<Parqueadero> parqueaderos;

	//bi-directional many-to-one association to Tarifa
	@OneToMany(mappedBy="tipoVehiculo")
	private List<Tarifa> tarifas;
	

	public List<Parqueadero> getParqueaderos() {
		return this.parqueaderos;
	}

	public void setParqueaderos(List<Parqueadero> parqueaderos) {
		this.parqueaderos = parqueaderos;
	}

	public Parqueadero addParqueadero(Parqueadero parqueadero) {
		getParqueaderos().add(parqueadero);
		parqueadero.setTipoVehiculo(this);

		return parqueadero;
	}

	public Parqueadero removeParqueadero(Parqueadero parqueadero) {
		getParqueaderos().remove(parqueadero);
		parqueadero.setTipoVehiculo(null);

		return parqueadero;
	}

	public List<Tarifa> getTarifas() {
		return this.tarifas;
	}

	public void setTarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}

	public Tarifa addTarifa(Tarifa tarifa) {
		getTarifas().add(tarifa);
		tarifa.setTipoVehiculo(this);

		return tarifa;
	}

	public Tarifa removeTarifa(Tarifa tarifa) {
		getTarifas().remove(tarifa);
		tarifa.setTipoVehiculo(null);

		return tarifa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}