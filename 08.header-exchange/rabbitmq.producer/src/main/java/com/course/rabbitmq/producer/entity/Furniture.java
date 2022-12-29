package com.course.rabbitmq.producer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Furniture {
	private String color;
	private String material;
	private String name;
	private int price;
}
