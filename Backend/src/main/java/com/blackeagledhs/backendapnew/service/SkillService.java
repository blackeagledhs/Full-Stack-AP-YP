package com.blackeagledhs.backendapnew.service;


import com.blackeagledhs.backendapnew.entity.Skill;
import com.blackeagledhs.backendapnew.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill addSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public List<Skill> findSkill(){
        return skillRepository.findAll();
    }

    public Optional<Skill> getIdSkill(Long idskill) {
        return skillRepository.findById(idskill);
    }

    public Skill editSkill(Skill skill){
        return skillRepository.save(skill);
    }

    public void deleteSkill(Long idskill){
        skillRepository.deleteById(idskill);
    }
}
