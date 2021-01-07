package br.com.estudo.microservices.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.estudo.microservices.hruser.entities.User;
import br.com.estudo.microservices.hruser.services.UserService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserResource {
		
	@Autowired
	private UserService service;
	
	@GetMapping("{id}")
	public User buscarUserPorId(@PathVariable Long id) {
		log.info("Procurando usuario por id ${id}");
		return this.service.buscarUserPorId(id);
	}
	
	@GetMapping("/search")
	public User buscarUserPorEmail(@RequestParam String email) {
		log.info("Procurando usuario pelo email ${email}");
		return this.service.buscarUserPorEmail(email);
	}
}
