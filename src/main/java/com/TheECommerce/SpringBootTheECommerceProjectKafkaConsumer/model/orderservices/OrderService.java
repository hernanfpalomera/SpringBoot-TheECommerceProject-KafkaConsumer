package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.model.orderservices;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderService {

    @JsonProperty("purchase_id")
    private String purchaseId;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("customer")
    private Customer customer;

    @JsonProperty("store_id")
    private String storeId;

    @JsonProperty("creation_date")
    private Date creationDate;

    @JsonProperty("products")
    private List<Product> products;

    @JsonProperty("total_price")
    private BigDecimal totalPrice;

    @JsonProperty("payment_method")
    private String paymentMethod;

    @JsonProperty("payment_details")
    private PaymentDetails paymentDetails;

//    @JsonProperty("payment_method")
//    private PaymentMethod paymentMethod;
}
