package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.entity.orderservices;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_orderservice_payment_details")
public class PaymentDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "card_type", nullable = false)
    private String cardType;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "expiration_month", nullable = false)
    private String expirationMonth;

    @Column(name = "expiration_year", nullable = false)
    private String expirationYear;

    @Column(name = "cvv", nullable = false)
    private String cvv;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "order_service_id", nullable = false)
    private OrderServiceEntity orderService;
}
