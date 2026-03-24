package mx.uam.cua.tysi.integracion.becas.repository;

import mx.uam.cua.tysi.integracion.becas.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}