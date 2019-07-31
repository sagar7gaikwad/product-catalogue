package com.hcl.productcatalogue.serviceimpl;

import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.hcl.productcatalogue.service.ProductConsumer;

@Service
public class ProductConsumerImpl implements ProductConsumer {

	@JmsListener(destination = "inbound.queue")
	@Override
	public void receiveMessage(Message msg) {
		System.out.println("Received " + msg);
	}

}
