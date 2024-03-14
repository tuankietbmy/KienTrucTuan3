package com.week1.project2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.week1.project2.models.Product;
import com.week1.project2.models.Users;
import com.week1.project2.repositories.ProductRepository;

import jakarta.websocket.server.PathParam;

@RestController
public class ProductController {
	@Autowired
	ProductRepository repository;
	RestTemplate restTemplate = new RestTemplate();
	
	@GetMapping("/products")
	ResponseEntity getProducts() {
		return new ResponseEntity(repository.findAll(),HttpStatus.OK);
	}
	@GetMapping("/findById/{id}")
	ResponseEntity findById(@PathVariable(name = "id") long id){
		Users user = restTemplate.getForObject("http://localhost:8080/user/"+id, Users.class);
		Product product = repository.findById(id).get();
		product.setUser(user);
		return new ResponseEntity(product, HttpStatus.OK);
	}
	
}
