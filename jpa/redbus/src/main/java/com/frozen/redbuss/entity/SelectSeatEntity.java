package com.frozen.redbuss.entity;
import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "SelectSeatEntity")
public class SelectSeatEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "seatNumber")
    private Integer seatNumber;
    @Column(name = "seatType")
    private String seatType;
    @Column(name = "seatPrice")
    private Integer seatPrice;
    @Column(name = "seatId")
    private Integer seatId;
}
