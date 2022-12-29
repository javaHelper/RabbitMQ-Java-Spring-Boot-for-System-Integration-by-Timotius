package com.course.rabbitmq.consumer.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

	@JsonProperty("employee_id")
	private String employeeId;
	private String name;
	
	@JsonProperty("birth_date")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;
}
