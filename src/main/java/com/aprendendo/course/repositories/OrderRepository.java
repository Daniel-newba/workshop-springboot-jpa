package com.aprendendo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendo.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	
	
}
