package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.model.paymentbroker;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentBroker {

    @JsonProperty("purchase_id")
    private String purchaseId;

    @JsonProperty("payment_id")
    private String paymentId;

    @JsonProperty("amount")
    private BigDecimal amount;

    @JsonProperty("card_type")
    private String cardType;

    @JsonProperty("card_number")
    private String cardNumber;

    @JsonProperty("expiry_date")
    private String expiryDate;
}