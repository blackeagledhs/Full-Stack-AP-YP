package com.blackeagledhs.backendapnew.controller;

import com.blackeagledhs.backendapnew.entity.Education;
import com.blackeagledhs.backendapnew.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/education")
public class EducationController {

    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService){
        this.educationService = educationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Education>> getEducations(){
        List<Education> educations = educationService.findEducations();
        return new ResponseEntity(educations, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{idEducation}")
    public ResponseEntity<Education> getEducationById(@PathVariable("idEducation") Long idEduaction){
        Education education = educationService.getIdeducation(idEduaction).orElse(null);
        return new ResponseEntity(education, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createEducation(@RequestBody Education educationDto){
        Education education = new Education(educationDto.getInstitute(), educationDto.getCertificate(), educationDto.getYear());
        educationService.addEducation(education);
        return new ResponseEntity(education, HttpStatus.OK);
    }

    @PutMapping("/edit/{idEducation}")
    public ResponseEntity<?> editEducation(@PathVariable("idEducation") Long idEducation, @RequestBody Education educationDto){
        Education education = educationService.getIdeducation(idEducation).orElse(null);

        education.setInstitute(educationDto.getInstitute());
        education.setCertificate(educationDto.getCertificate());
        education.setYear(educationDto.getYear());
        educationService.addEducation(education);
        return new ResponseEntity(education, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idEducation}")
    public ResponseEntity<?> deleteEducation(@PathVariable("idEducation") Long idEducation){
        educationService.deleteEducation(idEducation);
        return new ResponseEntity(HttpStatus.OK);
    }
}
