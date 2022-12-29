package com.course.rabbitmq.producer;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.course.rabbitmq.producer.entity.Employee;
import com.course.rabbitmq.producer.producer.EmployeeJsonproducer;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	private EmployeeJsonproducer jsonproducer;

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 5; i++) {
			Employee employee = new Employee("emp" + i, "Employee " + i, LocalDate.now());
			jsonproducer.sendMessage(employee);
		}
	}

}
