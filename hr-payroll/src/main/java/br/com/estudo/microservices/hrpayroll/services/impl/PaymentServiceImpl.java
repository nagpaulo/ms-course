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
import br.com.estudo.microservices.hrpayroll.services.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${hr-worker.host}")
	private String workerHost;

	@Override
	public Optional<Payment> getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(workerId));
		
		Worker worker = restTemplate.getForObject(workerHost+"/workers/{id}", Worker.class, uriVariables);
		return Optional.of(Payment.builder().name(worker.getName()).dailyIncome(worker.getDailyIncome()).days(days).build());
	}

}
