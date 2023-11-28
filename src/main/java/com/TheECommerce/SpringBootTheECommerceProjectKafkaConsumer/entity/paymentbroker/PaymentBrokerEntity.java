package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.entity.paymentbroker;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_payment_brokers")
public class PaymentBrokerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "purchase_id", nullable = false)
    private String purchaseId;

    @Column(name = "payment_id", nullable = false)
    private String paymentId;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "card_type", nullable = false)
    private String cardType;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "expiry_date", nullable = false)
    private String expiryDate;

}
