package com.assessment.odds.service;

import com.assessment.odds.model.Match;
import com.assessment.odds.repository.MatchRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {

    private MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match getMatch(Long id) {
        return matchRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Match with id %d not found", id)));
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match saveMatch(Match match) {
        return matchRepository.save(match);
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
