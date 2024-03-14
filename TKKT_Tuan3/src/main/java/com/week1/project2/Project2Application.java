package com.week1.project2;

import org.apache.catalina.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.week1.project2.models.Product;
import com.week1.project2.models.Users;
import com.week1.project2.repositories.ProductRepository;

@SpringBootApplication
public class Project2Application {

	public static void main(String[] args) {
		SpringApplication.run(Project2Application.class, args);
	}
	@Bean
	CommandLineRunner init(ProductRepository productRepository) {
		return args -> {
			for(int i=1;i<=5;i++) {
//				Users user = restTemplate.getForObject("http://localhost:8080/user/"+i, Users.class);
				productRepository.save(new Product("product"+i,i*1000,null));
			}
		};
	}
}
