package com.frozen.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString

public class SignUpdto implements Serializable {
    private String name;
    private String email;
    private String password;


    public SignUpdto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
