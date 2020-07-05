package com.javaMicroServices.os.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.javaMicroServices.os.api.common.Payment;
import com.javaMicroServices.os.api.entity.Order;
import com.javaMicroServices.os.api.entity.TransactionRequest;
import com.javaMicroServices.os.api.entity.TransactionResponse;
import com.javaMicroServices.os.api.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	@Autowired
	RestTemplate restTemplate;

	public TransactionResponse save(TransactionRequest request) {
		
		String responseMesg="";
		Order order = request.getOrder();
		Payment paymentRequest = request.getPayment();
		paymentRequest.setOrderId(order.getId());
		paymentRequest.setAmount(order.getPrice());
		
		Payment paymentResponse=restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment", paymentRequest, Payment.class);
		responseMesg=paymentResponse.getPaymentStatus().equals("success")?"Transaction Successfull"+paymentResponse.getPort():"Transaction Failure";

		 repository.save(order);
		
		return new TransactionResponse(order, paymentResponse.getAmount(),paymentResponse.getTransactionId(),responseMesg);
		
	}

}
