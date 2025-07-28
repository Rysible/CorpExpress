package com.example.backend.service.impl;

import com.example.backend.model.Order;
import com.example.backend.repository.OrderRepository;
import com.example.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateById(Long id, Order order) {
        Order managedOrder = this.findById(id);

        managedOrder.setContact(order.getContact());
        managedOrder.setCompany(order.getCompany());
        managedOrder.setAwardName(order.getAwardName());
        managedOrder.setMachineUsed(order.getMachineUsed());
        managedOrder.setShippingCost(order.getShippingCost());
        managedOrder.setRetailPrice(order.getRetailPrice());
        managedOrder.setParts(order.getParts());

        return this.save(managedOrder);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
