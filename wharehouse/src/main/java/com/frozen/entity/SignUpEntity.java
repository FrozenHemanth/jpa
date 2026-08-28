package com.frozen.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "sign_up")
public class SignUpEntity {

    @Id
    private String name;
    private String email;
    private String password;

    public SignUpEntity(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
