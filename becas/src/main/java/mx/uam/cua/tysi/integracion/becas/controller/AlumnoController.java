package mx.uam.cua.tysi.integracion.becas.controller;


import mx.uam.cua.tysi.integracion.becas.dto.AlumnoDTO;
import mx.uam.cua.tysi.integracion.becas.service.AlumnoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService){
        this.alumnoService = alumnoService;
    }

    @PostMapping
    public AlumnoDTO createAlumno(@RequestBody AlumnoDTO alumnoDTO){
        return alumnoService.createAlumno(alumnoDTO);
    }

    @GetMapping
    public List<AlumnoDTO> getAlumnos(){
        return alumnoService.getAlumnos();
    }

    @GetMapping("/{id}")
    public AlumnoDTO getAlumnoById(@PathVariable Long id){
        return alumnoService.getAlumnoById(id);
    }

    @PatchMapping("/{id}")
    public AlumnoDTO updateAlumno(@PathVariable Long id, @RequestBody AlumnoDTO alumnoDTO){
        return alumnoService.updateAlumno(id, alumnoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteAlumno(@PathVariable Long id){
        alumnoService.deleteAlumno(id);
    }

}
