package com.blackeagledhs.backendapnew.service;

import com.blackeagledhs.backendapnew.entity.Experience;
import com.blackeagledhs.backendapnew.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public Experience addExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    public List<Experience> findExperiences(){
        return experienceRepository.findAll();
    }

    public Optional<Experience> getIdExperience(Long idexperience) {
        return experienceRepository.findById(idexperience);
    }

    public Experience editExperience(Experience experience){
        return experienceRepository.save(experience);
    }

    public void deleteExperience(Long idexperience){
        experienceRepository.deleteById(idexperience);
    }
}
