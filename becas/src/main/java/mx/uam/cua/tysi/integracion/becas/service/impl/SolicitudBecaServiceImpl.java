package mx.uam.cua.tysi.integracion.becas.service.impl;

import mx.uam.cua.tysi.integracion.becas.dto.SolicitudBecaDTO;
import mx.uam.cua.tysi.integracion.becas.entity.Alumno;
import mx.uam.cua.tysi.integracion.becas.entity.SolicitudBeca;
import mx.uam.cua.tysi.integracion.becas.repository.AlumnoRepository;
import mx.uam.cua.tysi.integracion.becas.repository.SolicitudBecaRepository;
import mx.uam.cua.tysi.integracion.becas.service.SolicitudBecaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SolicitudBecaServiceImpl implements SolicitudBecaService {

    private final SolicitudBecaRepository repository;
    private final AlumnoRepository alumnoRepository;

    public SolicitudBecaServiceImpl(SolicitudBecaRepository repository,
                                    AlumnoRepository alumnoRepository) {
        this.repository = repository;
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public SolicitudBecaDTO createSolicitud(SolicitudBecaDTO dto) {

        SolicitudBeca s = new SolicitudBeca();

        s.setFechaSolicitud(dto.getFechaSolicitud());
        s.setEstado(dto.getEstado());
        s.setIdBecaUAM(dto.getIdBecaUAM());
        s.setIdBecaExterior(dto.getIdBecaExterior());

        if (dto.getIdAlumno() != null) {
            Optional<Alumno> alumno = alumnoRepository.findById(dto.getIdAlumno());
            if (alumno.isPresent()) {
                s.setAlumno(alumno.get());
            }
        }

        SolicitudBeca guardada = repository.save(s);

        dto.setId(guardada.getIdSolicitudBeca());

        return dto;
    }

    @Override
    public List<SolicitudBecaDTO> getSolicitudes() {

        List<SolicitudBeca> lista = repository.findAll();
        List<SolicitudBecaDTO> dtos = new ArrayList<>();

        for (SolicitudBeca s : lista) {

            SolicitudBecaDTO d = new SolicitudBecaDTO();

            d.setId(s.getIdSolicitudBeca());
            d.setFechaSolicitud(s.getFechaSolicitud());
            d.setEstado(s.getEstado());

            if (s.getAlumno() != null) {
                d.setIdAlumno(s.getAlumno().getIdAlumno());
            }

            d.setIdBecaUAM(s.getIdBecaUAM());
            d.setIdBecaExterior(s.getIdBecaExterior());

            dtos.add(d);
        }

        return dtos;
    }

    @Override
    public SolicitudBecaDTO getSolicitudById(Long id) {

        Optional<SolicitudBeca> op = repository.findById(id);
        SolicitudBecaDTO d = new SolicitudBecaDTO();

        if (op.isPresent()) {

            SolicitudBeca s = op.get();

            d.setId(s.getIdSolicitudBeca());
            d.setFechaSolicitud(s.getFechaSolicitud());
            d.setEstado(s.getEstado());

            if (s.getAlumno() != null) {
                d.setIdAlumno(s.getAlumno().getIdAlumno());
            }

            d.setIdBecaUAM(s.getIdBecaUAM());
            d.setIdBecaExterior(s.getIdBecaExterior());
        }

        return d;
    }

    @Override
    public SolicitudBecaDTO updateSolicitud(Long id, SolicitudBecaDTO dto) {

        Optional<SolicitudBeca> op = repository.findById(id);

        if (op.isPresent()) {

            SolicitudBeca s = op.get();

            s.setFechaSolicitud(dto.getFechaSolicitud());
            s.setEstado(dto.getEstado());
            s.setIdBecaUAM(dto.getIdBecaUAM());
            s.setIdBecaExterior(dto.getIdBecaExterior());

            if (dto.getIdAlumno() != null) {
                Optional<Alumno> alumno = alumnoRepository.findById(dto.getIdAlumno());
                if (alumno.isPresent()) {
                    s.setAlumno(alumno.get());
                }
            }

            SolicitudBeca updated = repository.save(s);

            dto.setId(updated.getIdSolicitudBeca());
        }

        return dto;
    }

    @Override
    public void deleteSolicitud(Long id) {
        repository.deleteById(id);
    }
}