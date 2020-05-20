package com.env.agile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.env.agile.kafka.producer.KafkaProducer;
import com.env.agile.model.Greetings;

@RestController
@RequestMapping("/kafka")
public class KafkaController {
	
	@Autowired
	private KafkaProducer kafkaProducer;
	
	@PostMapping("/jsondemo")
	public String jsonDemo() {
		Greetings greeting = new Greetings("Kafka working fine!","Gurusharan Gupta");
		kafkaProducer.sendjsonMessage(greeting);
		return "hello there";

	}
	
	

}
