package com.josebaron.springboot.jap.springbootJPA.service;

import com.josebaron.springboot.jap.springbootJPA.entities.Product;
import com.josebaron.springboot.jap.springbootJPA.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) iProductRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(int id) {
        return iProductRepository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return iProductRepository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> delete(int id) {
        Optional<Product> productDB=iProductRepository.findById(id);
        productDB.ifPresent(p->iProductRepository.delete(p));
        return productDB;
    }

}
