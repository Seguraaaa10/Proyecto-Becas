package mx.uam.cua.tysi.integracion.becas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Emiliano")
public class LeonardoController {

    @GetMapping("/saludo")
    public String saludo() {
        return "Soy Leonardo Segura";
    }

    @GetMapping("/status")
    public String status() {
        return "Controller de Leonardo funcionando correctamente";
    }
}