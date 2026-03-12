package mx.uam.cua.tysi.integracion.becas.service;

import mx.uam.cua.tysi.integracion.becas.dto.BecaDTO;
import java.util.List;

public interface BecaService {

    BecaDTO createBeca(BecaDTO beca);

    List<BecaDTO> getBecas();

    BecaDTO getBecaById(Long id);

    BecaDTO updateBeca(Long id, BecaDTO becaDTO);

    void deleteBeca(Long id);

}