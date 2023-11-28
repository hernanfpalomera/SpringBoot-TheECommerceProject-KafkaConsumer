package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.service;

import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.model.orderservices.OrderService;

public interface OrderServicesService {
    public void processOrderService(OrderService orderService);

}
