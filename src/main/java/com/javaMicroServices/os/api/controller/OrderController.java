package com.javaMicroServices.os.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService service;
	


	@PostMapping("/bookOrder")
	public TransactionResponse bookOrder(@RequestBody TransactionRequest request) {
		
		
		return service.save(request);
		
		//call rest ap to save the payment
		
		
	}

}
