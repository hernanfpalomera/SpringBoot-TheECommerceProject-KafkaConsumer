package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.entity.orderservices;



import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_order_lines")
public class OrderLineEntity {

       @Id
       @GeneratedValue(strategy = GenerationType.UUID)
       private String id;

       @Column(name = "product_id", nullable = false)
       private String productId;

       @Column(name = "name", nullable = false)
       private String name;

       @Column(name = "quantity", nullable = false)
       private Integer quantity;

       @Column(name = "price", nullable = false)
       private BigDecimal price;

       @Column(name = "subtotal", nullable = false)
       private BigDecimal subtotal;

       @ManyToOne(cascade = CascadeType.ALL, optional = false)
       @JoinColumn(name = "order_service_id", nullable = false)
       private OrderServiceEntity orderService;


}
