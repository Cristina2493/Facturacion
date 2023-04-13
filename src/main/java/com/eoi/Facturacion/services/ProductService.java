package com.eoi.Facturacion.services;

import com.eoi.Facturacion.entities.Product;
import com.eoi.Facturacion.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired //Inyección de dependecnias:accede al repositorio para guardar los objetos
    private ProductRepository productRepository;
    //Instancia el ProductRepository automáticamente y lo usa cuando se necesite

    //Implementación de métodos principales que se usan al entrar en el CRUD
    public List<Product> findAll() {
        return productRepository.findAll();
        //Es un SELECT * FROM products y los mete en un objeto de tipo lista
    }

    //Objeto de tipo opcional que controla si un objeto existe o no y evitar los null pointer
    //Null pointer: la dirección de memoria a la que se intenta acceder está vacía. El valor es nulo y genera un error.
    //El puntero que apunta a esa dirección no apunta a nada.
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
        //Devuelve un optional con el objeto que se busca o un optional vacío si no existe
        //Puedes operar con el optional aunque esté vacío o el Id no exista aún (maneja el tiempo intermedio)
    }

    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
        //Para que funcione, hay que crear el método de findByName en el ProductRepository
    }
    public Product save(Product product) {
        return productRepository.save(product);
    }
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
