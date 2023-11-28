package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.repository.orderservices;

import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.entity.orderservices.OrderLineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLineEntity, Long> {

}
