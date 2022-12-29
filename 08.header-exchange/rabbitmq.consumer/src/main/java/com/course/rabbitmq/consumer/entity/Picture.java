package com.course.rabbitmq.consumer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Picture {
	private String name;
	private String type;
	private String source;
	private long size; 
}
