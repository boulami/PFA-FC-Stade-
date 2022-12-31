package com.projet.pfa.controllers;

import com.projet.pfa.collections.Match;
import com.projet.pfa.repositories.MatchRepository;
import com.projet.pfa.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/match")
public class MatchController {
    @Autowired
    private MatchService matchService;
    @Autowired
    private MatchRepository matchRepository;

    @CrossOrigin(origins = "http://localhost:8082")
    @PostMapping("/save")
    public String save(@RequestBody Match match) {
        return matchService.save(match);
    }
}
