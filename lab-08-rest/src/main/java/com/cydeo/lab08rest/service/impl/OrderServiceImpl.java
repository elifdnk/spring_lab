package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.entity.Order;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.OrderRepository;
import com.cydeo.lab08rest.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MapperUtil mapperUtil;

    public OrderServiceImpl(OrderRepository orderRepository, MapperUtil mapperUtil) {
        this.orderRepository = orderRepository;
        this.mapperUtil = mapperUtil;
    }


    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> mapperUtil.convert(order,new OrderDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO updateOrder(OrderDTO order) {
       Order findOrder = orderRepository.findById(order.getId()).orElseThrow();
       Order convertOrder = mapperUtil.convert(order,new Order());
       convertOrder.setId(findOrder.getId());
       orderRepository.save(convertOrder);
       return order;
    }

    @Override
    public OrderDTO createOrder(OrderDTO order) {

     orderRepository.save(mapperUtil.convert(order,new Order()));
       return order;
    }

    @GetMapping
    public List<OrderDTO> getOrderListByPaymentMethod(PaymentMethod paymentMethod){

      return   orderRepository.findAllByPayment_PaymentMethod(paymentMethod)
                .stream()
                .map(order -> mapperUtil.convert(order,new OrderDTO()))
                .collect(Collectors.toList());

    }

    @Override
    public List<OrderDTO> findAllOrdersByEmail(String email) {
        return orderRepository.findAllByCustomer_Email(email)
                .stream()
                .map(order -> mapperUtil.convert(order,new OrderDTO()))
                .collect(Collectors.toList());
    }


}
