package com.frozen.service;

import com.frozen.dto.PaymentDto;

import java.util.List;

public interface PaymentService {
    public String saveAndValidatePayment(PaymentDto paymentDto);
    public String saveAndValidateAllPayments(List<PaymentDto> paymentDto);
    public PaymentDto findPaymentEntitybyReceipt(String receipt);
    public PaymentDto findPaymentEntity(String receipt);

    PaymentDto findPaymentEntitybyCurrency(String currency);
}
