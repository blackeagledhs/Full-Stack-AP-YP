package com.blackeagledhs.backendapnew.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExperienceDto implements Serializable {
    private final Long idexperience;
    private final String company;
    private final String description;
    private final String admission;
    private final String egress;
}
