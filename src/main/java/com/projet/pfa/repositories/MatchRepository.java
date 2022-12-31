package com.projet.pfa.repositories;

import com.projet.pfa.collections.Match;
import com.projet.pfa.collections.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchRepository extends MongoRepository<Match, String> {
}
