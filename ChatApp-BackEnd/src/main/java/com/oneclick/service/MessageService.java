package com.oneclick.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oneclick.entity.Message;
import com.oneclick.repository.MessageRepo;

@Service
public class MessageService {

	private final MessageRepo messageRepo;

	 
	public MessageService(MessageRepo messageRepository) {
		this.messageRepo = messageRepository;
	}

	public List<Message> getAllMessages() {
		return messageRepo.findAll();
	}

	public Message saveMessage(Message message) {
		return messageRepo.save(message);
	}

}
