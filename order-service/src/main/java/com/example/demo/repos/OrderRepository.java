package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Order;
import com.example.demo.exceptions.UserNotFoundException;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	public List<Order> findByUser(String user) throws UserNotFoundException;
}
