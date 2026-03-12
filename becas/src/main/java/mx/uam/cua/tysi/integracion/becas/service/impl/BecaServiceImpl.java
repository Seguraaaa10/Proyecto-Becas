package mx.uam.cua.tysi.integracion.becas.service.impl;

import mx.uam.cua.tysi.integracion.becas.dto.BecaDTO;
import mx.uam.cua.tysi.integracion.becas.entity.Beca;
import mx.uam.cua.tysi.integracion.becas.repository.BecaRepository;
import mx.uam.cua.tysi.integracion.becas.service.BecaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BecaServiceImpl implements BecaService {

    private final BecaRepository becaRepository;

    public BecaServiceImpl(BecaRepository becaRepository){
        this.becaRepository = becaRepository;
    }

    @Override
    public BecaDTO createBeca(BecaDTO becaDTO){
        Beca beca = new Beca();

        beca.setNombre(becaDTO.getNombre());
        beca.setMontoTotal(becaDTO.getMontoTotal());
        beca.setMensualidad(becaDTO.getMensualidad());
        beca.setPeriodicidad(becaDTO.getPeriodicidad());
        beca.setDuracionMeses(becaDTO.getDuracionMeses());
        beca.setEstadoConvocatoria(becaDTO.getEstadoConvocatoria());

        Beca becaGuardada = becaRepository.save(beca);

        becaDTO.setId(becaGuardada.getId());

        return becaDTO;
    }

    @Override
    public List<BecaDTO> getBecas(){
        List<Beca> becas = becaRepository.findAll();
        List<BecaDTO> becaDTOS = new ArrayList<>();

        for(Beca beca : becas){
            BecaDTO becaDTO = new BecaDTO();

            becaDTO.setId(beca.getId());
            becaDTO.setNombre(beca.getNombre());
            becaDTO.setMontoTotal(beca.getMontoTotal());
            becaDTO.setMensualidad(beca.getMensualidad());
            becaDTO.setPeriodicidad(beca.getPeriodicidad());
            becaDTO.setDuracionMeses(beca.getDuracionMeses());
            becaDTO.setEstadoConvocatoria(beca.getEstadoConvocatoria());

            becaDTOS.add(becaDTO);
        }

        return becaDTOS;
    }

    @Override
    public BecaDTO getBecaById(Long id){
        Optional<Beca> beca = becaRepository.findById(id);

        BecaDTO becaDTO = new BecaDTO();

        if(beca.isPresent()){
            Beca b = beca.get();

            becaDTO.setId(b.getId());
            becaDTO.setNombre(b.getNombre());
            becaDTO.setMontoTotal(b.getMontoTotal());
            becaDTO.setMensualidad(b.getMensualidad());
            becaDTO.setPeriodicidad(b.getPeriodicidad());
            becaDTO.setDuracionMeses(b.getDuracionMeses());
            becaDTO.setEstadoConvocatoria(b.getEstadoConvocatoria());
        }

        return becaDTO;
    }

    @Override
    public BecaDTO updateBeca(Long id, BecaDTO becaDTO){
        Optional<Beca> becaOptional = becaRepository.findById(id);

        if(becaOptional.isPresent()){
            Beca beca = becaOptional.get();

            beca.setNombre(becaDTO.getNombre());
            beca.setMontoTotal(becaDTO.getMontoTotal());
            beca.setMensualidad(becaDTO.getMensualidad());
            beca.setPeriodicidad(becaDTO.getPeriodicidad());
            beca.setDuracionMeses(becaDTO.getDuracionMeses());
            beca.setEstadoConvocatoria(becaDTO.getEstadoConvocatoria());

            Beca becaActualizada = becaRepository.save(beca);

            becaDTO.setId(becaActualizada.getId());
        }

        return becaDTO;
    }

    @Override
    public void deleteBeca(Long id){
        becaRepository.deleteById(id);
    }
}