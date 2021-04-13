package com.cognizant.springlearn;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.model.Skill;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@AutoConfigureMockMvc
@SpringBootTest
class SpringLearnApplicationTests {

	@Autowired
	private MockMvc mock;
	
	@Test
	void contextLoads() {
		assertThat(mock).isNotNull();
	}

	@Test
	public void testGetEmployees() throws Exception{
		this.mock.perform(get("/employees")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(content().contentType("application/json"))
				.andExpect(jsonPath("$[*]", hasSize(5)));
	}
	
	@Test
	public void testUpdateEmployee() throws Exception{
		Set<Skill> skill = new HashSet<>();
		skill.add(new Skill(3,"Python"));
		Employee emp = new Employee(5,"Michelle",15000.00,false,"1993-05-01",new Department(4,"Sales"),skill);
		
		ObjectMapper  mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow=mapper.writer().withDefaultPrettyPrinter();
		String requestJson=ow.writeValueAsString(emp);
		mock.perform(put("/update").contentType("application/json")
		.content(requestJson))
		.andExpect(status().isOk());

	}
}
