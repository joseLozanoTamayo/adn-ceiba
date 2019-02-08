package org.adn.ceiba.ceibarest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "Book")
public class Book extends Publication {

	@Column
	private int pages;

}
