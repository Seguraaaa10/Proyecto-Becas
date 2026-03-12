package mx.uam.cua.tysi.integracion.becas.service.impl;

import mx.uam.cua.tysi.integracion.becas.dto.AlumnoDTO;
import mx.uam.cua.tysi.integracion.becas.entity.Alumno;
import mx.uam.cua.tysi.integracion.becas.repository.AlumnoRepository;
import mx.uam.cua.tysi.integracion.becas.service.AlumnoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlumnoServiceImpl implements AlumnoService {
    private final AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository){
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public AlumnoDTO createAlumno(AlumnoDTO alumnoDTO){

        Alumno alumno = new Alumno();

        alumno.setNombre(alumnoDTO.getNombre());
        alumno.setMatricula(alumnoDTO.getMatricula());
        alumno.setCarrera(alumnoDTO.getCarrera());
        alumno.setPromedio(alumnoDTO.getPromedio());

        Alumno alumnoGuardado = alumnoRepository.save(alumno);

        alumnoDTO.setId(alumnoGuardado.getIdAlumno());

        return alumnoDTO;
    }

    @Override
    public List<AlumnoDTO> getAlumnos(){

        List<Alumno> alumnos = alumnoRepository.findAll();
        List<AlumnoDTO> alumnoDTOS = new ArrayList<>();

        for(Alumno alumno : alumnos){

            AlumnoDTO alumnoDTO = new AlumnoDTO();

            alumnoDTO.setId(alumno.getIdAlumno());
            alumnoDTO.setNombre(alumno.getNombre());
            alumnoDTO.setMatricula(alumno.getMatricula());
            alumnoDTO.setCarrera(alumno.getCarrera());
            alumnoDTO.setPromedio(alumno.getPromedio());

            alumnoDTOS.add(alumnoDTO);
        }

        return alumnoDTOS;
    }

    @Override
    public AlumnoDTO getAlumnoById(Long id){

        Optional<Alumno> alumno = alumnoRepository.findById(id);

        AlumnoDTO alumnoDTO = new AlumnoDTO();

        if(alumno.isPresent()){

            Alumno a = alumno.get();

            alumnoDTO.setId(a.getIdAlumno());
            alumnoDTO.setNombre(a.getNombre());
            alumnoDTO.setMatricula(a.getMatricula());
            alumnoDTO.setCarrera(a.getCarrera());
            alumnoDTO.setPromedio(a.getPromedio());
        }

        return alumnoDTO;
    }

    @Override
    public AlumnoDTO updateAlumno(Long id, AlumnoDTO alumnoDTO){

        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);

        if(alumnoOptional.isPresent()){

            Alumno alumno = alumnoOptional.get();

            alumno.setNombre(alumnoDTO.getNombre());
            alumno.setMatricula(alumnoDTO.getMatricula());
            alumno.setCarrera(alumnoDTO.getCarrera());
            alumno.setPromedio(alumnoDTO.getPromedio());

            Alumno alumnoActualizado = alumnoRepository.save(alumno);

            alumnoDTO.setId(alumnoActualizado.getIdAlumno());
        }

        return alumnoDTO;
    }

    @Override
    public void deleteAlumno(Long id){

        alumnoRepository.deleteById(id);
    }
}
