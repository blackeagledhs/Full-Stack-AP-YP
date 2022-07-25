package com.blackeagledhs.backendapnew.controller;

import com.blackeagledhs.backendapnew.entity.Skill;
import com.blackeagledhs.backendapnew.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
@CrossOrigin(origins = "*")
public class SkillController {

    private final SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService){
        this.skillService = skillService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Skill>> getSkill(){
        List<Skill> skills = skillService.findSkill();
        return new ResponseEntity(skills, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{idSkill}")
    public ResponseEntity<Skill> getSkillById(@PathVariable("idSkill") Long idSkill){
        Skill skill = skillService.getIdSkill(idSkill).orElse(null);
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createSkill(@RequestBody Skill skillDto){
        Skill skill = new Skill(skillDto.getSkill(), skillDto.getPercentage());
        skillService.addSkill(skill);
        return new ResponseEntity(skill, HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Skill> editSkill(@RequestBody Skill skillDto){
        Skill skill = skillService.editSkill(skillDto);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idSkill}")
    public ResponseEntity<?> deleteSkill(@PathVariable("idSkill") Long idSkill){
        skillService.deleteSkill(idSkill);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
