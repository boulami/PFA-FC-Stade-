package com.projet.pfa.services;

import com.projet.pfa.collections.Reservation;
import com.projet.pfa.collections.Stadium;
import java.util.List;

public interface StadiumService {
    String save(Stadium stade);

    Stadium getStadeById(String id);

    String update(String id, Stadium stade);

    void delete(String id);

    List<Stadium> getAll();

}
