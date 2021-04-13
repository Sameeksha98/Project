package com.cognizant.springlearn;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.springlearn.Controller.CountryController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultActions;

@AutoConfigureMockMvc
@SpringBootTest
class SpringLearnApplicationTests {

	@Autowired
	private CountryController countryController;
	
	@Autowired
	private MockMvc mvc;
	
	
	
	@Test
	void contextLoads() {
		assertNotNull(countryController);
	}
	
	@Test
	public void getCountry() throws Exception {

		ResultActions actions = mvc.perform(get("/country"));
	
		actions.andExpect(status().isOk());
	
		actions.andExpect(jsonPath("$.code").exists());
		actions.andExpect(jsonPath("$.code").value("IN"));

	}
	
	@Test
	public void testGetCountryException() throws Exception {

		ResultActions actions = mvc.perform(get("/country"));
	
		actions.andExpect(status().isBadRequest());

		actions.andExpect(jsonPath("$.code").exists());
		actions.andExpect(jsonPath("$.code").value("AZ"));

		actions.andExpect(status().reason("Country Not found"));
		
		
	

	}

}
