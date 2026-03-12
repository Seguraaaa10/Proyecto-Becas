package mx.uam.cua.tysi.integracion.becas.service;

import mx.uam.cua.tysi.integracion.becas.dto.AlumnoDTO;
import java.util.List;

public interface AlumnoService {

    AlumnoDTO createAlumno(AlumnoDTO alumnoDTO);

    List<AlumnoDTO> getAlumnos();

    AlumnoDTO getAlumnoById(Long id);

    AlumnoDTO updateAlumno(Long id, AlumnoDTO alumnoDTO);

    void deleteAlumno(Long id);

}