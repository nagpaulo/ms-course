package br.com.estudo.microservices.hrpayroll.services;

import java.util.Optional;

import br.com.estudo.microservices.hrpayroll.entities.Payment;

public interface PaymentService {
	Optional<Payment> getPayment(long workerId, int days);
}
