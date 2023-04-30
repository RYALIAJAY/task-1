package com.example.task1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.task1.model.Server;

@Repository
public interface ServerRepository extends MongoRepository<Server, String> {

}
