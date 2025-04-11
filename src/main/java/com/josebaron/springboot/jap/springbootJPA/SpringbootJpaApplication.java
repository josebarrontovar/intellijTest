package com.josebaron.springboot.jap.springbootJPA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringbootJpaApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
		System.out.println("CORRIENDO CORRECTAMENTE");
	}

}
