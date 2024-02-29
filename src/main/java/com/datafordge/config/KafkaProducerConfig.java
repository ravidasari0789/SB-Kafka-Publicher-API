package com.datafordge.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.datafordge.constant.AppConstant;
import com.datafordge.model.Order;
import org.springframework.kafka.support.serializer.JsonSerializer;


@Configuration
public class KafkaProducerConfig {

	                    
	                    @Bean
	                    public ProducerFactory<String, Order> producefactory(){
	                    	
	                    	       Map<String, Object> configprop=new HashMap<>();
	                    	       
	                    	       configprop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, AppConstant.HOST);
	                    	       configprop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	                    	       configprop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	                    	       
	                    	     return new DefaultKafkaProducerFactory<>(configprop);
	                    }
	                    @Bean
	                    public KafkaTemplate<String, Order> kafkaTemplate() {
	                    	
	                    	return new KafkaTemplate<>(producefactory());
	                    }
	                    
}
