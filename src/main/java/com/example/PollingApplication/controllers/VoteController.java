package com.example.PollingApplication.controllers;

import com.example.PollingApplication.domain.Vote;
import com.example.PollingApplication.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class VoteController  {

    @Autowired
    private VoteService voteService;

    @PostMapping ("/polls/{pollId}/votes")
    public ResponseEntity<?> createVote(@PathVariable Long pollId, @RequestBody Vote vote) {
        return voteService.createVote(pollId, vote);
    }

    @GetMapping("/polls/{pollId}/votes")
    public Iterable<Vote> getAllVotes(@PathVariable Long pollId) {
        return voteService.getAllVotes(pollId);
    }
}
