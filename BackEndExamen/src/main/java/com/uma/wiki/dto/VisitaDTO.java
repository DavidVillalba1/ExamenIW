package com.uma.wiki.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class VisitaDTO {
    private String autor;
    private String visitante;
    private String token;
    private LocalDateTime date;
}
