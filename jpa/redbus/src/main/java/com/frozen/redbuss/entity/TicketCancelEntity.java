package com.frozen.redbuss.entity;
import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name = "TicketCancelEntity")
public class TicketCancelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "seatId")
    private Integer seatId;


}
