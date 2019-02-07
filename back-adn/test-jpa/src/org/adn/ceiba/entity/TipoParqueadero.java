package org.adn.ceiba.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_parqueadero database table.
 * 
 */
@Entity
@Table(name="tipo_parqueadero")
@NamedQuery(name="TipoParqueadero.findAll", query="SELECT t FROM TipoParqueadero t")
public class TipoParqueadero implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String codigo;

	@Column(name="cupo_carro")
	private Integer cupoCarro;

	@Column(name="cupo_moto")
	private Integer cupoMoto;

	//bi-directional many-to-one association to Parqueadero
	@OneToMany(mappedBy="tipoParqueadero")
	private List<Parqueadero> parqueaderos;

	public TipoParqueadero() {
	}

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

	public Integer getCupoCarro() {
		return this.cupoCarro;
	}

	public void setCupoCarro(Integer cupoCarro) {
		this.cupoCarro = cupoCarro;
	}

	public Integer getCupoMoto() {
		return this.cupoMoto;
	}

	public void setCupoMoto(Integer cupoMoto) {
		this.cupoMoto = cupoMoto;
	}

	public List<Parqueadero> getParqueaderos() {
		return this.parqueaderos;
	}

	public void setParqueaderos(List<Parqueadero> parqueaderos) {
		this.parqueaderos = parqueaderos;
	}

	public Parqueadero addParqueadero(Parqueadero parqueadero) {
		getParqueaderos().add(parqueadero);
		parqueadero.setTipoParqueadero(this);

		return parqueadero;
	}

	public Parqueadero removeParqueadero(Parqueadero parqueadero) {
		getParqueaderos().remove(parqueadero);
		parqueadero.setTipoParqueadero(null);

		return parqueadero;
	}

}