package com.course.rabbitmq.producer.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.rabbitmq.producer.entity.Picture;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PictureProducer {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	public void sendMessage(Picture picture) throws JsonProcessingException {
		String json = objectMapper.writeValueAsString(picture);

		rabbitTemplate.convertAndSend("x.picture", picture.getType(), json);
	}
}
