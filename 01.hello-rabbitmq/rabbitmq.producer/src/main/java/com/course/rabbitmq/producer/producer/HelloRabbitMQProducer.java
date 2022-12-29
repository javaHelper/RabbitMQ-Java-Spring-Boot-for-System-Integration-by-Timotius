package com.course.rabbitmq.producer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloRabbitMQProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	public void sendHello(String name) {
		rabbitTemplate.convertAndSend("course.hello", "Hello : "+name);
	}
}
