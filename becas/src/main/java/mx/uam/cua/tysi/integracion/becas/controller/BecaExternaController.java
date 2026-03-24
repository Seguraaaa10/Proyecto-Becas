package mx.uam.cua.tysi.integracion.becas.controller;

import mx.uam.cua.tysi.integracion.becas.dto.BecaExternaDTO;
import mx.uam.cua.tysi.integracion.becas.service.BecaExternaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/becas_externas")
@CrossOrigin(origins = "*")
public class BecaExternaController {

    private final BecaExternaService service;

    public BecaExternaController(BecaExternaService service){
        this.service = service;
    }

    @PostMapping
    public BecaExternaDTO create(@RequestBody BecaExternaDTO dto){
        return service.create(dto);
    }

    @GetMapping
    public List<BecaExternaDTO> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public BecaExternaDTO getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PatchMapping("/{id}")
    public BecaExternaDTO update(@PathVariable Long id, @RequestBody BecaExternaDTO dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}