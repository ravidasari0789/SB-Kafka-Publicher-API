package com.datafordge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.datafordge.constant.AppConstant;
import com.datafordge.model.Order;

@Service
public class KafkaService {

	           @Autowired
	           private KafkaTemplate<String, Order> kafkaTemplate;
	           
	           public String addMessage(Order order){
	        	   
	        	   kafkaTemplate.send(AppConstant.TOPIC, order);
	        	   
	        	   return "Message publisherd to TOPIC";
	           }
}

