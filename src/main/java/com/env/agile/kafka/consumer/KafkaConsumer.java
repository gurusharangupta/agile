package com.env.agile.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.env.agile.model.Greetings;



@Service
public class KafkaConsumer {

	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.consumer.group.id}", containerFactory = "kafkaListenerContainerFactory")
	public void listen(@Payload Greetings message) {
		System.out.println("Received Json Message in group foo: " + message.getName());
	}
}
