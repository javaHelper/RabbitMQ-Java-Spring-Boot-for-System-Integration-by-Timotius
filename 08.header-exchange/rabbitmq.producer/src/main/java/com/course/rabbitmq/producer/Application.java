package com.course.rabbitmq.producer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.rabbitmq.producer.entity.Furniture;
import com.course.rabbitmq.producer.producer.FurnitureProducer;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	private FurnitureProducer furnitureProducer;

	// Valid Sources
	private final List<String> COLORS = List.of("white", "red", "green");
	
	// Valid Types
	private final List<String> MATERIALS = List.of("wood", "plastic", "steel");
	
	
	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			Furniture furniture = Furniture.builder()
				.name("Furniture "+i)
				.color(COLORS.get(i % COLORS.size()))
				.material(MATERIALS.get(i % MATERIALS.size()))
				.price(i)
				.build();
			
			furnitureProducer.sendMessage(furniture);
		}
	}
}
