package com.example.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.DummyMessage;

@Service
public class AnotherDummyProducer {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	public void sendDummy(DummyMessage dummyMessage) {
		//rabbitTemplate.convertAndSend("x.another-dummy", "", dummyMessage);
	}
}
