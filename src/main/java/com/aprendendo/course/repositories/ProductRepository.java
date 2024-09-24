package com.aprendendo.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendo.course.entities.Category;
import com.aprendendo.course.entities.Product;
import com.aprendendo.course.entities.User;

public interface ProductRepository extends JpaRepository<Product, Long>{

	
	
}
