package com.frozen.Runner;

import com.frozen.daoimpl.PaymentDaoImpl;
import com.frozen.dto.PaymentDto;
import com.frozen.entity.PaymentEntity;
import com.frozen.service.PaymentService;
import com.frozen.serviceimpl.PaymentServiceImpl;

import java.util.List;

public class PaymentRunner {
    public static void main(String[] args) {

       //for savePayment
      //  PaymentDto paymentDto = new PaymentDto("2", 200L, "USD");
      //  PaymentService paymentService = new PaymentServiceImpl();
     //   paymentService.saveAndValidatePayment(paymentDto);

        //for saveAllPayments
       // List<PaymentDto> paymentDtos = List.of(new PaymentDto("1", 100L, "RS"), new PaymentDto("2", 200L, "RS"));
     //   paymentService.saveAndValidateAllPayments(paymentDtos);

       // for findPaymentEntitybyReceipt
        PaymentServiceImpl paymentService = new PaymentServiceImpl();
       PaymentDto paymentDto1 = paymentService.findPaymentEntitybyReceipt("2");
       System.out.println("PaymentDto: " + paymentDto1);

        //for findPaymentEntitybyCurrency

      //  PaymentDto paymentDto2 = paymentService.findPaymentEntitybyCurrency("USD");
     //   System.out.println("PaymentDto: " + paymentDto2);
     //   PaymentDto paymentDto3 = paymentService.findPaymentEntitybyCurrency("RS");
     //   System.out.println("PaymentDto: " + paymentDto3);
    }
}
