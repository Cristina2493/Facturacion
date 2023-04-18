package com.eoi.Facturacion.repositories;

import com.eoi.Facturacion.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    //Declaramos el método aquí para que funcione en el InvoiceService
    //El JpaRepository ya tiene los métodos básicos del CRUD - implementamos el método findByName
    //JPA nos permite asumir que el método, vamos a crear una QUERY para buscar algo por el nombre en la BD
}
