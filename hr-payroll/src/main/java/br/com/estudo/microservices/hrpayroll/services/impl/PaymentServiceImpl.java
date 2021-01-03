package br.com.estudo.microservices.hrpayroll.services.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.estudo.microservices.hrpayroll.entities.Payment;
import br.com.estudo.microservices.hrpayroll.entities.Worker;
import br.com.estudo.microservices.hrpayroll.feignclients.WorkerFeignClient;
import br.com.estudo.microservices.hrpayroll.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private WorkerFeignClient workerFeignClient;

	@Override
	public Optional<Payment> getPayment(long workerId, int days) {		
		Worker worker = workerFeignClient.buscarWorkersPorId(workerId);
		return Optional.of(Payment.builder().name(worker.getName()).dailyIncome(worker.getDailyIncome()).days(days).build());
	}

}
