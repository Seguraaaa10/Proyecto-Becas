package mx.uam.cua.tysi.integracion.becas.controller;


import mx.uam.cua.tysi.integracion.becas.entity.Alumno;
import mx.uam.cua.tysi.integracion.becas.service.AlumnoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping
    public List<Alumno> obtenerAlumnos() {
        return alumnoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Optional<Alumno> obtenerAlumno(@PathVariable Integer id) {
        return alumnoService.obtenerPorId(id);
    }

    @PostMapping
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        return alumnoService.guardarAlumno(alumno);
    }

    @PatchMapping("/{id}")
    public Alumno actualizarAlumno(@PathVariable Integer id, @RequestBody Alumno alumno) {

        Optional<Alumno> alumnoExistente = alumnoService.obtenerPorId(id);

        if (alumnoExistente.isPresent()) {

            Alumno a = alumnoExistente.get();

            if (alumno.getNombre() != null)
                a.setNombre(alumno.getNombre());

            if (alumno.getMatricula() != null)
                a.setMatricula(alumno.getMatricula());

            if (alumno.getCarrera() != null)
                a.setCarrera(alumno.getCarrera());

            if (alumno.getPromedio() != null)
                a.setPromedio(alumno.getPromedio());

            return alumnoService.guardarAlumno(a);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminarAlumno(@PathVariable Integer id) {
        alumnoService.eliminarAlumno(id);
    }

}
