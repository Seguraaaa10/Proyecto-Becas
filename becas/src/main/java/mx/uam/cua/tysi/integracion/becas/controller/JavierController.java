package mx.uam.cua.tysi.integracion.becas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Javier")
public class JavierController {

    @GetMapping("/saludo")
    public String saludo() {
        return "Soy Javier Cirilo";
    }

    @GetMapping("/status")
    public String status() {
        return "Controller de Javier funcionando correctamente";
    }
}