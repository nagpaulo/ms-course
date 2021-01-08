package br.com.estudo.microservices.oauth.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.estudo.microservices.oauth.entities.User;
import br.com.estudo.microservices.oauth.feignclients.UserFeignClient;
import br.com.estudo.microservices.oauth.services.UserService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserFeignClient userFeignClient;

	@Override
	public User buscarUserPorEmail(String email) {
		log.info("Pesquisando Oauth Users");
		Optional<User> user = Optional.of(this.userFeignClient.buscarUserPorEmail(email));
		return user.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não encontrado!"));
	}
}
