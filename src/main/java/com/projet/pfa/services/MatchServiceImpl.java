package com.projet.pfa.services;

import com.projet.pfa.collections.Match;
import com.projet.pfa.repositories.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService{
    @Autowired
    private MatchRepository matchRepository;

    @Override
    public String save(Match match) {
        return matchRepository.save(match).getId();
    }
}
