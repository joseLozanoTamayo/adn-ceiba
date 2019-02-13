package org.adn.ceiba.ceibarest.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

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
@NoArgsConstructor
@AllArgsConstructor
public class Parqueadero implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Long cilindraje;

	private String estado;

	@Column(name="hora_ingreso")
	private Timestamp horaIngreso;

	@Column(name="hora_salida")
	private Timestamp horaSalida;

	@Column(name="nombres_propietario")
	private String nombresPropietario;

	@Column(name="placa_vehiculo")
	private String placaVehiculo;

	//bi-directional many-to-one association to Empleado
	@ManyToOne
	@JoinColumn(name="fk_empleado")
	private Empleado empleado;

	//bi-directional many-to-one association to TipoVehiculo
	@ManyToOne
	@JoinColumn(name="fk_tipo_vehiculo")
	private TipoVehiculo tipoVehiculo;
	
	@Column(name = "pago_cancelado")
	private Long pagoCancelado;


	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getCilindraje() {
		return this.cilindraje;
	}

	public void setCilindraje(Long cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getHoraIngreso() {
		return this.horaIngreso;
	}

	public void setHoraIngreso(Timestamp horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public Timestamp getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(Timestamp horaSalida) {
		this.horaSalida = horaSalida;
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

	public TipoVehiculo getTipoVehiculo() {
		return this.tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Long getPagoCancelado() {
		return pagoCancelado;
	}

	public void setPagoCancelado(Long pagoCancelado) {
		this.pagoCancelado = pagoCancelado;
	}

}