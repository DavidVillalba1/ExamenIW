package com.uma.wiki.dao;

import com.uma.wiki.entity.MapaEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MapRepository extends MongoRepository<MapaEntity, ObjectId>{
    List<MapaEntity> findByEmail(String email);
}

