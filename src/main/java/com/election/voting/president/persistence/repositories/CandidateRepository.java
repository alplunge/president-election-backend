package com.election.voting.president.persistence.repositories;

import com.election.voting.president.persistence.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CandidateRepository interface
 */
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
}
