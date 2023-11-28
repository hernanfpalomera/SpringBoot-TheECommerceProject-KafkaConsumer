package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.config;

import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.model.orderservices.OrderService;
import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.model.paymentbroker.PaymentBroker;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    public Map<String, Object> consumerConfig(){
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return props;
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(consumerConfig());
    }

    public KafkaListenerContainerFactory<
            ConcurrentMessageListenerContainer<String, String>> factory(
                    ConsumerFactory<String,String> consumerFactory
    ){
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

    //////////////////////////////////////////// CUSTOM SERVER CONFIGURATION
    public Map<String, Object> customServiceConsumerConfig(){
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,  StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return props;
    }

    //////////////////////////////////////////// ORDER SERVICES CONFIGURATION
    @Bean
    public ConsumerFactory<String, OrderService> orderServiceConsumerFactory() {
        // Returning message in JSON format
        return new DefaultKafkaConsumerFactory<>(
                customServiceConsumerConfig(),
                new StringDeserializer(),
                new JsonDeserializer<>(OrderService.class));
    }

    // Creating a Listener
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, OrderService> orderServicesListener() {
        ConcurrentKafkaListenerContainerFactory<String, OrderService> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(orderServiceConsumerFactory());
        return factory;
    }


    @Bean
    public ConsumerFactory<String, PaymentBroker> paymentBrokerConsumerFactory() {
        // Returning message in JSON format
        return new DefaultKafkaConsumerFactory<>(
                customServiceConsumerConfig(),
                new StringDeserializer(),
                new JsonDeserializer<>(PaymentBroker.class));
    }

    // Creating a Listener
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PaymentBroker> paymentBrokerListener() {
        ConcurrentKafkaListenerContainerFactory<String, PaymentBroker> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(paymentBrokerConsumerFactory());
        return factory;
    }
}
