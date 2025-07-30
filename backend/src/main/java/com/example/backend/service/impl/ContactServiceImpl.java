package com.example.backend.service.impl;

import com.example.backend.model.Contact;
import com.example.backend.repository.ContactRepository;
import com.example.backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateById(Long id, Contact contact) {
        Contact managedContact = this.findById(id);
        managedContact.setFirstName(contact.getFirstName());
        managedContact.setLastName(contact.getLastName());
        managedContact.setPhone(contact.getPhone());
        managedContact.setEmail(contact.getEmail());

        return this.save(managedContact);
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}
