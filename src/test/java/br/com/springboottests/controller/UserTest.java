package br.com.springboottests.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.springboottests.controllers.UserController;
import br.com.springboottests.dto.UserDto;
import br.com.springboottests.entities.User;
import br.com.springboottests.repositories.UserRepository;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserTest {

	private MockMvc mockMvc;

	private ObjectMapper objectMapper;
	
	@MockBean
	private UserRepository repository;
	
	@Autowired
	private UserController controller;
	
    @Before
    public void setUp() {
        objectMapper = new ObjectMapper();
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
		
	@Test
	@SuppressWarnings("deprecation")
	public void mustSaveNewUser() throws Exception {
		
		User mockUser = new User(new UserDto(99L, "User created with mockito"));
		Mockito.when(repository.save(null)).thenReturn(mockUser);
		
		MockHttpServletRequestBuilder requestBuilder = post("/user")
				.content(objectMapper.writeValueAsString(new UserDto(1L, "user test")))
				.contentType(MediaType.APPLICATION_JSON_UTF8);
		
		mockMvc.perform(requestBuilder).andExpect(status().isOk());
		
	}
	
}
