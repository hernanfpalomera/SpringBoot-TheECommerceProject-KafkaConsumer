package com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.service;

import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.entity.orderservices.*;
import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.model.orderservices.OrderService;
import com.TheECommerce.SpringBootTheECommerceProjectKafkaConsumer.repository.orderservices.OrderServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServicesServiceImpl implements OrderServicesService {

    private final OrderServiceRepository orderServiceRepository;

    @Override
    public void processOrderService(OrderService orderService) {
        OrderServiceEntity orderServiceEntity = getOrderServiceEntity(orderService);
        orderServiceRepository.save(orderServiceEntity);
    }

    private static OrderServiceEntity getOrderServiceEntity(OrderService orderService) {

        // Lombok implementation
        OrderServiceEntity orderServiceEntity = OrderServiceEntity
                .builder()
                .purchaseId(orderService.getPurchaseId())
                .timestamp(orderService.getTimestamp())
                .storeId(orderService.getStoreId())
                .creationDate(orderService.getCreationDate())
                .totalPrice(orderService.getTotalPrice())
                .paymentMethod(orderService.getPaymentMethod())
                .build();

        customerExtractor(orderService, orderServiceEntity);
        //customerAddressExtractor(orderService, orderServiceEntity);
        productExtractor(orderService, orderServiceEntity);
        paymentDetailsExtractor(orderService, orderServiceEntity);

        return orderServiceEntity;
    }

    private static void customerExtractor(OrderService orderService, OrderServiceEntity orderServiceEntity) {
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setCustomerId(orderService.getCustomer().getCustomerId());
        customerEntity.setFirstName(orderService.getCustomer().getFirstName());
        customerEntity.setLastName(orderService.getCustomer().getLastName());
        customerEntity.setEmail(orderService.getCustomer().getEmail());

        AddressEntity addressEntity = getCustomerAddress(orderService, customerEntity);

        customerEntity.setAddress(addressEntity);
        customerEntity.setOrderService(orderServiceEntity);

        orderServiceEntity.setCustomer(customerEntity);

    }

    private static AddressEntity getCustomerAddress(OrderService orderService, CustomerEntity customerEntity) {
        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setStreet(orderService.getCustomer().getAddress().getStreet());
        addressEntity.setCity(orderService.getCustomer().getAddress().getCity());
        addressEntity.setState(orderService.getCustomer().getAddress().getState());
        addressEntity.setPostalCode(orderService.getCustomer().getAddress().getPostalCode());
        addressEntity.setCountry(orderService.getCustomer().getAddress().getCountry());
        addressEntity.setCustomer(customerEntity);
        return addressEntity;
    }

    private static void productExtractor(OrderService orderService, OrderServiceEntity orderServiceEntity) {

        orderServiceEntity.setProducts(orderService.getProducts().stream().map(product -> {
            ProductEntity productEntity = new ProductEntity();

            productEntity.setProductId(product.getProductId());
            productEntity.setName(product.getName());
            productEntity.setQuantity(product.getQuantity());
            productEntity.setPrice(product.getPrice());
            productEntity.setSubtotal(product.getSubtotal());
            productEntity.setOrderService(orderServiceEntity);

            return productEntity;
        }).toList());
    }

    private static void paymentDetailsExtractor(OrderService orderService, OrderServiceEntity orderServiceEntity) {
        PaymentDetailsEntity paymentDetailsEntity = new PaymentDetailsEntity();

        paymentDetailsEntity.setCardType(orderService.getPaymentDetails().getCardType());
        paymentDetailsEntity.setCardNumber(orderService.getPaymentDetails().getCardNumber());
        paymentDetailsEntity.setExpirationMonth(orderService.getPaymentDetails().getExpirationMonth());
        paymentDetailsEntity.setExpirationYear(orderService.getPaymentDetails().getExpirationYear());
        paymentDetailsEntity.setCvv(orderService.getPaymentDetails().getCvv());
        paymentDetailsEntity.setOrderService(orderServiceEntity);

        orderServiceEntity.setPaymentDetails(paymentDetailsEntity);
    }


}
