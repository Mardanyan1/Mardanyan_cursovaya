package com.Mardanyan.Zooshop;

import com.Mardanyan.Zooshop.controllers.MainController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ZooshopApplicationTests
{
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private MainController controller;

	@Test
	public void contextLoads() throws Exception
	{
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Подробнее")));
	}

	@Test
	public void accessDeniedTest() throws Exception
	{
		this.mockMvc.perform(get("/admin/user"))
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("http://localhost/login"));
	}

	@Test
	public void correctLoginTest() throws Exception
	{
		this.mockMvc.perform(SecurityMockMvcRequestBuilders.formLogin().user("super").password("super"))
				.andDo(print())
				.andExpect(status().is3xxRedirection())
				.andExpect(redirectedUrl("/"));
	}

	@Test
	public void badCredentials() throws Exception
	{
		this.mockMvc.perform(post("/login").param("super","super"))
				.andDo(print())
				.andExpect(status().isForbidden());
	}
}
