package com.hcl.productcatalogue.service;

import javax.jms.Message;

public interface ProductConsumer {
	
	public void receiveMessage(Message msg);

}
