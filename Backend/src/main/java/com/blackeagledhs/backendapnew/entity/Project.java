package com.blackeagledhs.backendapnew.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "project")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idproject;
    private String projectname;
    private String projectdescription;
    private String urlproject;
    private String urlimgproject;

    public Project() {
    }

    public Project(Long idproject, String projectname, String projectdescription, String urlproject, String urlimgproject) {
        this.idproject = idproject;
        this.projectname = projectname;
        this.projectdescription = projectdescription;
        this.urlproject = urlproject;
        this.urlimgproject = urlimgproject;
    }

    public Project(String projectname, String projectdescription, String urlproject, String urlimgproject) {
        this.projectname = projectname;
        this.projectdescription = projectdescription;
        this.urlproject = urlproject;
        this.urlimgproject = urlimgproject;
    }

    public Long getIdproject() {
        return idproject;
    }

    public void setIdproject(Long idproject) {
        this.idproject = idproject;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getProjectdescription() {
        return projectdescription;
    }

    public void setProjectdescription(String projectdescription) {
        this.projectdescription = projectdescription;
    }

    public String getUrlproject() {
        return urlproject;
    }

    public void setUrlproject(String urlproject) {
        this.urlproject = urlproject;
    }

    public String getUrlimgproject() {
        return urlimgproject;
    }

    public void setUrlimgproject(String urlimgproject) {
        this.urlimgproject = urlimgproject;
    }
}