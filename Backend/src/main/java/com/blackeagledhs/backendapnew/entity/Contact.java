package com.blackeagledhs.backendapnew.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contact")
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcontact;
    private String socialnetwork;
    private String mail;

    public Contact() {
    }

    public Contact(Long idcontact, String socialnetwork, String mail) {
        this.idcontact = idcontact;
        this.socialnetwork = socialnetwork;
        this.mail = mail;
    }

    public Contact(String socialnetwork, String mail) {
        this.socialnetwork = socialnetwork;
        this.mail = mail;
    }

    public Long getIdcontact() {
        return idcontact;
    }

    public void setIdcontact(Long idcontact) {
        this.idcontact = idcontact;
    }

    public String getSocialnetwork() {
        return socialnetwork;
    }

    public void setSocialnetwork(String socialnetwork) {
        this.socialnetwork = socialnetwork;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}