package com.example.demo.entity;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level =AccessLevel.PRIVATE)
@Data
@NoArgsConstructor
public class Order {
int orderId;
String user;
private LocalDate orderDate;
Product product;
public Order(int orderId, String user, LocalDate orderDate, Product product) {
	super();
	this.orderId = orderId;
	this.user = user;
	this.orderDate =orderDate;
	this.product = product;
}

}
