package com.course.rabbitmq.consumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.rabbitmq.consumer.entity.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AccountingConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountingConsumer.class);
	
	@Autowired
	private ObjectMapper objectMapper;

	@RabbitListener(queues = "q.hr.accounting")
	public void listen(String message) throws JsonMappingException, JsonProcessingException {
		Employee employee = objectMapper.readValue(message, Employee.class);
		LOGGER.info(">> Employee on accounting is  {}", employee);
	}
}
