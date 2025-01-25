package com.uma.wiki.service;

import com.uma.wiki.dao.VisitaRepository;
import com.uma.wiki.dto.VisitaDTO;
import com.uma.wiki.entity.VisitaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.uma.wiki.mapper.MapaMapper.*;

import java.util.List;

@Service
public class VisitaService {

    @Autowired
    private VisitaRepository visitaRepository;

    public List<VisitaDTO> getVisitasByAutor(String autor){
        List<VisitaEntity> visitas = visitaRepository.findByAutorOrderByDate(autor);

        return toVisitaDTO(visitas);
    }

    public VisitaDTO crearVisita(VisitaDTO visitaDTO){
        VisitaEntity visita = toVisitaEntity(visitaDTO);
        visitaRepository.save(visita);
        return toVisitaDTO(visita);
    }
}
