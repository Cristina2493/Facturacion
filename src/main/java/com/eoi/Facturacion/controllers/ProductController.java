package com.eoi.Facturacion.controllers;

import com.eoi.Facturacion.entities.Product;
import com.eoi.Facturacion.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//Request -cualquier tipo de request es bueno (get/post/put/delete)
@RequestMapping("/products") //Al ponerlo antes de la clase, cualquier método que tenga esta clase va a tener este prefijo
public class ProductController {
    @Autowired //No necesitamos crear una instancia d ProduceService porque Spring lo hace automáticamente
    private ProductService productService;
    //Para acceder a los métodos avanzados del servicio

    @GetMapping(value = {"/",""}) //Dándole este valor va a funcionar siempre en el navegador se ponga / o no
    public String showProducts(Model model) {  //Model es el objeto que Spring usa para pasar a la vista (html) las variables que queremos mostrar
        model.addAttribute("products", productService.findAll());
        //Devuelve el nombre se la vista (html) que queremos mostrar
        //El combo de Springboot y Web nos permite usar el nombre de la vista sin poner la extensión
        return "product-list";
    }

    @GetMapping("/new") //Haces petición en la que esperas que te devuelvan datos
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form"; //Te devuelve un nuevo objeto tipo Product ya rellenado y para que la guarde en la BD
    }
    @PostMapping("/save") //Haces una petición en la que envías datos
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/products/"; //Postear ese producto en la BD y redirigir a la lista de productos
    }
    @GetMapping("/edit/{id}")
    public String showEditProductForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "product-form";
    }
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteById(id);
        return "redirect:/products/";
    }
}
