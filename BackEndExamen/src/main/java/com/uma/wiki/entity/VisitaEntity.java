package com.uma.wiki.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Visita")
public class VisitaEntity {
    @MongoId
    @Getter
    @Builder.Default
    private ObjectId id = new ObjectId();

    private String autor;

    private String visitante;

    private String token;

    private LocalDateTime date;

    public VisitaEntity(String autor, String visitante, String token, LocalDateTime date) {
        this.autor = autor;
        this.visitante = visitante;
        this.token = token;
        this.date = date;
    }
}
