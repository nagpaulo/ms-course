package br.com.estudo.microservices.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.microservices.hrworker.entities.Worker;
import br.com.estudo.microservices.hrworker.services.WorkerService;

@RestController
@RequestMapping("/workers")
public class WorkerResource {
	
	@Autowired
	private WorkerService service;
	
	@GetMapping
	public List<Worker> buscarListWorkers() {
		return this.service.buscarTodosWorkers();
	}
	
	@GetMapping("{id}")
	public Worker buscarWorkersPorId(@PathVariable Long id) {
		return this.service.buscarWorkerPorId(id);
	}
}
