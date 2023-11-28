package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.model;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class Sale {

    private String region;
    private String country;
    private String itemType;
    private String salesChannel;
    private String orderPriority;
    private String orderDate;
    private Integer orderId;
    private String shipDate;
    private String unitsSold;
    private String unitPrice;
    private String unitCost;
    private String totalRevenue;
    private String totalCost;
    private String totalProfit;
}
