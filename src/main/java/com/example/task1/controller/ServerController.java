package com.example.task1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.task1.model.Server;
import com.example.task1.repository.ServerRepository;

@RestController
public class ServerController {

	@Autowired
	private ServerRepository repository;
	
	@PostMapping("/server")
	public String addServer(@RequestBody Server server) {
		repository.save(server);
		return "server added to collection";
	}
	
	@GetMapping("/server/{name}")
	public List<Server> getAllServer(@PathVariable String name) {
		
		List<Server>result = new ArrayList<>();
		for(Server server : repository.findAll()) {
			if(server.getName().contains(name)) {
				result.add(server);
			}
		}
		return result;
	}
	
	@DeleteMapping("/server/{id}")
	public String deleteServer(@PathVariable String id) {
		repository.deleteById(id);
		return "server deleted from collection";
	}
	
	@GetMapping("/server/all")
	public List<Server> getServer() {
		return repository.findAll();
	}
}
