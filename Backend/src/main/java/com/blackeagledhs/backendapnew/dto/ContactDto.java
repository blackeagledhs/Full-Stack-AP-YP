package com.blackeagledhs.backendapnew.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ContactDto implements Serializable {
    private final Long idcontact;
    private final String socialnetwork;
    private final String mail;
}
