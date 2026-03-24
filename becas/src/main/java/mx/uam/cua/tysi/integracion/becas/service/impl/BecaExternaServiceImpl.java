package mx.uam.cua.tysi.integracion.becas.service.impl;

import mx.uam.cua.tysi.integracion.becas.dto.BecaExternaDTO;
import mx.uam.cua.tysi.integracion.becas.entity.BecaExterna;
import mx.uam.cua.tysi.integracion.becas.repository.BecaExternaRepository;
import mx.uam.cua.tysi.integracion.becas.service.BecaExternaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BecaExternaServiceImpl implements BecaExternaService {

    private final BecaExternaRepository repository;

    public BecaExternaServiceImpl(BecaExternaRepository repository){
        this.repository = repository;
    }

    @Override
    public BecaExternaDTO create(BecaExternaDTO dto){
        BecaExterna e = new BecaExterna();

        e.setNombre(dto.getNombre());
        e.setTipoBeca(dto.getTipoBeca());
        e.setMontoTotal(dto.getMontoTotal());
        e.setMensualidad(dto.getMensualidad());
        e.setDuracionMeses(dto.getDuracionMeses());
        e.setEstadoConvocatoria(dto.getEstadoConvocatoria());
        e.setPeriodicidad(dto.getPeriodicidad());

        BecaExterna guardada = repository.save(e);

        dto.setId(guardada.getIdBecasExternas());

        return dto;
    }

    @Override
    public List<BecaExternaDTO> getAll(){
        List<BecaExterna> lista = repository.findAll();
        List<BecaExternaDTO> dtos = new ArrayList<>();

        for(BecaExterna e : lista){
            BecaExternaDTO d = new BecaExternaDTO();

            d.setId(e.getIdBecasExternas());
            d.setNombre(e.getNombre());
            d.setTipoBeca(e.getTipoBeca());
            d.setMontoTotal(e.getMontoTotal());
            d.setMensualidad(e.getMensualidad());
            d.setDuracionMeses(e.getDuracionMeses());
            d.setEstadoConvocatoria(e.getEstadoConvocatoria());
            d.setPeriodicidad(e.getPeriodicidad());

            dtos.add(d);
        }

        return dtos;
    }

    @Override
    public BecaExternaDTO getById(Long id){
        Optional<BecaExterna> op = repository.findById(id);

        if(op.isPresent()){
            BecaExterna e = op.get();

            BecaExternaDTO d = new BecaExternaDTO();

            d.setId(e.getIdBecasExternas());
            d.setNombre(e.getNombre());
            d.setTipoBeca(e.getTipoBeca());
            d.setMontoTotal(e.getMontoTotal());
            d.setMensualidad(e.getMensualidad());
            d.setDuracionMeses(e.getDuracionMeses());
            d.setEstadoConvocatoria(e.getEstadoConvocatoria());
            d.setPeriodicidad(e.getPeriodicidad());

            return d;
        }

        return null;
    }

    @Override
    public BecaExternaDTO update(Long id, BecaExternaDTO dto){
        Optional<BecaExterna> op = repository.findById(id);

        if(op.isPresent()){
            BecaExterna e = op.get();

            e.setNombre(dto.getNombre());
            e.setTipoBeca(dto.getTipoBeca());
            e.setMontoTotal(dto.getMontoTotal());
            e.setMensualidad(dto.getMensualidad());
            e.setDuracionMeses(dto.getDuracionMeses());
            e.setEstadoConvocatoria(dto.getEstadoConvocatoria());
            e.setPeriodicidad(dto.getPeriodicidad());

            BecaExterna updated = repository.save(e);

            dto.setId(updated.getIdBecasExternas());
            return dto;
        }

        return null;
    }

    @Override
    public void delete(Long id){
        repository.deleteById(id);
    }
}