package com.course.rabbitmq.producer;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.rabbitmq.producer.entity.Picture;
import com.course.rabbitmq.producer.producer.MyPictureProducer;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private MyPictureProducer producer;

	// Valid Sources
	private final List<String> SOURCES = List.of("mobile", "web");

	// Valid Types
	private final List<String> TYPES = List.of("jpg", "png", "svg");


	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 1; i++) {
			Picture picture = Picture.builder()
					.name("Picture "+i)
					.size(ThreadLocalRandom.current().nextLong(9000, 10000))
					.source(SOURCES.get(i % SOURCES.size()))
					.type(TYPES.get(i % TYPES.size()))
					.build();

			producer.sendMessage(picture);
		}
	}
}
