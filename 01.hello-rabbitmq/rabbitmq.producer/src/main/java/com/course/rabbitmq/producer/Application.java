package com.course.rabbitmq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.rabbitmq.producer.producer.HelloRabbitMQProducer;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	private HelloRabbitMQProducer producer;

	@Override
	public void run(String... args) throws Exception {
		producer.sendHello("Neha Dekate "+ Math.random());
	}

}
