package com.blackeagledhs.backendapnew.service;

import com.blackeagledhs.backendapnew.entity.Contact;
import com.blackeagledhs.backendapnew.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public Contact addContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> findContacts(){
        return contactRepository.findAll();
    }

    public Optional<Contact> getIdcontact(Long idcontact) {
        return contactRepository.findById(idcontact);
    }

    public Contact editContact(Contact contact){
        return contactRepository.save(contact);
    }

    public void deleteContact(Long idcontact){
        contactRepository.deleteById(idcontact);
    }

}
