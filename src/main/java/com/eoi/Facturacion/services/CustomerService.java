package com.eoi.Facturacion.services;

import com.eoi.Facturacion.entities.Customer;
import com.eoi.Facturacion.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired //Inyección de dependecnias:accede al repositorio para guardar los objetos
    private CustomerRepository customerRepository;
    //Instancia el CustomerRepository automáticamente y lo usa cuando se necesite

    //Implementación de métodos principales que se usan al entrar en el CRUD
    public List<Customer> findAll() {
        return customerRepository.findAll();
        //Es un SELECT * FROM customer y los mete en un objeto de tipo lista
    }

    //Objeto de tipo opcional que controla si un objeto existe o no y evitar los null pointer
    //Null pointer: la dirección de memoria a la que se intenta acceder está vacía. El valor es nulo y genera un error.
    //El puntero que apunta a esa dirección no apunta a nada.
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
        //Devuelve un optional con el objeto que se busca o un optional vacío si no existe
        //Puedes operar con el optional aunque esté vacío o el Id no exista aún (maneja el tiempo intermedio)
    }
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }
}
