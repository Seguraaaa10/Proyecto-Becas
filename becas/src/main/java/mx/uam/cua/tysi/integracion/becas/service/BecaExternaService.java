package mx.uam.cua.tysi.integracion.becas.service;

import mx.uam.cua.tysi.integracion.becas.dto.BecaExternaDTO;
import java.util.List;

public interface BecaExternaService {

    BecaExternaDTO create(BecaExternaDTO dto);

    List<BecaExternaDTO> getAll();

    BecaExternaDTO getById(Long id);

    BecaExternaDTO update(Long id, BecaExternaDTO dto);

    void delete(Long id);
}