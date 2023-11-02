package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.enums.PaymentMethod;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAllOrders();

    OrderDTO updateOrder(OrderDTO order);
    OrderDTO createOrder(OrderDTO order);
    List<OrderDTO> getOrderListByPaymentMethod(PaymentMethod paymentMethod);

    List<OrderDTO> findAllOrdersByEmail(String email);
}
