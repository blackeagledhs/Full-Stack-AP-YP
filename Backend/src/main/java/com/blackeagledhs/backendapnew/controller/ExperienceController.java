package com.blackeagledhs.backendapnew.controller;

import com.blackeagledhs.backendapnew.entity.Experience;
import com.blackeagledhs.backendapnew.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experience")
@CrossOrigin(origins = "*")
public class ExperienceController {

    private final ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService){
        this.experienceService = experienceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Experience>> getExperience(){
        List<Experience> experiences = experienceService.findExperiences();
        return new ResponseEntity(experiences, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{idExperience}")
    public ResponseEntity<Experience> getExperienceById(@PathVariable("idExperience") Long idExperience){
        Experience experience = experienceService.getIdExperience(idExperience).orElse(null);
        return new ResponseEntity(experience, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createExperience(@RequestBody Experience experienceDto){
        Experience experience = new Experience (experienceDto.getCompany(), experienceDto.getDescription(), experienceDto.getAdmission(), experienceDto.getEgress());
        experienceService.addExperience(experience);
        return new ResponseEntity(experience, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Experience> editExperience(@RequestBody Experience experienceDto){
        Experience experience = experienceService.editExperience(experienceDto);
        return new ResponseEntity<>(experience, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idExperience}")
    public ResponseEntity<?> deleteExperience(@PathVariable("idExperience") Long idExperience){
        experienceService.deleteExperience(idExperience);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
