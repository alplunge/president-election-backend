package com.election.voting.president.web;

public class VoteRequest {
    private int candidateNumber;
    private int voterSsn;

    protected VoteRequest() {
    }

    public int getCandidateNumber() {
        return candidateNumber;
    }

    public void setCandidateNumber(int candidateNumber) {
        this.candidateNumber = candidateNumber;
    }

    public int getVoterSsn() {
        return voterSsn;
    }

    public void setVoterSsn(int voterSsn) {
        this.voterSsn = voterSsn;
    }
}
