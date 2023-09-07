package com.example.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Declarable;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {

	// 1. DO NOT USE THIS WAY
	
//	@Bean
//	public FanoutExchange fanoutExchange() {
//		return new FanoutExchange("x.another-dummy", true, false);
//	}
//	
//	@Bean
//	public Queue anotherDummyQueue() {
//		return new Queue("q.another-dummy");
//	}
//	
//	@Bean
//	public Binding anotherDummyBinding() {
//		return BindingBuilder.bind(anotherDummyQueue()).to(fanoutExchange());
//	}
	
	
	// 2. CREATE THIS WAY, safe way - it doesn't drop and recreate it
	@Bean
	public Declarables declarables() {
		return new Declarables(
				new FanoutExchange("x.another-dummy", true, false),
				new Queue("q.another-dummy"),
				new Binding("q.another-dummy", DestinationType.QUEUE, "x.another-dummy", "", null)
				);
	}
}
