package br.com.estudo.microservices.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.microservices.hrworker.entities.Worker;
import br.com.estudo.microservices.hrworker.services.WorkerService;
import lombok.extern.slf4j.Slf4j;

@RefreshScope
@RestController
@RequestMapping("/workers")
@Slf4j
public class WorkerResource {
	
	@Value("${test.config}")
	private String testConfig;
	
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
	
	@GetMapping("/configs")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void test() {
		log.info("Config = " + testConfig);
	}
}
