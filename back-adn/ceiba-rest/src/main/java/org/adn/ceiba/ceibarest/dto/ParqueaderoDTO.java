package org.adn.ceiba.ceibarest.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

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
	
	private long valorCilindraje;
	
	private Long pagoTotal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Long cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(Timestamp horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public Timestamp getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(Timestamp horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getNombresPropietario() {
		return nombresPropietario;
	}

	public void setNombresPropietario(String nombresPropietario) {
		this.nombresPropietario = nombresPropietario;
	}

	public String getPlacaVehiculo() {
		return placaVehiculo;
	}

	public void setPlacaVehiculo(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
	}

	public EmpleadoDTO getEmpleado() {
		return empleado;
	}

	public void setEmpleado(EmpleadoDTO empleado) {
		this.empleado = empleado;
	}

	public TipoVehiculoDTO getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculoDTO tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Long getPagoCancelado() {
		return pagoCancelado;
	}

	public void setPagoCancelado(Long pagoCancelado) {
		this.pagoCancelado = pagoCancelado;
	}

	public long getValorCilindraje() {
		return valorCilindraje;
	}

	public void setValorCilindraje(long valorCilindraje) {
		this.valorCilindraje = valorCilindraje;
	}

	public Long getPagoTotal() {
		return pagoTotal;
	}

	public void setPagoTotal(Long pagoTotal) {
		this.pagoTotal = pagoTotal;
	}
	
	
}
