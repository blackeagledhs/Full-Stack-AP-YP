package com.blackeagledhs.backendapnew.entity;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "skill")
public class Skill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idskill;
    private String skill;
    private String percentage;

    public Skill() {
    }

    public Skill(Long idskill, String skill, String percentage) {
        this.idskill = idskill;
        this.skill = skill;
        this.percentage = percentage;
    }

    public Skill(String skill, String percentage) {
        this.skill = skill;
        this.percentage = percentage;
    }

    public Long getIdskill() {
        return idskill;
    }

    public void setIdskill(Long idskill) {
        this.idskill = idskill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }
}