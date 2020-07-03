package com.election.voting.president.web;

import java.util.List;

public class RegionDto {

    private String region;
    private List<VoteDto> votes;

    public RegionDto(String region, List<VoteDto> votes) {
        this.region = region;
        this.votes = votes;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<VoteDto> getVotes() {
        return votes;
    }

    public void setVotes(List<VoteDto> votes) {
        this.votes = votes;
    }
}
