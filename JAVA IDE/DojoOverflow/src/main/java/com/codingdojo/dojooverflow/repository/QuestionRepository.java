package com.codingdojo.dojooverflow.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.dojooverflow.models.Question;



@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {


}
