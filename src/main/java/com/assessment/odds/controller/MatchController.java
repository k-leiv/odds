package com.assessment.odds.controller;

import com.assessment.odds.model.Match;
import com.assessment.odds.model.Odds;
import com.assessment.odds.service.MatchService;
import com.assessment.odds.service.OddsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matches")
public class MatchController {

    private final MatchService matchService;
    private final OddsService oddsService;

    public MatchController(MatchService matchService, OddsService oddsService) {
        this.matchService = matchService;
        this.oddsService = oddsService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Match> getMatch(@PathVariable Long id) {
        return ResponseEntity.ok().body(matchService.getMatch(id));
    }

    @GetMapping
    public ResponseEntity<List<Match>> getAllMatches() {
        return ResponseEntity.ok().body(matchService.getAllMatches());
    }

    @PostMapping
    public ResponseEntity<Match> saveMatch(@RequestBody Match match) {
        return ResponseEntity.ok().body(matchService.saveMatch(match));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteMatch(@PathVariable Long id) {
        List<Odds> odds = oddsService.getByMatchId(id);
        oddsService.deleteOdds(odds);
        matchService.deleteMatch(id);
    }

    @PostMapping("/{matchId}/odds")
    public ResponseEntity<Odds> saveOdds(@PathVariable Long matchId, @RequestBody Odds odds) {
        Match match = matchService.getMatch(matchId);
        odds.setMatch(match);
        return ResponseEntity.ok().body(oddsService.saveOdds(odds));
    }

    @GetMapping("/{matchId}/odds")
    public ResponseEntity<List<Odds>> getOdds(@PathVariable Long matchId) {
        return ResponseEntity.ok().body(oddsService.getByMatchId(matchId));
    }
}
