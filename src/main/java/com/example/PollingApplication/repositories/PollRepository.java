package com.example.PollingApplication.repositories;

import com.example.PollingApplication.domain.Poll;

import org.springframework.data.repository.CrudRepository;

public interface PollRepository extends CrudRepository<Poll, Long> {

}
