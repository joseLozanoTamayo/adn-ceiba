package org.adn.ceiba.ceibarest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Test3 extends TipoVehiculo {
	
	@Column
	private String a;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
	

}
