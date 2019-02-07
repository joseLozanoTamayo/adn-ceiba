package org.adn.ceiba.ceibarest.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Empleado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String apellidos;

	private String cargo;

	private String nombres;

	//bi-directional many-to-one association to Parqueadero
	@OneToMany(mappedBy="empleado")
	private List<Parqueadero> parqueaderos;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<Parqueadero> getParqueaderos() {
		return this.parqueaderos;
	}

	public void setParqueaderos(List<Parqueadero> parqueaderos) {
		this.parqueaderos = parqueaderos;
	}

	public Parqueadero addParqueadero(Parqueadero parqueadero) {
		getParqueaderos().add(parqueadero);
		parqueadero.setEmpleado(this);

		return parqueadero;
	}

	public Parqueadero removeParqueadero(Parqueadero parqueadero) {
		getParqueaderos().remove(parqueadero);
		parqueadero.setEmpleado(null);

		return parqueadero;
	}

}