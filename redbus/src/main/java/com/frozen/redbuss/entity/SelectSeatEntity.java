package com.frozen.redbuss.entity;
import lombok.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Data
@Getter
@Setter
@Entity
@Table(name = "selectseat_table")
public class SelectSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seatNo")
    private Integer seatNo;
    @Column(name = "userId")
    private Integer userId;
}
