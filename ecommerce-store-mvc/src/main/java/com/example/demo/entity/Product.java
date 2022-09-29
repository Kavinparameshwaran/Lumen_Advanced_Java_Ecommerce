package com.example.demo.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	int productId;
	String productName;
	double productPrice;
	int productInventory;
	String productMerchant;

//@Override
	public String toString() {
		return productName;
	}

}
