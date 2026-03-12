package mx.uam.cua.tysi.integracion.becas.service;


import mx.uam.cua.tysi.integracion.becas.entity.Alumno;
import mx.uam.cua.tysi.integracion.becas.repository.AlumnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public List<Alumno> obtenerTodos() {
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> obtenerPorId(Integer id) {
        return alumnoRepository.findById(id);
    }

    public Alumno guardarAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public void eliminarAlumno(Integer id) {
        alumnoRepository.deleteById(id);
    }
}
