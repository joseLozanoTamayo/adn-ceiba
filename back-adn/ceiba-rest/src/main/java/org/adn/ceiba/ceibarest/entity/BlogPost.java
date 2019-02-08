package org.adn.ceiba.ceibarest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "BlogPost")
public class BlogPost extends Publication {

	@Column
	private String url;

}
