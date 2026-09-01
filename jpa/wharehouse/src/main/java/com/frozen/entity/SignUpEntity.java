package com.frozen.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "sign_up")
@NamedQuery(name = "SignUpEntity.findByName", query = "SELECT s FROM SignUpEntity s WHERE s.name = :name")
public class SignUpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String password;

    public SignUpEntity(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
