package com.blackeagledhs.backendapnew.repository;

import com.blackeagledhs.backendapnew.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
}