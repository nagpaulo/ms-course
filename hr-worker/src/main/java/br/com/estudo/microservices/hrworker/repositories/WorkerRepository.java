package br.com.estudo.microservices.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.estudo.microservices.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
