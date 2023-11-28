package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.service;

import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.model.orderservices.OrderService;
import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.model.paymentbroker.PaymentBroker;

public interface PaymentBrokerService {

    public void processPaymentBroker(PaymentBroker paymentBroker);

}
