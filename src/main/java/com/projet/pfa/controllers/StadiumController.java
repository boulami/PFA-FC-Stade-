package com.projet.pfa.controllers;

import com.projet.pfa.collections.Stadium;
import com.projet.pfa.collections.User;
import com.projet.pfa.repositories.StadiumRepository;
import com.projet.pfa.services.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/stadium")
public class StadiumController {
    @Autowired
    private StadiumService stadiumService;

    @Autowired
    private StadiumRepository stadiumRepository;

    @CrossOrigin(origins = "http://localhost:8082")
    @PostMapping("/add")
    public String save(@RequestBody Stadium stadium) {
        return stadiumService.save(stadium);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping("/getStade/{id}")
    public Stadium getStadeById(@PathVariable String id){
        return stadiumService.getStadeById(id);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @GetMapping("/getAllStades")
    public List<Stadium> getAllStades(){
        return stadiumService.getAll();
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @PutMapping("/update/{id}")
    public String update(@PathVariable String id,
                         @RequestBody Stadium stade){
        return stadiumService.update(id, stade);
    }

    @CrossOrigin(origins = "http://localhost:8082")
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {

        stadiumService.delete(id);
        return "Deleted successfully";
    }
}
