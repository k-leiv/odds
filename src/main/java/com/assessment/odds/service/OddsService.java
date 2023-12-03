package com.assessment.odds.service;

import com.assessment.odds.model.Odds;
import com.assessment.odds.repository.OddsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OddsService {

    private final OddsRepository oddsRepository;

    public OddsService(OddsRepository oddsRepository) {
        this.oddsRepository = oddsRepository;
    }

    public Odds getOdds(Long id) {
        return oddsRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Odds with id %d not found", id)));
    }

    public Odds saveOdds(Odds odds) {
        return oddsRepository.save(odds);
    }

    public void deleteOdds(Long id) {
        oddsRepository.deleteById(id);
    }

    public List<Odds> getByMatchId(Long matchId) {
        return oddsRepository.findByMatchId(matchId);
    }

    public void deleteOdds(List<Odds> odds) {
        oddsRepository.deleteAll(odds);
    }
}
