package br.com.springboottests.dto;

import br.com.springboottests.entities.User;

public class UserDto {

	private Long id;
	private String name;
	
	public UserDto() {}
	
	public UserDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public UserDto(User u) {
		this.id = u.getId();
		this.name = u.getName();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
}
