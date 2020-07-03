package com.election.voting.president.persistence.repositories;

import com.election.voting.president.persistence.entities.Candidate;
import com.election.voting.president.persistence.entities.Vote;
import com.election.voting.president.persistence.entities.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * VoteRepository interface
 */
public interface VoteRepository extends JpaRepository<Vote, Integer> {
    /**
     * Find vote associated with Voter
     * @param voter person who has voted for a candidate
     * @return found vote
     */
    Vote findByVoter(Voter voter);

    /**
     * Count number of votes for a given candidate
     * @param candidate a participator of an election
     * @return total votes found by candidate
     */
    Long countVotesByCandidate(Candidate candidate);

}
