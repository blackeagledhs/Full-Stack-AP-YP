package com.blackeagledhs.backendapnew.repository;

import com.blackeagledhs.backendapnew.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}