package com.uma.wiki.service;

import com.uma.wiki.dao.MapRepository;
import com.uma.wiki.dto.*;
import com.uma.wiki.entity.MapaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.uma.wiki.mapper.MapaMapper.*;

@Service
public class MapaService {

    @Autowired
    private MapRepository mapRepository;

    @Autowired
    private S3Service s3Service;

    public List<MapaResponseDTO> getAll() {
        List<MapaEntity> events = mapRepository.findAll();

        return  toResponseDto(events);
    }

    public List<MapaResponseDTO> getByEmail(String email){
        List<MapaEntity> mapaEntity = this.mapRepository.findByEmail(email);
        return toResponseDto(mapaEntity);
    }

    public MapaResponseDTO createMapa(MapaCreateDTO mapaCreateDTO) {
        String imageUrl = "";
        if (mapaCreateDTO.getImage() != null) imageUrl = s3Service.uploadImageToS3(mapaCreateDTO.getImage());
        MapaEntity mapaEntity = toEntityInCreation(mapaCreateDTO, imageUrl);
        MapaEntity savedMapaEntity = mapRepository.save(mapaEntity);

        return toResponseDto(savedMapaEntity);
    }
}
