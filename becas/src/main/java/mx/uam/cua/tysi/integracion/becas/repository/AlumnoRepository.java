package mx.uam.cua.tysi.integracion.becas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import mx.uam.cua.tysi.integracion.becas.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

}