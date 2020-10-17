package br.com.springboottests.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.springboottests.dto.UserDto;
import br.com.springboottests.entities.User;
import br.com.springboottests.repositories.UserRepository;
import br.com.springboottests.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDto save(UserDto dto) {
		repository.save(new User(dto));
		return dto;
	}
	
	@Override
	public List<UserDto> findAll(){
		List<UserDto> list = new ArrayList<UserDto>();
		repository.findAll().forEach(user -> list.add(new UserDto(user)));
		return list;
	}

}
