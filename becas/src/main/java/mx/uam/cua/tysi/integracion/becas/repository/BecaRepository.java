package mx.uam.cua.tysi.integracion.becas.repository;

import mx.uam.cua.tysi.integracion.becas.entity.Beca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BecaRepository extends JpaRepository<Beca, Long> {
}
