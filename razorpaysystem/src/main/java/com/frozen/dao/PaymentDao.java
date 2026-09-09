package com.frozen.dao;

import com.frozen.entity.PaymentEntity;

import java.util.List;

public interface PaymentDao {
    Boolean savePayment(PaymentEntity paymentEntity);
    Boolean saveAllPayments(List<PaymentEntity> paymentEntities);

    public PaymentEntity getPaymentEntityByReceipt(String receipt);

    public PaymentEntity findPaymentEntitybyCurrency(String currency);

}
