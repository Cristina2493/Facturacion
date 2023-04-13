package com.eoi.Facturacion.repositories;

import com.eoi.Facturacion.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //Declaramos el método aqui para que funcione en el ProductService
    //El JpaRepository ya tiene los métodos básicos del CRUD - implementamos el método findByName
    //JPA nos permite asumir que el método, vamos a crear una QUERY para buscar algo por el nombre en la BD
    Optional<Product> findByName(String name);
}
