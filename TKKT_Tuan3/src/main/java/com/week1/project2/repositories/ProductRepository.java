package com.week1.project2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.week1.project2.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
}
