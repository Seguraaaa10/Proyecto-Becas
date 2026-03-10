package mx.uam.cua.tysi.integracion.becas.controller;

import mx.uam.cua.tysi.integracion.becas.dto.BecaDTO;
import mx.uam.cua.tysi.integracion.becas.service.BecaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BecaController {

    private final BecaService becaService;

    public BecaController(BecaService becaService){
        this.becaService = becaService;
    }

    @PostMapping("/becas")
    public BecaDTO beca(@RequestBody BecaDTO becaDTO){
        return becaService.createBeca(becaDTO);
    }

    @GetMapping("/becas")
    public List<BecaDTO> getBecas(){
        return becaService.getBecas();
    }
}