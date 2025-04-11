package com.josebaron.springboot.jap.springbootJPA.controllers;

import com.josebaron.springboot.jap.springbootJPA.entities.Product;
import com.josebaron.springboot.jap.springbootJPA.service.IProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class producController {

    @Autowired
    private IProductService iProductService;

  @GetMapping("/products")
    public List<Product> list(){
        return iProductService.findAll();
    }

   @GetMapping("/id")
    public ResponseEntity<?> view(int id){
        Optional<Product> prodOp= iProductService.findById(id);
        if(prodOp.isPresent()){
            return ResponseEntity.ok(prodOp.get());
        }


        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Product> create(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body((iProductService.save(product)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody Product product){
        product.setId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body((iProductService.save(product)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable int id){
       Optional<Product> prodOp= iProductService.delete(id);
       if(prodOp.isPresent()){
           return ResponseEntity.ok(prodOp.get());
       }
       return ResponseEntity.notFound().build();
    }


}
