package com.blackeagledhs.backendapnew.controller;

import com.blackeagledhs.backendapnew.entity.Project;
import com.blackeagledhs.backendapnew.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Project>> getProjects(){
        List<Project> projects = projectService.findProjects();
        return new ResponseEntity(projects, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{idProject}")
    public ResponseEntity<Project> getProject(@PathVariable("idProject") Long idProject){
        Project project = projectService.getIdProject(idProject).orElse(null);
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> createProject(@RequestBody Project projectDto){
        Project project = new Project(projectDto.getProjectname(), projectDto.getProjectdescription(), projectDto.getUrlproject(), projectDto.getUrlimgproject());
        projectService.addProject(project);
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @PutMapping("/edit/{idProject}")
    public ResponseEntity<?> editProject(@PathVariable("idProject") Long idProject, @RequestBody Project projectDto){
        Project project = projectService.getIdProject(idProject).orElse(null);
        project.setProjectname(projectDto.getProjectname());
        project.setProjectdescription(projectDto.getProjectdescription());
        project.setUrlproject(projectDto.getUrlproject());
        project.setUrlimgproject(projectDto.getUrlimgproject());
        projectService.addProject(project);
        return new ResponseEntity(project, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idProject}")
    public ResponseEntity<?> deleteProject(@PathVariable("idProject") Long idProject){
        projectService.deleteProject(idProject);
        return new ResponseEntity(HttpStatus.OK);
    }
}
