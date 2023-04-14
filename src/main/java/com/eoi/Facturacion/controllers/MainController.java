package com.eoi.Facturacion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value = {"/",""}) //Dándole este valor va a funcionar siempre en el navegador se ponga / o no
    public String showHome(){
        return "home";
    }

}
