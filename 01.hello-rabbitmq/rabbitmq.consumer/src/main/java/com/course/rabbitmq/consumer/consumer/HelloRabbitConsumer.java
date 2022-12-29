package com.course.rabbitmq.consumer.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class HelloRabbitConsumer {

	@RabbitListener(queues = "course.hello")
	public void listen(String message) {
		System.out.println("# Consuming : "+ message);
	}
}
