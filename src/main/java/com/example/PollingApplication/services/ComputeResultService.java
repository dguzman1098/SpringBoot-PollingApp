package com.example.PollingApplication.services;

import com.example.PollingApplication.domain.Vote;
import com.example.PollingApplication.dto.ChoiceCount;
import com.example.PollingApplication.dto.VoteResult;
import com.example.PollingApplication.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ComputeResultService {

        @Autowired
        private VoteRepository voteRepository;

        public ResponseEntity<?> computeResult(Long pollId) {
            VoteResult voteResult = new VoteResult();
            Iterable<Vote> allVotes = voteRepository.findByPoll(pollId);

            // Algorithm to count votes
            int totalVotes = 0;
            Map<Long, ChoiceCount> tempMap = new HashMap<Long, ChoiceCount>();
            for (Vote v : allVotes) {
                totalVotes++;
                // Get the ChoiceCount corresponding to this Choice
                ChoiceCount choiceCount = tempMap.get(v.getChoice().getId());
                if (choiceCount == null) {
                    choiceCount = new ChoiceCount();
                    choiceCount.setChoiceId(v.getChoice().getId());
                    tempMap.put(v.getChoice().getId(), choiceCount);
                }
                choiceCount.setCount(choiceCount.getCount() + 1);
            }
            voteResult.setTotalVotes(totalVotes);
            voteResult.setResults(tempMap.values());

            return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);
 }
}

