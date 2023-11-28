package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.entity.orderservices;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_order_services")
public class OrderServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "purchase_id", nullable = false)
    private String purchaseId;

    @Column(name = "timestamp", nullable = false)
    private String timestamp;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orderService", fetch=FetchType.EAGER)
    private CustomerEntity customer;

    @Column(name = "store_id", nullable = false)
    private String storeId;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private Date creationDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderService", fetch=FetchType.EAGER)
    private List<ProductEntity> products;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "orderService", fetch=FetchType.EAGER)
    private PaymentDetailsEntity paymentDetails;


}
