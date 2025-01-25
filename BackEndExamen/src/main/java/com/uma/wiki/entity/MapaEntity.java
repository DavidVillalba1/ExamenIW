package com.uma.wiki.entity;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Mapa")
public class MapaEntity {

    @MongoId
    @Getter
    @Builder.Default
    private ObjectId id = new ObjectId();

    @NotNull
    @Getter
    private String mapaId;

    private LocalDateTime date;

    private String lugar;

    private double latitud;

    private double longitud;

    private String email;

    private String image;

    public MapaEntity(LocalDateTime date, String lugar, double latitud, double longitud, String email, String image) {
        this.mapaId = UUID.randomUUID().toString();
        this.date = date;
        this.lugar = lugar;
        this.latitud = latitud;
        this.longitud = longitud;
        this.email = email;
        this.image = image;
    }
}
