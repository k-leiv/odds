package com.assessment.odds.repository;

import com.assessment.odds.model.Match;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends ListCrudRepository<Match, Long> {
}
