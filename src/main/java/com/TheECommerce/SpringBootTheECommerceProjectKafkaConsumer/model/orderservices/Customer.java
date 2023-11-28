package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.model.orderservices;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

        @JsonProperty("customer_id")
        private String customerId;

        @JsonProperty("first_name")
        private String firstName;

        @JsonProperty("last_name")
        private String lastName;

        @JsonProperty("email")
        private String email;

        @JsonProperty("address")
        private Address address;

}
