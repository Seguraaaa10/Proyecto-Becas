package mx.uam.cua.tysi.integracion.becas.service;

import mx.uam.cua.tysi.integracion.becas.dto.SolicitudBecaDTO;
import java.util.List;

public interface SolicitudBecaService {

    SolicitudBecaDTO createSolicitud(SolicitudBecaDTO dto);

    List<SolicitudBecaDTO> getSolicitudes();

    SolicitudBecaDTO getSolicitudById(Long id);

    SolicitudBecaDTO updateSolicitud(Long id, SolicitudBecaDTO dto);

    void deleteSolicitud(Long id);
}