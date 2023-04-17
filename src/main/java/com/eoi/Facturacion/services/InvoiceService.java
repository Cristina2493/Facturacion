package com.eoi.Facturacion.services;

import com.eoi.Facturacion.entities.Invoice;
import com.eoi.Facturacion.entities.Product;
import com.eoi.Facturacion.repositories.InvoiceRepository;
import com.eoi.Facturacion.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired //Inyección de dependecnias:accede al repositorio para guardar los objetos
    private InvoiceRepository invoiceRepository;
    //Instancia el InvoiceRepository automáticamente y lo usa cuando se necesite

    //Implementación de métodos principales que se usan al entrar en el CRUD
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
        //Es un SELECT * FROM invoice y los mete en un objeto de tipo lista
    }

    //Objeto de tipo opcional que controla si un objeto existe o no y evitar los null pointer
    //Null pointer: la dirección de memoria a la que se intenta acceder está vacía. El valor es nulo y genera un error.
    //El puntero que apunta a esa dirección no apunta a nada.
    public Optional<Invoice> findById(Long id) {
        return invoiceRepository.findById(id);
        //Devuelve un optional con el objeto que se busca o un optional vacío si no existe
        //Puedes operar con el optional aunque esté vacío o el Id no exista aún (maneja el tiempo intermedio)
    }
    public Invoice save(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }
    public void deleteById(Long id) {
        invoiceRepository.deleteById(id);
    }
}
