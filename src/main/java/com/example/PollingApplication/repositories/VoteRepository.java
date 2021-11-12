package com.example.PollingApplication.repositories;

import com.example.PollingApplication.domain.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VoteRepository extends CrudRepository<Vote, Long> {

    @Query(value="select v.* from Choice c, Vote v where c.POLL_ID = ?1 and v.CHOICE_ID = c.CHOICE_ID", nativeQuery = true)
    public Iterable<Vote> findByPoll(Long pollId);
}
