package com.projet.pfa.repositories;

import com.projet.pfa.collections.Stadium;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StadiumRepository extends MongoRepository<Stadium, String> {

}
