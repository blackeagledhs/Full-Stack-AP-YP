package com.blackeagledhs.backendapnew.repository;

import com.blackeagledhs.backendapnew.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}