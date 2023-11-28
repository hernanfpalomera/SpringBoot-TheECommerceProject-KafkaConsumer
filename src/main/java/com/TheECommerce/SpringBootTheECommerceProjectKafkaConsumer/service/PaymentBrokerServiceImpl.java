package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.service;

import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.entity.orderservices.OrderServiceEntity;
import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.entity.orderservices.PaymentMethodEntity;
import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.entity.paymentbroker.PaymentBrokerEntity;
import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.model.orderservices.OrderService;
import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.model.paymentbroker.PaymentBroker;
import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.repository.paymentbroker.PaymentBrokerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PaymentBrokerServiceImpl implements PaymentBrokerService {

    private final PaymentBrokerRepository paymentBrokerRepository;

    @Override
    public void processPaymentBroker(PaymentBroker paymentBroker) {
        PaymentBrokerEntity paymentBrokerEntity = getPaymentBrokerEntity(paymentBroker);
        paymentBrokerRepository.save(paymentBrokerEntity);
    }

    private static PaymentBrokerEntity getPaymentBrokerEntity(PaymentBroker paymentBroker) {
        //  Traditional Java implementation
        //  PaymentBrokerEntity paymentBrokerEntity = new PaymentBrokerEntity();
        //
        //  paymentBrokerEntity.setPurchaseId(paymentBroker.getPurchaseId());
        //  paymentBrokerEntity.setPaymentId(paymentBroker.getPaymentId());
        //  paymentBrokerEntity.setAmount(paymentBroker.getAmount());
        //  paymentBrokerEntity.setCardType(paymentBroker.getCardType());
        //  paymentBrokerEntity.setCardNumber(paymentBroker.getCardNumber());
        //  paymentBrokerEntity.setExpiryDate(paymentBroker.getExpiryDate());

        // Lombok implementation
        return PaymentBrokerEntity
                .builder()
                .purchaseId(paymentBroker.getPurchaseId())
                .paymentId(paymentBroker.getPaymentId())
                .amount(paymentBroker.getAmount())
                .cardType(paymentBroker.getCardType())
                .cardNumber(paymentBroker.getCardNumber())
                .expiryDate(paymentBroker.getExpiryDate())
                .build();
    }

}
