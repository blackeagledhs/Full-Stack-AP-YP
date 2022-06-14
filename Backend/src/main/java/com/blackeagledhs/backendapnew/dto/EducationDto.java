package com.blackeagledhs.backendapnew.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EducationDto implements Serializable {
    private final Long ideducation;
    private final String institute;
    private final String certificate;
    private final String year;
}
