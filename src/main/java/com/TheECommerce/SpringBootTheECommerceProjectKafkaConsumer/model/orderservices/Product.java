package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.model.orderservices;


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
public class Product {

       @JsonProperty("product_id")
       private String productId;

       @JsonProperty("name")
       private String name;

       @JsonProperty("quantity")
       private Integer quantity;

       @JsonProperty("price")
       private BigDecimal price;

       @JsonProperty("subtotal")
       private BigDecimal subtotal;
}
