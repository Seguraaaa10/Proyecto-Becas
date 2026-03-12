package mx.uam.cua.tysi.integracion.becas.controller;

import mx.uam.cua.tysi.integracion.becas.dto.BecaDTO;
import mx.uam.cua.tysi.integracion.becas.service.BecaService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/becas/{id}")
    public BecaDTO getBecaById(@PathVariable Long id){
        return becaService.getBecaById(id);
    }

    @PatchMapping("/becas/{id}")
    public BecaDTO updateBeca(@PathVariable Long id, @RequestBody BecaDTO becaDTO){
        return becaService.updateBeca(id, becaDTO);
    }

    @DeleteMapping("/becas/{id}")
    public void deleteBeca(@PathVariable Long id){
        becaService.deleteBeca(id);
    }
}