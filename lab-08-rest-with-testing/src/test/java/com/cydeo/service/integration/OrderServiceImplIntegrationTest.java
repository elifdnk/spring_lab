package com.cydeo.service.integration;

import com.cydeo.entity.Cart;
import com.cydeo.entity.Customer;
import com.cydeo.entity.Order;
import com.cydeo.enums.PaymentMethod;
import com.cydeo.repository.CartRepository;
import com.cydeo.repository.CustomerRepository;
import com.cydeo.repository.OrderRepository;
import com.cydeo.service.CartService;
import com.cydeo.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class OrderServiceImplIntegrationTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartService cartService;
    @Autowired
    private CustomerRepository customerRepository;

    // If tests are failing, please run tests one by one. not on the class level.

    @Test
    public void should_place_order_when_payment_method_is_transfer(){
        Cart cart = cartRepository.findById(3L).get();
        Order orderBeforePlaceOrderMethod = orderRepository.findAllByCart(cart);
        assertNull(orderBeforePlaceOrderMethod); //before we run the test there is no order created by this cart

        BigDecimal result = orderService.placeOrder(PaymentMethod.TRANSFER, 3L, 56L); //order insert the database and direct relation with the cart
        Order orderAfterPlaceOrderMethod = orderRepository.findAllByCart(cart);
        assertNotNull(orderAfterPlaceOrderMethod);
        assertThat(result).isEqualTo(new BigDecimal("901.00"));
    }

    @Test
    public void should_place_order_without_discount_when_payment_method_is_credit_card(){
        Cart cart = cartRepository.findById(3L).get();
        Order orderBeforePlaceOrderMethod = orderRepository.findAllByCart(cart);
        assertNull(orderBeforePlaceOrderMethod);

        BigDecimal result = orderService.placeOrder(PaymentMethod.CREDIT_CARD, 3L, 56L);
        Order orderAfterPlaceOrderMethod = orderRepository.findAllByCart(cart);
        assertNotNull(orderAfterPlaceOrderMethod);
        assertThat(result).isEqualTo(new BigDecimal("891.00"));
    }

    @Test
    public void should_place_order_with_discount_when_payment_method_is_credit_card(){
        Cart cart = cartRepository.findById(3L).get();
        Order orderBeforePlaceOrderMethod = orderRepository.findAllByCart(cart);
        assertNull(orderBeforePlaceOrderMethod);
        assertNull(cart.getDiscount());

        BigDecimal discountAmount = cartService.applyDiscountToCartIfApplicableAndCalculateDiscountAmount("50 dollar",cart);

        assertThat(discountAmount).isEqualTo(new BigDecimal("50.00"));
        assertNotNull(cart.getDiscount());

        BigDecimal result = orderService.placeOrder(PaymentMethod.CREDIT_CARD, 3L, 56L);
        Order orderAfterPlaceOrderMethod = orderRepository.findAllByCart(cart);
        assertNotNull(orderAfterPlaceOrderMethod);
        assertThat(result).isEqualTo(new BigDecimal("841.00"));
    }

    @Test
    public void should_not_place_order_when_the_customer_does_not_exist(){
        Throwable throwable = catchThrowable(() ->
                orderService.placeOrder(PaymentMethod.CREDIT_CARD, 1L, 0L));
        assertThat(throwable).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void should_not_place_order_when_the_cart_does_not_exist(){
        Customer customer = new Customer();
        customerRepository.save(customer);

        Throwable throwable = catchThrowable(() ->
                orderService.placeOrder(PaymentMethod.CREDIT_CARD, 0L, customer.getId()));
        assertThat(throwable).isInstanceOf(RuntimeException.class);
        assertThat(throwable).hasMessage("Cart couldn't find or cart is empty");
    }

}