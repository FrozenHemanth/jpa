package com.frozen.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="razo_payment")
@Entity
@NoArgsConstructor
@Data
public class PaymentEntity {

@Id
private String receipt;
@Column(name="amount")
private Long amount;
@Column(name="currency")
private String currency;

public PaymentEntity(String receipt, Long amount, String currency) {

    this.receipt = receipt;
    this.amount = amount;
    this.currency = currency;
}
}
