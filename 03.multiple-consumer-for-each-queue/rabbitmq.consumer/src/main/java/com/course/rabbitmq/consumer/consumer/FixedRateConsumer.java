package com.course.rabbitmq.consumer.consumer;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class FixedRateConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(FixedRateConsumer.class);

	// Atleast 3 and max 7 concurrency
	@RabbitListener(queues = "course.fixedrate", concurrency = "3-7")
	public void listen(String message) throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(1000, 2000));
		LOGGER.info("# {} : Consuming {} ", Thread.currentThread().getName(), message);
	}
}
