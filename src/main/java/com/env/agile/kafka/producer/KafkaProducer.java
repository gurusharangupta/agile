package com.env.agile.kafka.producer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import com.env.agile.model.Greetings;

@Service
public class KafkaProducer {

	@Value(value = "${kafka.topic.name}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, Greetings> kafkaTemplate;

	public void sendjsonMessage(Greetings message) {

		Map<String, Object> headers = new HashMap<>();

		headers.put(KafkaHeaders.TOPIC, topicName);

		kafkaTemplate.send(new GenericMessage<Greetings>(message, headers));

	}

}
