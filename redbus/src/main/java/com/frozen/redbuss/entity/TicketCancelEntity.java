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
@Table(name = "ticketcancel_table")
public class TicketCancelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "seatNo")
    private Integer seatNo;


}
