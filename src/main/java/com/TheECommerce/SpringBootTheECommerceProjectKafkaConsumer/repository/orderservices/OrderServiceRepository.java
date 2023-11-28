package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.repository.orderservices;

import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.entity.orderservices.OrderServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderServiceRepository extends JpaRepository<OrderServiceEntity, Long> {

}
