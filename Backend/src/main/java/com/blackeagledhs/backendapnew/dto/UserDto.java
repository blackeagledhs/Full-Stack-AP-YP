package com.blackeagledhs.backendapnew.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private final Long idUser;
    private final String name;
    private final String surname;
    private final String title;
    private final String urlImgprofile;
    private final String urlImgbanner;
    private final String aboutme;


}
