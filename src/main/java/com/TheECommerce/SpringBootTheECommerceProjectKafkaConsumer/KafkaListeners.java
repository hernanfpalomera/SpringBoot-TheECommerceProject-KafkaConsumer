package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer;


import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.model.Sale;
import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.model.orderservices.OrderService;
import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.model.paymentbroker.PaymentBroker;
import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.service.OrderServicesService;
import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.service.PaymentBrokerService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class KafkaListeners {

    private final OrderServicesService orderServicesService;

    private final PaymentBrokerService paymentBrokerService;


    @KafkaListener(topics = "the-ecommerce-project-csv-topic",
            groupId = "groupId")
    void csvListener(String data) {

        Gson gson = new Gson();
        Sale sale = gson.fromJson(data, Sale.class);
        System.out.println("Listener received: " + sale.getCountry() + sale.getOrderId());
    }

    @KafkaListener(topics = "the-ecommerce-project-orderservices-topic",
            groupId = "groupId", containerFactory = "orderServicesListener")
    @Transactional
    void orderServicesListener(OrderService orderService) {

        System.out.println(orderService.toString());
        System.out.println("Order Service purchaseId: " + orderService.getPurchaseId());

        orderService.getProducts().forEach(product -> {
            System.out.println("------Order produc productId:" + product.getProductId());
        });

        orderServicesService.processOrderService(orderService);
    }


    @KafkaListener(topics = "the-ecommerce-project-paymentbroker-topic",
            groupId = "groupId", containerFactory = "paymentBrokerListener")
    @Transactional
    void paymentBrokerListener(PaymentBroker paymentBroker) {

        System.out.println(paymentBroker.toString());
        Gson gson = new Gson();
        System.out.println("PaymentBroker paymentId: " + paymentBroker.getPaymentId());

        paymentBrokerService.processPaymentBroker(paymentBroker);
    }
}
