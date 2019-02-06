package org.adn.ceiba.ceibarest.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the parqueadero database table.
 * 
 */
@Entity
@NamedQuery(name="Parqueadero.findAll", query="SELECT p FROM Parqueadero p")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Parqueadero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Integer cilindraje;

	@Column(name="nombres_propietario")
	private String nombresPropietario;

	@Column(name="placa_vehiculo")
	private String placaVehiculo;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="fk_empleado")
	private Empleado empleado;

	//bi-directional many-to-one association to TipoParqueadero
	@ManyToOne
	@JoinColumn(name="fk_tipo_parqueadero")
	private TipoParqueadero tipoParqueadero;

	//bi-directional many-to-one association to TipoVehiculo
	@ManyToOne
	@JoinColumn(name="fk_tipo_vehiculo")
	private TipoVehiculo tipoVehiculo;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCilindraje() {
		return this.cilindraje;
	}

	public void setCilindraje(Integer cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getNombresPropietario() {
		return this.nombresPropietario;
	}

	public void setNombresPropietario(String nombresPropietario) {
		this.nombresPropietario = nombresPropietario;
	}

	public String getPlacaVehiculo() {
		return this.placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public TipoParqueadero getTipoParqueadero() {
		return this.tipoParqueadero;
	}

	public void setTipoParqueadero(TipoParqueadero tipoParqueadero) {
		this.tipoParqueadero = tipoParqueadero;
	}

	public TipoVehiculo getTipoVehiculo() {
		return this.tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

}