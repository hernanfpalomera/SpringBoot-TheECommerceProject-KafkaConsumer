package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.entity.orderservices;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_orderservice_customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "customer", fetch=FetchType.EAGER)
    private AddressEntity address;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "order_service_id", nullable = false)
    private OrderServiceEntity orderService;
}
