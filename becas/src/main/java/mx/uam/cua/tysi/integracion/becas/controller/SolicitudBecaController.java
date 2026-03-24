package mx.uam.cua.tysi.integracion.becas.controller;

import mx.uam.cua.tysi.integracion.becas.dto.SolicitudBecaDTO;
import mx.uam.cua.tysi.integracion.becas.service.SolicitudBecaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SolicitudBecaController {

    private final SolicitudBecaService service;

    public SolicitudBecaController(SolicitudBecaService service) {
        this.service = service;
    }

    @PostMapping("/solicitudes")
    public SolicitudBecaDTO create(@RequestBody SolicitudBecaDTO dto) {
        return service.createSolicitud(dto);
    }

    @GetMapping("/solicitudes")
    public List<SolicitudBecaDTO> getAll() {
        return service.getSolicitudes();
    }

    @GetMapping("/solicitudes/{id}")
    public SolicitudBecaDTO getById(@PathVariable Long id) {
        return service.getSolicitudById(id);
    }

    @PatchMapping("/solicitudes/{id}")
    public SolicitudBecaDTO update(@PathVariable Long id, @RequestBody SolicitudBecaDTO dto) {
        return service.updateSolicitud(id, dto);
    }

    @DeleteMapping("/solicitudes/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSolicitud(id);
    }
}