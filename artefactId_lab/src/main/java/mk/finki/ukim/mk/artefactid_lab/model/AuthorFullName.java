package mk.finki.ukim.mk.artefactid_lab.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class AuthorFullName implements Serializable {
    private String name;
    private String surname;

    public AuthorFullName() {
    }

    public AuthorFullName(String name, String surName) {
        this.name = name;
        this.surname = surName;
    }
}
