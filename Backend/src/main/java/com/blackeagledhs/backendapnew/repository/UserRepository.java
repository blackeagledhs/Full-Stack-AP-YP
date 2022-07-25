package com.blackeagledhs.backendapnew.repository;

import com.blackeagledhs.backendapnew.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}