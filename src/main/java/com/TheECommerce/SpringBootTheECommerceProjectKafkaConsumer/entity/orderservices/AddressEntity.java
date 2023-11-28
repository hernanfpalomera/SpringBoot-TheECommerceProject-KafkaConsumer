package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.entity.orderservices;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_orderservice_customer_addresses")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "country", nullable = false)
    private String country;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;
}
