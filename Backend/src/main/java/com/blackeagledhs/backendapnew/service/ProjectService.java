package com.blackeagledhs.backendapnew.service;

import com.blackeagledhs.backendapnew.entity.Project;
import com.blackeagledhs.backendapnew.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> findProjects(){
        return projectRepository.findAll();
    }

    public Optional<Project> getIdProject(Long idproject) {
        return projectRepository.findById(idproject);
    }

    public Project editProject(Project project){
        return projectRepository.save(project);
    }

    public void deleteProject(Long idproject){
        projectRepository.deleteById(idproject);
    }
}
