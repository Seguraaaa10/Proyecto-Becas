package mx.uam.cua.tysi.integracion.becas.repository;

import mx.uam.cua.tysi.integracion.becas.entity.SolicitudBeca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudBecaRepository extends JpaRepository<SolicitudBeca, Long> {
}