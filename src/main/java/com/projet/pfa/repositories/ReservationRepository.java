package com.projet.pfa.repositories;

import com.projet.pfa.collections.Match;
import com.projet.pfa.collections.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends MongoRepository<Reservation, String> {
    List<Reservation> findAll();
}
