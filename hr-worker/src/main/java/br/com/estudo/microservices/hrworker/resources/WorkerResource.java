package br.com.estudo.microservices.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.microservices.hrworker.entities.Worker;
import br.com.estudo.microservices.hrworker.services.WorkerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/workers")
@Slf4j
public class WorkerResource {
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerService service;
	
	@GetMapping
	public List<Worker> buscarListWorkers() {
		return this.service.buscarTodosWorkers();
	}
	
	@GetMapping("{id}")
	public Worker buscarWorkersPorId(@PathVariable Long id) {
		log.info("Port:"+env.getProperty("local.server.port"));		
		return this.service.buscarWorkerPorId(id);
	}
}
