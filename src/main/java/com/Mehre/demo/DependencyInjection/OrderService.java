package com.Mehre.demo.DependencyInjection;

import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService paymentService;

    // Constructor Injection
    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Setter Injection (optional)
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void placeOrder() {
        paymentService.payment();
        System.out.println("Order placed");
    }
}