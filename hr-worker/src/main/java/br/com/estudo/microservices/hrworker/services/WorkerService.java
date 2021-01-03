package br.com.estudo.microservices.hrworker.services;

import java.util.List;

import br.com.estudo.microservices.hrworker.entities.Worker;

public interface WorkerService {
	List<Worker> buscarTodosWorkers();
	Worker buscarWorkerPorId(Long id);
}
