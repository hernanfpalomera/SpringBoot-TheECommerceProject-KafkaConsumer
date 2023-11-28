package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.model.orderservices;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethod {

        @JsonProperty("card_type")
        private String cardType;

        @JsonProperty("card_number")
        private String cardNumber;

        @JsonProperty("expiry_date")
        private Date expiryDate;

        @JsonProperty("billing_address")
        private String billingAddress;
}
