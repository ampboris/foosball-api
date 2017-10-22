package com.wpc.foosball.foosball.resource;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.wpc.foosball.foosball.repository.FoosbalResultRepository;

@ComponentScan("com.wpc.foosball.foosball")
@RunWith(SpringJUnit4ClassRunner.class) 
public class FoosballControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	FoosballController controller;
	@Mock
	FoosbalResultRepository repo;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testPing() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/foosball/api"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string("api services are up and running"));
	}

	@Test
	public void testGetResults() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/foosball/api/results"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(jsonPath("$.*", Matchers.hasSize(0)));
	}

}
