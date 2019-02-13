package com.codingdojo.event.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.event.models.Message;
import com.codingdojo.event.repository.MessageRepository;

@Service
public class MessageService {
	
	private final MessageRepository messageRepository;
	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}
	
	public List<Message> allMessages(){
		return messageRepository.findAll();
	}
	public Message createMessage(Message p) {
		return messageRepository.save(p);
	}

}
