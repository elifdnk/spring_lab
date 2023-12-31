package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllOrders(){
        return ResponseEntity
                .ok(new ResponseWrapper("Orders are successfully retrieved",orderService.getAllOrders(), HttpStatus.ACCEPTED ));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> update(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(ResponseWrapper.builder()
                .code(200)
                .success(true)
                .message("Order is updated successfully.")
                .data(orderService.update(orderDTO))
                .build());
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createOrder(@RequestBody OrderDTO order){
        return ResponseEntity
                .ok(new ResponseWrapper("Order successfully created!",orderService.createOrder(order),HttpStatus.ACCEPTED));

    }


    @GetMapping("/paymentMethod/{paymentMethod}")
    public ResponseEntity<ResponseWrapper>  getOrderListByPaymentMethod(@PathVariable PaymentMethod paymentMethod){

        return ResponseEntity
                .ok(new ResponseWrapper("Orders are found",orderService.getOrderListByPaymentMethod(paymentMethod),HttpStatus.ACCEPTED));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseWrapper> getOrderListByEmail(@PathVariable String email){
        return ResponseEntity
                .ok(new ResponseWrapper("Order is found",orderService.findAllOrdersByEmail(email),HttpStatus.ACCEPTED));
    }






}
