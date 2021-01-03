package br.com.estudo.microservices.hrpayroll.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.estudo.microservices.hrpayroll.entities.Payment;
import br.com.estudo.microservices.hrpayroll.services.PaymentService;

@RestController
@RequestMapping("payment")
public class PaymentResource {

	@Autowired
	private PaymentService service;

	@GetMapping("/{workerId}/days/{days}")
	public Payment getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
		return this.service.getPayment(workerId, days)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pagamento não registrado!"));
	}
}
