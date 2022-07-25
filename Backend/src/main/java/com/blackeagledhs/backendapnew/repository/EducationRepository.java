package com.blackeagledhs.backendapnew.repository;

import com.blackeagledhs.backendapnew.entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {

}