package mx.uam.cua.tysi.integracion.becas.service;



import mx.uam.cua.tysi.integracion.becas.dto.AlumnoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    AlumnoDTO createAlumno(AlumnoDTO alumnoDTO);

    List<AlumnoDTO> getAlumnos();

    AlumnoDTO getAlumnoById(Long id);

    AlumnoDTO updateAlumno(Long id, AlumnoDTO alumnoDTO);

    void deleteAlumno(Long id);

}
