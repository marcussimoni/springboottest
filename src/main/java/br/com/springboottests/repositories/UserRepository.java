package br.com.springboottests.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.springboottests.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
}
