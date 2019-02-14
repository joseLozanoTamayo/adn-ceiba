package org.adn.ceiba.ceibarest.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 
 * @author jose.lozano
 *
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDTO implements Serializable {
	
	private static final long serialVersionUID = 2790704236408771530L;

	private Integer id;

	private String apellidos;

	private String cargo;

	private String nombres;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	
}
