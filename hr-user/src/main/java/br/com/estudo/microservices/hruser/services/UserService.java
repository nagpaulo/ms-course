package br.com.estudo.microservices.hruser.services;

import br.com.estudo.microservices.hruser.entities.User;

public interface UserService {
	User buscarUserPorEmail(String email);	
	User buscarUserPorId(Long id);
}
