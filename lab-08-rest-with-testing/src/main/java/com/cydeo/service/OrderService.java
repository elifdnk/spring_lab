package com.cydeo.service;

import com.cydeo.dto.OrderDTO;
import com.cydeo.dto.UpdateOrderDTO;
import com.cydeo.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    List<OrderDTO> retrieveOrderList();

    OrderDTO updateOrder(OrderDTO orderDTO);
    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO updateOrderById(Long id, UpdateOrderDTO updateOrderDTO);

    List<OrderDTO> retrieveOrderByPaymentMethod(PaymentMethod paymentMethod);

    List<OrderDTO>  retrieveOrderByEmail(String email);
    BigDecimal placeOrder(PaymentMethod paymentMethod, Long cartId, Long customerId);
}
