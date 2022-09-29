package com.example.demo.entity;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level =AccessLevel.PRIVATE)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
int orderId;
String user;
private LocalDate orderDate;
Product product;
}
