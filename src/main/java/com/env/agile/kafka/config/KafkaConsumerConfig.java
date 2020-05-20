package com.env.agile.kafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.env.agile.model.Greetings;


@EnableKafka
@Configuration
public class KafkaConsumerConfig {
 
	@Value(value = "${kafka.server.address}")
	 private String bootstrapAddress;
	
	@Value(value = "${kafka.consumer.group.id}")
	private String groupId;
	 
    @Bean
    public ConsumerFactory<String, Greetings> consumerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(
          ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, 
          bootstrapAddress);
        config.put(
          ConsumerConfig.GROUP_ID_CONFIG, 
          groupId);
        config.put(
          ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, 
          StringDeserializer.class);
        config.put(
          ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, 
          JsonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(config,null, new JsonDeserializer<Greetings>(Greetings.class));
    }
 
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Greetings>> 
      kafkaListenerContainerFactory() {
    
        ConcurrentKafkaListenerContainerFactory<String, Greetings> factory
          = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
