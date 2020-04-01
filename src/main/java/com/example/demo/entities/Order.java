package com.example.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Table("Orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    private int orderId;
    private LocalDateTime orderDate;

    @MappedCollection(idColumn = "order_item_Id", keyColumn = "order_Id")
    private List<OrderItem> orderItems = new ArrayList<>();

    Order withId(int orderId) {
        return new Order(orderId, this.orderDate, this.orderItems);
    }
}
