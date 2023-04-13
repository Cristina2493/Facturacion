package com.eoi.Facturacion.controllers;

import com.eoi.Facturacion.entities.Product;
import com.eoi.Facturacion.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController  //Genera una API REST
@RequestMapping("/api/products")  //url que te devuelve la lista de productos
public class ProductRestController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Product> findById(@PathVariable Long id) {
        return productService.findById(id);
    }
    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
