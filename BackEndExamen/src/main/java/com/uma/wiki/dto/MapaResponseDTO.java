package com.uma.wiki.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MapaResponseDTO {

    @NotNull
    private String mapaId;

    private LocalDateTime date;

    private String lugar;

    private double latitud;

    private double longitud;

    private String email;

    private String image;
}
