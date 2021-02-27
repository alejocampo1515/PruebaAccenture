package com.pruebasAccenture.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad de la tabla TBL_PRODUCTS
 * @author alejocampo
 *
 */

@Entity
@Table(name = "TBL_PRODUCTS")
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "reference")
	private String reference;

	@Column(name = "price")
	private String price;
	
	@Column(name = "stock")
	private String stock;
	
	
	@Override
	public String toString() {
		return "id="+id+" reference="+reference+ " price="+price+ " stock="+stock; 
	}

}
