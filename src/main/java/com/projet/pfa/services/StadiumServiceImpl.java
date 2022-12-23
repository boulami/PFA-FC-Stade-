package com.projet.pfa.services;

import com.projet.pfa.collections.Stadium;
import com.projet.pfa.repositories.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StadiumServiceImpl implements StadiumService {

    @Autowired
    private StadiumRepository stadiumRepository;

    @Override
    public String save(Stadium stade) {
        return stadiumRepository.save(stade).getId();
    }

    @Override
    public String update(String id, Stadium stade) {
        Stadium stadiumToUpdate = stadiumRepository.findById(id).get();
        stadiumToUpdate.setName(stade.getName());
        stadiumToUpdate.setAddress(stade.getAddress());
        return "updated successfully";
    }

    @Override
    public void delete(String id) {
        stadiumRepository.deleteById(id);
    }

    @Override
    public List<Stadium> getAll() {
        return stadiumRepository.findAll();
    }
}
