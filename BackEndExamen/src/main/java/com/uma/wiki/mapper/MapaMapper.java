package com.uma.wiki.mapper;

import com.uma.wiki.dto.MapaCreateDTO;
import com.uma.wiki.dto.MapaResponseDTO;
import com.uma.wiki.dto.VisitaDTO;
import com.uma.wiki.entity.MapaEntity;
import com.uma.wiki.entity.VisitaEntity;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class MapaMapper {

    public static MapaResponseDTO toResponseDto(MapaEntity mapaEntity) {
        if (mapaEntity == null) {
            return null;
        }

        MapaResponseDTO dto = new MapaResponseDTO();
        dto.setMapaId(mapaEntity.getMapaId());
        dto.setEmail(mapaEntity.getEmail());
        dto.setLugar(mapaEntity.getLugar());
        dto.setDate(mapaEntity.getDate());
        dto.setImage(mapaEntity.getImage());
        dto.setLatitud(mapaEntity.getLatitud());
        dto.setLongitud(mapaEntity.getLongitud());

        return dto;
    }

    public static MapaEntity toEntityInCreation(MapaCreateDTO mapaCreateDTO, String image) {
        if (mapaCreateDTO == null) {
            return null;
        }

        return new MapaEntity(
                mapaCreateDTO.getDate(),
                mapaCreateDTO.getLugar(),
                mapaCreateDTO.getLatitud(),
                mapaCreateDTO.getLongitud(),
                mapaCreateDTO.getEmail(),
                image
        );
    }

    public static List<MapaResponseDTO> toResponseDto(List<MapaEntity> mapaEntities) {
        List<MapaResponseDTO> mapaResponseDTOList = new ArrayList<>();

        for(MapaEntity mapaEntity : mapaEntities){
            mapaResponseDTOList.add(toResponseDto(mapaEntity));
        }

        return mapaResponseDTOList;
    }

    public static VisitaDTO toVisitaDTO(VisitaEntity visitaEntity) {
        VisitaDTO visitaDTO = new VisitaDTO(
                visitaEntity.getAutor(),
                visitaEntity.getVisitante(),
                visitaEntity.getToken(),
                visitaEntity.getDate()
        );
        return visitaDTO;
    }

    public static List<VisitaDTO> toVisitaDTO(List<VisitaEntity> visitas) {
        List<VisitaDTO> visitaDTOList = new ArrayList<>();
        for(VisitaEntity visitaEntity : visitas){
            visitaDTOList.add(toVisitaDTO(visitaEntity));
        }
        return visitaDTOList;
    }

    public static VisitaEntity toVisitaEntity(VisitaDTO visitaDTO) {
        VisitaEntity visitaEntity = new VisitaEntity(visitaDTO.getAutor(), visitaDTO.getVisitante(), visitaDTO.getToken(), visitaDTO.getDate());
        return visitaEntity;
    }

}
