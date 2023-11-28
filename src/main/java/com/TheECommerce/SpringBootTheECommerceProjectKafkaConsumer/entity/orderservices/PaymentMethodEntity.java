package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.entity.orderservices;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_payment_methods")
public class PaymentMethodEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private String id;

        @Column(name = "card_type", nullable = false)
        private String cardType;

        @Column(name = "card_number", nullable = false)
        private String cardNumber;

        @Column(name = "expiry_date", nullable = false)
        private Date expiryDate;

        @Column(name = "billing_address", nullable = false)
        private String billingAddress;

        @OneToOne(cascade = CascadeType.ALL, optional = false)
        @JoinColumn(name = "order_service_id", nullable = false)
        private OrderServiceEntity orderService;

}
