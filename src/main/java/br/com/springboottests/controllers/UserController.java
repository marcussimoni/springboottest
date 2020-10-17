package br.com.springboottests.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboottests.dto.UserDto;
import br.com.springboottests.services.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserDto save(@RequestBody UserDto dto) {
		return service.save(dto);
	}
	
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDto> findAll(){
		return service.findAll();
	}
	
}
