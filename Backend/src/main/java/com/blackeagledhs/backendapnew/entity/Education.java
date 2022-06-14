package com.blackeagledhs.backendapnew.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "education")
public class Education implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long ideducation;
    private String institute;
    private String certificate;
    private String year;

    public Education() {
    }

    public Education(Long ideducation, String institute, String certificate, String year) {
        this.ideducation = ideducation;
        this.institute = institute;
        this.certificate = certificate;
        this.year = year;
    }

    public Education(String institute, String certificate, String year) {
        this.institute = institute;
        this.certificate = certificate;
        this.year = year;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public Long getIdeducation() {
        return ideducation;
    }

    public void setIdeducation(Long ideducation) {
        this.ideducation = ideducation;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}