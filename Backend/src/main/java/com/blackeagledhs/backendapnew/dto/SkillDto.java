package com.blackeagledhs.backendapnew.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SkillDto implements Serializable {
    private final Long idskill;
    private final String skill;
    private final String percentage;
}
