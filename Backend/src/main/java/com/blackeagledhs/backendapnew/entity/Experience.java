package com.blackeagledhs.backendapnew.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "experience")
public class Experience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idexperience;
    private String company;
    private String description;
    private String admission;
    private String egress;

    public Experience() {

    }

    public Experience(Long idexperience, String company, String description, String admission, String egress) {
        this.idexperience = idexperience;
        this.company = company;
        this.description = description;
        this.admission = admission;
        this.egress = egress;
    }

    public Experience(String company, String description, String admission, String egress) {
        this.company = company;
        this.description = description;
        this.admission = admission;
        this.egress = egress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getIdexperience() {
        return idexperience;
    }

    public void setIdexperience(Long idexperience) {
        this.idexperience = idexperience;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getEgress() {
        return egress;
    }

    public void setEgress(String egress) {
        this.egress = egress;
    }
}