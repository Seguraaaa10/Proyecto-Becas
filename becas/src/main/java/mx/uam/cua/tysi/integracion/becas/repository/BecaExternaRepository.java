package mx.uam.cua.tysi.integracion.becas.repository;

import mx.uam.cua.tysi.integracion.becas.entity.BecaExterna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BecaExternaRepository extends JpaRepository<BecaExterna, Long> {
}