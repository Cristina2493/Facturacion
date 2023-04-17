package com.eoi.Facturacion.repositories;

import com.eoi.Facturacion.entities.Customer;
import com.eoi.Facturacion.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //Declaramos el método aquí para que funcione en el InvoiceService
    //El JpaRepository ya tiene los métodos básicos del CRUD - implementamos el método findByName
    //JPA nos permite asumir que el método, vamos a crear una QUERY para buscar algo por el nombre en la BD
}
