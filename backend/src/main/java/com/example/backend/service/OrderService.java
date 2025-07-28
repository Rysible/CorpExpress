package com.example.backend.service;

import com.example.backend.model.Order;

import java.util.List;

public interface OrderService {
    Order save(Order order);

    Order updateById(Long id, Order order);

    List<Order> findAll();

    Order findById(Long id);

    void deleteById(Long id);
}
