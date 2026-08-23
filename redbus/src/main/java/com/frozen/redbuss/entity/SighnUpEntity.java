package com.frozen.redbuss.entity;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "signup_table")
public class SighnUpEntity {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name = "id")
    private Integer id;
@Column(name = "name", nullable = false)
    private String name;
@Column(name = "email", nullable = false)
    private String email;
@Column(name = "password", nullable = false)
    private String password;

}
