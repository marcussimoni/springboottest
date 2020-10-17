package br.com.springboottests.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.springboottests.dto.UserDto;

@Entity
@Table(name = "TB_USER")
@SequenceGenerator(name = "SQ_USER", sequenceName = "SQ_USER", allocationSize = 1, initialValue = 1)
public class User implements Serializable {

	private static final long serialVersionUID = -8760672024727260324L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "SQ_USER")
	private Long id;
	
	@Column(name = "NAME")
	private String name;

	public User() {}
	
	public User(UserDto dto) {
		id = dto.getId();
		name = dto.getName();
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
