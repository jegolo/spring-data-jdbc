package com.example.demo;

import com.example.demo.entities.Order;
import com.example.demo.entities.OrderItem;
import com.example.demo.reposity.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
@ActiveProfiles("logging-test")
@Transactional
public class TestOrderRepository {

    @Autowired
    private OrderRepository repository;

    @Test
    public void testFindOrder() {
        Order order = new Order();
        order.setOrderId(2);
        order.setOrderDate(LocalDateTime.now());

        OrderItem orderItem = new OrderItem();
        orderItem.setDescription("Order Item 2");
        order.getOrderItems().add(orderItem);

        repository.save(order);


        Optional<Order> result = repository.findById(2);
        System.out.println(result.get());
    }

}
