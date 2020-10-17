package br.com.springboottests.services;

import java.util.List;

import br.com.springboottests.dto.UserDto;

public interface UserService {

	UserDto save(UserDto dto);

	List<UserDto> findAll();
	
}
