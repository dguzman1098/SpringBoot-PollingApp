package com.example.PollingApplication.repositories;

import com.example.PollingApplication.domain.Choice;
import org.springframework.data.repository.CrudRepository;

public interface ChoiceRepository extends CrudRepository<Choice, Long> {

}
