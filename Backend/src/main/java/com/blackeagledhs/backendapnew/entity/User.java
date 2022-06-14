package com.blackeagledhs.backendapnew.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    private String name;
    private String surname;
    private String title;
    private String urlImgprofile;
    private String urlImgbanner;
    @Column(columnDefinition = "varchar(1000)")
    private String aboutme;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ideducation")
    private List<Education> educationList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idskill")
    private List<Skill> skillList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idexperience")
    private List<Experience> experienceList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idproject")
    private List<Project> projectList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idcontact")
    private List<Contact> contactList;

    public User() {
    }

    public User(Long idUser, String name, String surname, String title, String urlImgprofile, String urlImgbanner, String aboutme) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.urlImgprofile = urlImgprofile;
        this.urlImgbanner = urlImgbanner;
        this.aboutme = aboutme;
    }

    public User(String name, String surname, String title, String urlImgprofile, String urlImgbanner, String aboutme) {
        this.name = name;
        this.surname = surname;
        this.title = title;
        this.urlImgprofile = urlImgprofile;
        this.urlImgbanner = urlImgbanner;
        this.aboutme = aboutme;
    }

    public String getUrlImgbanner() {
        return urlImgbanner;
    }

    public void setUrlImgbanner(String urlImgbanner) {
        this.urlImgbanner = urlImgbanner;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlImgprofile() {
        return urlImgprofile;
    }

    public void setUrlImgprofile(String urlImgprofile) {
        this.urlImgprofile = urlImgprofile;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }
}