package br.com.estudo.microservices.oauth.services;

import br.com.estudo.microservices.oauth.entities.User;

public interface UserService {
	User buscarUserPorEmail(String email);
}
