package br.com.estudo.microservices.oauth.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.microservices.oauth.entities.User;
import br.com.estudo.microservices.oauth.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {

	private UserService service;
	
	@Autowired
	public UserResource(UserService service) {
		this.service = service;
	}
	
	@GetMapping("/search")
	public User buscarUserPorEmail(String email) {
		return this.service.buscarUserPorEmail(email);
	}
}
