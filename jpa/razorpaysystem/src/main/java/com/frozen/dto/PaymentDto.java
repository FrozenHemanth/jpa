package com.frozen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
public class PaymentDto implements Serializable {
    private String receipt;
    private Long amount;
    private String currency;

    public PaymentDto(String receipt, Long amount, String currency) {
   this.receipt = receipt;
   this.amount = amount;
   this.currency = currency;
    }
}
