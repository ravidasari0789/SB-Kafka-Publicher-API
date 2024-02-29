package com.datafordge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.datafordge.model.Order;
import com.datafordge.service.KafkaService;

@RestController
public class OrderRestController {

	       @Autowired
	       private KafkaService kafkaservice;
	       
	       @PostMapping("/order")
	       public String createOrder(@RequestBody Order order) {
	    	  String msg= kafkaservice.addMessage(order);
	    	   
	    	   return msg;
	       }
}
