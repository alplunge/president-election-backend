package com.election.voting.president.service;

import com.election.voting.president.persistence.entities.Candidate;
import com.election.voting.president.persistence.entities.Vote;
import com.election.voting.president.persistence.repositories.CandidateRepository;
import com.election.voting.president.persistence.repositories.VoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * CandidateService implementation
 */
@Service("candidateService")
@Transactional
public class CandidateServiceImpl implements CandidateService {

    private static final Logger logger = LoggerFactory.getLogger(VoteServiceImpl.class);

    private final CandidateRepository candidateRepository;
    private final VoteRepository voteRepository;

    @Autowired
    public CandidateServiceImpl(CandidateRepository candidateRepository, VoteRepository voteRepository) {
        this.candidateRepository = candidateRepository;
        this.voteRepository = voteRepository;
    }

    /**
     * Retrieve all candidates from the database
     *
     * @return the candidates list
     */
    @Override
    public List<Candidate> findAll() {
        return candidateRepository.findAll();
    }

    @Override
    public List<Candidate> getWinningCandidates() {
        Map<Candidate, Long> sortedCandidates = new LinkedHashMap<>();
        voteRepository.findAll()
                .stream()
                .collect(groupingBy(Vote::getCandidate, counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(entry -> sortedCandidates.put(entry.getKey(), entry.getValue()));
        List<Candidate> candidates = findWinningCandidates(sortedCandidates);
        if (candidates.size() > 2) {
            logger.error("More than two participants has been found with the same amount of votes");
            throw new IllegalStateException("To many participants (" +candidates.size()+ ") have the same amount of votes. No clear winner.");
        }
        return candidates;
    }

    /**
     * Sort out winner candidate by checking if any of them has votes share more than 50%
     * else 2 most voted candidates will be added
     * if there is more than two candidates with the same amount of votes these will be reflected in the list
     *
     * @param candidates candidates and their votes
     *
     * @return winner candidates as Candidate's
     */
    private List<Candidate> findWinningCandidates(Map<Candidate, Long> candidates) {
        if (candidates.isEmpty()) {
            return Collections.emptyList();
        }
        double secondHighestVotes = 0L;
        double totalVotes = getTotalVotes(candidates);
        double highestNumberOfVotes = getHighestNumberOfVotes(candidates);
        List<Candidate> winners = new ArrayList<>();

        for (Map.Entry<Candidate, Long> entry : candidates.entrySet()) {
            double candidateVotes = entry.getValue();
            double voteShare = (candidateVotes / totalVotes) * 100;

            if (voteShare > 50.0f) {
                winners.add(entry.getKey());
                return winners;
            } else if (candidateVotes != highestNumberOfVotes && candidateVotes > secondHighestVotes) {
                secondHighestVotes = candidateVotes;
            } else if (winners.size() < 2) {
                if (candidateVotes == secondHighestVotes || candidateVotes < secondHighestVotes) {
                    secondHighestVotes = candidateVotes;
                }
            } else if (winners.size() == 2) {
                if (candidateVotes == highestNumberOfVotes || candidateVotes == secondHighestVotes) {
                    winners.add(entry.getKey());
                    return winners;
                }
            }
            winners.add(entry.getKey());
        }
        return winners;
    }

    /**
     * Calculate total number of votes
     *
     * @return the total
     */
    private double getTotalVotes(Map<Candidate, Long> candidates) {
        return candidates
                .values()
                .stream()
                .mapToDouble(votes -> votes)
                .sum();
    }

    /**
     * Calculate highest number of collected
     *
     * @return highest number
     */
    private double getHighestNumberOfVotes(Map<Candidate, Long> candidates) {
        return candidates
                .values()
                .stream()
                .max(Comparator.naturalOrder())
                .get();
    }

}