package com.blackeagledhs.backendapnew.controller;

import com.blackeagledhs.backendapnew.entity.Contact;
import com.blackeagledhs.backendapnew.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    @Autowired

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Contact>> getContact() {
        List<Contact> contacts = contactService.findContacts();
        return new ResponseEntity(contacts, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{idContact}")
    public ResponseEntity<Contact> getContactById(@PathVariable("idContact") Long idContact) {
        Contact contact = contactService.getIdcontact(idContact).orElse(null);
        return new ResponseEntity(contact, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createContact(@RequestBody Contact contactDto){
        Contact contact = new Contact(contactDto.getSocialnetwork(), contactDto.getMail());
        contactService.addContact(contact);
        return new ResponseEntity(contact, HttpStatus.OK);
    }

    @PutMapping("/edit/{idContact}")
    public ResponseEntity<?> editContact(@PathVariable("idContact") Long idContact, @RequestBody Contact contactDto) {
        Contact contact = contactService.getIdcontact(idContact).orElse(null);

        contact.setSocialnetwork(contactDto.getSocialnetwork());
        contact.setMail(contactDto.getMail());
        contactService.addContact(contact);
        return new ResponseEntity(contact, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idContact}")
    public ResponseEntity<?> deleteContact(@PathVariable("idContact") Long idContact){
        contactService.deleteContact(idContact);
        return new ResponseEntity(HttpStatus.OK);
    }
}
