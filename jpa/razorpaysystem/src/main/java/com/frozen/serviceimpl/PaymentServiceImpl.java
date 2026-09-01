package com.frozen.serviceimpl;
import com.frozen.dao.PaymentDao;
import com.frozen.daoimpl.PaymentDaoImpl;
import com.frozen.daoimpl.PaymentDaoImpl;
import com.frozen.dto.PaymentDto;
import com.frozen.entity.PaymentEntity;
import com.frozen.service.PaymentService;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    PaymentDao paymentDao = new PaymentDaoImpl();

    @Override
    public String saveAndValidatePayment(PaymentDto paymentDto) {
        String isSaved = null;
        if (paymentDto != null) {
            PaymentEntity paymentEntity = new PaymentEntity();
            paymentEntity.setReceipt(paymentDto.getReceipt());
            paymentEntity.setAmount(paymentDto.getAmount());
            paymentEntity.setCurrency(paymentDto.getCurrency());
            Boolean saved = paymentDao.savePayment(paymentEntity);

            if (saved) {
                isSaved = "Payment saved successfully";
            } else {
                isSaved = "Payment not saved";
            }
        return isSaved;
        }
        return isSaved;
    }
        @Override
        public String saveAndValidateAllPayments (List <PaymentDto> paymentDtos) {
            String isSaved = null;
            if (paymentDtos != null && !paymentDtos.isEmpty()) {
                List<PaymentEntity> paymentEntities = paymentDtos.stream().map(dto -> {
                    PaymentEntity entity = new PaymentEntity();
                    entity.setReceipt(dto.getReceipt());
                    entity.setAmount(dto.getAmount());
                    entity.setCurrency(dto.getCurrency());
                    return entity;
                }).toList();
                Boolean saved = paymentDao.saveAllPayments(paymentEntities);
                if (saved) {
                    isSaved = "All payments saved successfully";
                } else {
                    return "";
                }

            }
            return isSaved;
        }

    @Override
    public PaymentDto findPaymentEntitybyReceipt(String receipt) {
        System.out.println("PaymentServiceImpl.findPaymentEntitybyReceipt() called with receipt: " + receipt);
        PaymentEntity paymentEntity = paymentDao.getPaymentEntityByReceipt(receipt);
        if (paymentEntity != null) {
            return new PaymentDto(paymentEntity.getReceipt(), paymentEntity.getAmount(), paymentEntity.getCurrency());
        }
        else {
            System.out.println("PaymentServiceImpl.findPaymentEntitybyReceipt() - Payment not found for receipt: " + receipt);
        return null;
        }


    }

    @Override
    public PaymentDto findPaymentEntity(String receipt) {
        return null;
    }

    @Override
    public PaymentDto findPaymentEntitybyCurrency(String currency) {
        System.out.println("PaymentServiceImpl.findPaymentEntitybyCurrency() called with currency: " + currency);
        PaymentEntity paymentEntity = paymentDao.findPaymentEntitybyCurrency(currency);
        if (paymentEntity != null) {
            return new PaymentDto(paymentEntity.getReceipt(), paymentEntity.getAmount(), paymentEntity.getCurrency());
        }
        else {
            System.out.println("PaymentServiceImpl.findPaymentEntitybyCurrency() - Payment not found for currency: " + currency);
            return null;
        }
    }
}