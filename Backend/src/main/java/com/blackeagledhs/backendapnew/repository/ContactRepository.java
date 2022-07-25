package com.blackeagledhs.backendapnew.repository;

import com.blackeagledhs.backendapnew.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}