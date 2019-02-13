package com.codingdojo.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.repository.AnswerRepository;



@Service
public class AnswerService {

	private AnswerRepository answerRepository;
	
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	
	public void addAnswer(Answer answer) {
		answerRepository.save(answer);
	}
	
	public List<Answer> allAnswers() {
		return (List<Answer>) answerRepository.findAll();
	}
	
	public Answer findAnswerById(Long id) {
		return answerRepository.findOne(id);
	}
	
	
}
