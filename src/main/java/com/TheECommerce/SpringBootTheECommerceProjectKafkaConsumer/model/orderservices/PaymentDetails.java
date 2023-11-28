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
public class PaymentDetails {

    @JsonProperty("card_type")
    private String cardType;

    @JsonProperty("card_number")
    private String cardNumber;

    @JsonProperty("expiration_month")
    private String expirationMonth;

    @JsonProperty("expiration_year")
    private String expirationYear;

    @JsonProperty("cvv")
    private String cvv;

}
