package com.example.backend.controller;

import com.example.backend.model.Order;
import com.example.backend.repository.CompanyRepository;
import com.example.backend.repository.ContactRepository;
import com.example.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/add")
    public Order save(@RequestBody Order order) {
        // Optional: fetch company/contact from DB if needed
        if (order.getCompany() != null && order.getCompany().getId() != null) {
            order.setCompany(companyRepository.findById(order.getCompany().getId()).orElseThrow());
        }
        if (order.getContact() != null && order.getContact().getId() != null) {
            order.setContact(contactRepository.findById(order.getContact().getId()).orElseThrow());
        }
        return orderService.save(order);
    }

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PutMapping("/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order order) {
        return orderService.updateById(id, order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        orderService.deleteById(id);
    }
}