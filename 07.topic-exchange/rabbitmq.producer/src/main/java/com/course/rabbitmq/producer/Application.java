package com.course.rabbitmq.producer;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.rabbitmq.producer.entity.Picture;
import com.course.rabbitmq.producer.producer.PictureProducerTwo;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	private PictureProducerTwo pictureProducer;

	// Valid Sources
	private final List<String> SOURCES = List.of("mobile", "web");
	
	// Valid Types
	private final List<String> TYPES = List.of("jpg", "png", "svg");
	
	
	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			Picture picture = Picture.builder()
				.name("Pcture "+i)
				.size(ThreadLocalRandom.current().nextLong(1, 10000))
				.source(SOURCES.get(i % SOURCES.size()))
				.type(TYPES.get(i % TYPES.size()))
				.build();
			
			System.out.println("@ "+ picture);
			
			pictureProducer.sendMessage(picture);
		}
	}

}
