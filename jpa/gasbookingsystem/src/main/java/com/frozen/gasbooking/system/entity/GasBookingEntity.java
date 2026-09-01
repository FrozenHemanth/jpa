package com.frozen.gasbooking.system.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="gas_booking")
@Entity
@NoArgsConstructor
@Data
public class GasBookingEntity {

    @Id
    private String bookingId;
    @Column(name="bookingAmount")
    private Long bookingAmount;
    @Column(name="company")
    private String company;

    public GasBookingEntity(String bookingId, Long bookingAmount, String company) {

        this.bookingId = bookingId;
        this.bookingAmount = bookingAmount;
        this.company = company;
    }
}
