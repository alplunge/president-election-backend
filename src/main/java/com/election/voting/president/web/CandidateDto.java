package com.election.voting.president.web;

import com.election.voting.president.persistence.entities.Candidate;

public class CandidateDto {
    private String fullName;
    private int number;
    private String agenda;

    public CandidateDto(Candidate candidate) {
        this(candidate.getFirstName() + " " + candidate.getLastName(), candidate.getNumber(), candidate.getAgenda());
    }

    private CandidateDto(String fullName, int number, String agenda) {
        this.fullName = fullName;
        this.number = number;
        this.agenda = agenda;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }
}
