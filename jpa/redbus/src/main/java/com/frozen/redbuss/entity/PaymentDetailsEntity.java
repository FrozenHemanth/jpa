package com.frozen.redbuss.entity;
import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@Entity
@Table(name= "PaymentDetails")
public class PaymentDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;
    @Column(name = "cardHolderName")
    private String cardHolderName;
    @Column(name = "upiId")
    private String upiId;
    @Column(name = "bankAccountNumber")
    private String bankAccountNumber;

}
