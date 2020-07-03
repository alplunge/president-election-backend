package com.election.voting.president.web;

public class VoteDto {

    private CandidateDto candidate;
    private long numberOfVotes;

    public VoteDto(CandidateDto candidate, long numberOfVotes) {
        this.candidate = candidate;
        this.numberOfVotes = numberOfVotes;
    }

    public CandidateDto getCandidate() {
        return candidate;
    }

    public void setCandidate(CandidateDto candidate) {
        this.candidate = candidate;
    }

    public long getNumberOfVotes() {
        return numberOfVotes;
    }

    public void setNumberOfVotes(long numberOfVotes) {
        this.numberOfVotes = numberOfVotes;
    }
}
