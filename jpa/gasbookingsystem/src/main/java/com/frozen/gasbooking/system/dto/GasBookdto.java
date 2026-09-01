package com.frozen.gasbooking.system.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class GasBookdto implements Serializable {
    private String bookingId;
    private Long bookingAmount;
    private String company;

    public GasBookdto(String bookingId, Long bookingAmount, String company) {
        this.bookingId = bookingId;
        this.bookingAmount = bookingAmount;
        this.company = company;
    }
}