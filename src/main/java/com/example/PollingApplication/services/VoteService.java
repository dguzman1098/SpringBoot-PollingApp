package com.example.PollingApplication.services;

import com.example.PollingApplication.domain.Vote;
import com.example.PollingApplication.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    public ResponseEntity<?> createVote(Long pollId, Vote vote) {
        vote = voteRepository.save(vote);

        // Set the headers for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vote.getId()).toUri());

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    public Iterable<Vote> getAllVotes(Long pollId) {
        return voteRepository. findByPoll(pollId);
    }

}
