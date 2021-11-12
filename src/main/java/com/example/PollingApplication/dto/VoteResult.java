package com.example.PollingApplication.dto;

import java.util.Collection;

public class VoteResult {

    private int totalVotes;
    private Collection<ChoiceCount> results;

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public Collection<ChoiceCount> getResults() {
        return results;
    }

    public void setResults(Collection<ChoiceCount> results) {
        this.results = results;
    }
}
