package br.com.estudo.microservices.hruser.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.estudo.microservices.hruser.entities.User;
import br.com.estudo.microservices.hruser.repositories.UserRepository;
import br.com.estudo.microservices.hruser.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository repository;
	
	@Autowired
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public User buscarUserPorEmail(String email) {
		return this.repository.findByEmail(email)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado com o email: "+email)	);
	}

	@Override
	public User buscarUserPorId(Long id) {
		return this.repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado com o email: "+id)	);
	}
}
