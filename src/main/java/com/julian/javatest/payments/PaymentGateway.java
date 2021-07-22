package com.julian.javatest.payments;

public interface PaymentGateway {
    PaymentResponse requestPayment(PaymentRequest request);

}
