package br.com.estudo.microservices.hrworker.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.estudo.microservices.hrworker.entities.Worker;
import br.com.estudo.microservices.hrworker.repositories.WorkerRepository;
import br.com.estudo.microservices.hrworker.services.WorkerService;

@Service
public class WorkerServiceImpl implements WorkerService{

	@Autowired
	private WorkerRepository repository;
	
	@Override
	public List<Worker> buscarTodosWorkers() {
		return this.repository.findAll();
	}

	@Override
	public Worker buscarWorkerPorId(Long id) {
		return this.repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado!"));
	}

}
