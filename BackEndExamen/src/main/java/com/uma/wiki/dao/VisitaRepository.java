package com.uma.wiki.dao;


import com.uma.wiki.entity.VisitaEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VisitaRepository extends MongoRepository<VisitaEntity, ObjectId> {
    public List<VisitaEntity> findByAutorOrderByDate(String autor);
}
