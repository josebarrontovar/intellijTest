package com.josebaron.springboot.jap.springbootJPA.service;

import com.josebaron.springboot.jap.springbootJPA.entities.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> findAll();
    Optional<Product> findById(int id);
    Product save(Product product);
    Optional<Product> delete(int id);

}


