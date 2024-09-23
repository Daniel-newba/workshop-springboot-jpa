package com.aprendendo.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aprendendo.course.entities.Order;
import com.aprendendo.course.entities.User;
import com.aprendendo.course.repositories.OrderRepository;
import com.aprendendo.course.repositories.UserRepository;

@Component
public class OrderService {

	@Autowired
	private OrderRepository repository;

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

}
