package com.crisil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductEntities {

	private Integer id;
	private String name;
	private float price;

	public ProductEntities() {
		// TODO Auto-generated constructor stub
	}

	public ProductEntities(Integer id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@Id
	@Column
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
