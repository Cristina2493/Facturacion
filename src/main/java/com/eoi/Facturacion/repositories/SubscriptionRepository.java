package com.eoi.Facturacion.repositories;

import com.eoi.Facturacion.entities.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    //Declaramos el método aquí para que funcione en el InvoiceService
    //El JpaRepository ya tiene los métodos básicos del CRUD - implementamos el método findByName
    //JPA nos permite asumir que el método, vamos a crear una QUERY para buscar algo por el nombre en la BD
}
