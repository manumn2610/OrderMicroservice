package com.javaMicroServices.os.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.javaMicroServices.os.api.common.Payment;
import com.javaMicroServices.os.api.entity.Order;
import com.javaMicroServices.os.api.entity.TransactionRequest;
import com.javaMicroServices.os.api.entity.TransactionResponse;
import com.javaMicroServices.os.api.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService service;
	private static final Logger logger=LogManager.getLogger(OrderController.class);


	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
		System.out.println("Inside");
		
		return service.save(request);
		
		//call rest ap to save the payment
		
		
	}
	
	@GetMapping("/test")
	public String tested() {
		
		 
		logger.info("Insider the loggger that i have writen");
		System.out.println("Insidezzzzz");
		
		//return service.save(request);
		
		//call rest ap to save the payment
		
		return "Helloworld";
	}

}
