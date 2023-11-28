package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.repository.orderservices;

import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.entity.orderservices.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethodEntity, Long> {

}
