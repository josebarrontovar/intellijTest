package com.josebaron.springboot.jap.springbootJPA.repositories;

import com.josebaron.springboot.jap.springbootJPA.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductRepository extends CrudRepository<Product,Integer> {


 List<Product> findByAgeLessThan(int age);
}
