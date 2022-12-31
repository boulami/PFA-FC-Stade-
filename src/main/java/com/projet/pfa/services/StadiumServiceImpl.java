package com.projet.pfa.services;

import com.projet.pfa.collections.Stadium;
import com.projet.pfa.repositories.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StadiumServiceImpl implements StadiumService {

    @Autowired
    private StadiumRepository stadiumRepository;

    @Override
    public String save(Stadium stade) {
        return stadiumRepository.save(stade).getId();
    }

    @Override
    public Stadium getStadeById(String id) {
        return stadiumRepository.findById(id).get();
    }

    @Override
    public String update(String id, Stadium stade) {
        Stadium stadiumToUpdate = stadiumRepository.findById(id).get();
        stadiumToUpdate.setName(stade.getName());
        stadiumToUpdate.setAddress(stade.getAddress());

        return stadiumRepository.save(stadiumToUpdate).getName();
    }

    @Override
    public void delete(String id) {
        stadiumRepository.deleteById(id);
    }

    @Override
    public List<Stadium> getAll() {
        List<Stadium> stadeEntities = stadiumRepository.findAll();
        List<Stadium> stades = stadeEntities
                .stream()
                .map(std -> new Stadium(
                        std.getId(),
                        std.getName(),
                        std.getAddress()
                )).collect(Collectors.toList());
        return stades;
    }
}
