package com.blackeagledhs.backendapnew.repository;

import com.blackeagledhs.backendapnew.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}