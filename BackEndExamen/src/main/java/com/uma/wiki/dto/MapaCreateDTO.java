package com.uma.wiki.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class MapaCreateDTO {

    private LocalDateTime date;

    private String lugar;

    private double latitud;

    private double longitud;

    private String email;

    private MultipartFile image;
}
