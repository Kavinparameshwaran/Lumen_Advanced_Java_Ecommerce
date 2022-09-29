package com.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.productservice.entity.Product;
import com.productservice.repos.ProductRepository;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner runner() {
//		return new CommandLineRunner() {
//			@Autowired
//			ProductRepository repo;
//			
//			@Override
//			public void run(String... args) throws Exception {
//				repo.save(new Product(103, "chips", 10, 50, "Bingo"));
//				
//			}
//		};
//	}
}
