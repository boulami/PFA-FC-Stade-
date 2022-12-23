package com.projet.pfa.services;

import com.projet.pfa.collections.Stadium;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StadiumService {
    String save(Stadium stade);


    String update(String id, Stadium stade);

    void delete(String id);


    List<Stadium> getAll();
}
