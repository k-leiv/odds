package com.assessment.odds.controller;

import com.assessment.odds.model.Odds;
import com.assessment.odds.service.OddsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/odds")
public class OddsController {

    private final OddsService oddsService;

    public OddsController(OddsService oddsService) {
        this.oddsService = oddsService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Odds> getOdds(@PathVariable Long id) {
        return ResponseEntity.ok().body(oddsService.getOdds(id));
    }

    @PutMapping
    public ResponseEntity<Odds> updateOdds(@RequestBody Odds odds) {
        return ResponseEntity.ok().body(oddsService.saveOdds(odds));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOdds(@PathVariable Long id) {
        oddsService.deleteOdds(id);
    }
}
