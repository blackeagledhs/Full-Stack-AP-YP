package com.blackeagledhs.backendapnew.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectDto implements Serializable {
    private final Long idproject;
    private final String projectname;
    private final String projectdescription;
    private final String urlproject;
    private final String urlimgproject;
}
