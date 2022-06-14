package com.blackeagledhs.backendapnew.repository;

import com.blackeagledhs.backendapnew.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}