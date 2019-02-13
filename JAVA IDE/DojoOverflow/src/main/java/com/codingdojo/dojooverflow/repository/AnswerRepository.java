package com.codingdojo.dojooverflow.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

}
