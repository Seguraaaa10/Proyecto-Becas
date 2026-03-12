package mx.uam.cua.tysi.integracion.becas.controller;

import mx.uam.cua.tysi.integracion.becas.dto.AlumnoDTO;
import mx.uam.cua.tysi.integracion.becas.service.AlumnoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService){
        this.alumnoService = alumnoService;
    }

    @PostMapping("/alumnos")
    public AlumnoDTO alumno(@RequestBody AlumnoDTO alumnoDTO){
        return alumnoService.createAlumno(alumnoDTO);
    }

    @GetMapping("/alumnos")
    public List<AlumnoDTO> getAlumnos(){
        return alumnoService.getAlumnos();
    }

    @GetMapping("/alumnos/{id}")
    public AlumnoDTO getAlumnoById(@PathVariable Long id){
        return alumnoService.getAlumnoById(id);
    }

    @PatchMapping("/alumnos/{id}")
    public AlumnoDTO updateAlumno(@PathVariable Long id, @RequestBody AlumnoDTO alumnoDTO){
        return alumnoService.updateAlumno(id, alumnoDTO);
    }

    @DeleteMapping("/alumnos/{id}")
    public void deleteAlumno(@PathVariable Long id){
        alumnoService.deleteAlumno(id);
    }
}