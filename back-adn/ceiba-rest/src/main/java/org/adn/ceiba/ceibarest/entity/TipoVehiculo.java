package org.adn.ceiba.ceibarest.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String codigo;

	private String vehiculo;
	
	@Column(name="cupo")
	private Integer cupo;

	//bi-directional many-to-one association to Parqueadero
	@OneToMany(mappedBy="tipoVehiculo")
	private List<Parqueadero> parqueaderos;
	
	@Column(name = "placa_bloqueada")
	private String placaBloqueada;
	
	@Column(name = "dias_permitidos")
	private String diasPermitidos;
	

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getVehiculo() {
		return this.vehiculo;
	}

	public void setVehiculo(String vehiculo) {
		this.vehiculo = vehiculo;
	}

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
	
	public Integer getCupo() {
		return this.cupo;
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

	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}

}