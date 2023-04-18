package com.eoi.Facturacion.controllers;

import com.eoi.Facturacion.entities.Invoice;
import com.eoi.Facturacion.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
//Request -cualquier tipo de request es bueno (get/post/put/delete)
@RequestMapping("/invoices") //Al ponerlo antes de la clase, cualquier método que tenga esta clase va a tener este prefijo
public class InvoiceController {
    @Autowired //No necesitamos crear una instancia d ProduceService porque Spring lo hace automáticamente
    private InvoiceService invoiceService;
    //Para acceder a los métodos avanzados del servicio

    @GetMapping(value = {"/",""}) //Dándole este valor va a funcionar siempre en el navegador se ponga / o no
    public String showInvoices(Model model) {  //Model es el objeto que Spring usa para pasar a la vista (html) las variables que queremos mostrar
        model.addAttribute("invoices", invoiceService.findAll());
        //Devuelve el nombre se la vista (html) que queremos mostrar
        //El combo de Springboot y Web nos permite usar el nombre de la vista sin poner la extensión
        return "invoice-list";
    }

    @GetMapping("/new") //Haces petición en la que esperas que te devuelvan datos
    public String showNewInvoiceForm(Model model) {
        model.addAttribute("invoice", new Invoice());
        return "invoice-form"; //Te devuelve un nuevo objeto tipo Invoice ya rellenado y para que la guarde en la BD
    }
    @PostMapping("/save") //Haces una petición en la que envías datos
    public String saveInvoice(@ModelAttribute("invoice") Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/invoices/"; //Postear ese invoiceo en la BD y redirigir a la lista de invoiceos
    }
    @GetMapping("/edit/{id}")
    public String showEditInvoiceForm(@PathVariable("id") Long id, Model model) {
        Optional<Invoice> invoice = invoiceService.findById(id);
        if(invoice.isPresent())
        {
            model.addAttribute("invoice", invoice.get());
            return "customer-invoice-form";
        }
        return "error";
    }
    @GetMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable("id") Long id) {
        invoiceService.deleteById(id);
        return "redirect:/invoices/";
    }
}
