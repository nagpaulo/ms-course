package br.com.estudo.microservices.hrpayroll.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.estudo.microservices.hrpayroll.entities.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Override
	public Optional<Payment> getPayment(long workerId, int days) {
		return Optional.of(Payment.builder().name("Bob").dailyIncome(200.0).days(days).build());
	}

}
