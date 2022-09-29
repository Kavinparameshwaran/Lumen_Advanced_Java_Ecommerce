package com.productservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor


@Entity
@Table(name="lumen_product_2022")
public class Product {
	@Id
	@Column(name = "product_id")
	private int productId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_price")
	private double productPrice;
	@Column(name = "product_inventory")
	private int productInventory;
	@Column(name = "product_merchant")
	private String productMerchant;
	public Product(int productId, String productName,double productPrice, int productInventory,
			String productMerchant) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productInventory = productInventory;
		this.productMerchant = productMerchant;
	}
	

	
	
}
