package com.example.backend.controller;

import com.example.backend.model.Contact;
import com.example.backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public Contact save(@RequestBody Contact contact) {
        return contactService.save(contact);
    }

    @GetMapping
    public List<Contact> findAll() {
        return contactService.findAll();
    }

    @GetMapping("/{id}")
    public Contact findById(@PathVariable Long id) {
        return contactService.findById(id);
    }

    @PutMapping("/{id}")
    public Contact update(@PathVariable Long id, @RequestBody Contact contact) {
        return contactService.updateById(id, contact);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contactService.deleteById(id);
    }
}