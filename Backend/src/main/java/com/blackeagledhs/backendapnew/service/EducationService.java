package com.blackeagledhs.backendapnew.service;

import com.blackeagledhs.backendapnew.entity.Education;
import com.blackeagledhs.backendapnew.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EducationService {

    private final EducationRepository educationRepository;

    @Autowired
    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public Education addEducation(Education education) {
        return educationRepository.save(education);
    }

    public List<Education> findEducations() {
        return educationRepository.findAll();
    }

    public Optional<Education> getIdeducation(Long ideducation){
        return educationRepository.findById(ideducation);
    }

    public Education editEducation(Education education){
        return educationRepository.save(education);
    }

    public void deleteEducation(Long ideducation){
        educationRepository.deleteById(ideducation);
    }
}
