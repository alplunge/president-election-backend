package com.election.voting.president.persistence.repositories;

import com.election.voting.president.persistence.entities.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * VoterRepository interface
 */
public interface VoterRepository extends JpaRepository<Voter, Integer> {
}
