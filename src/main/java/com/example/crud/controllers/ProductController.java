package com.example.crud.controllers;

import com.example.crud.domain.product.RequestProduct;
import com.example.crud.domain.product.Product;
import com.example.crud.domain.product.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity getAllProducts(){
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity postProducts(@RequestBody @Valid RequestProduct data){
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return  ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable String id, @RequestBody @Valid RequestProduct data){
        Optional<Product> product = repository.findById(id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
