package com.assessment.odds.repository;

import com.assessment.odds.model.Odds;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface OddsRepository extends ListCrudRepository<Odds, Long> {

    List<Odds> findByMatchId(Long id);
}
