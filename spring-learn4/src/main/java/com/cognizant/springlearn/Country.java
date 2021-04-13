package com.cognizant.springlearn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	
	@NotNull
	@Size(min=2, max=2, message="Country code should be 2 characters")
	private String code;
	
	private String name;
	public Country() {
		super();
		// TODO Auto-generated constructor stub
		LOGGER.info("Inside Country constructor");
	}
	public String getCode() {
		LOGGER.info("Inside code getter");
		return code;
	}
	public void setCode(String code) {
		LOGGER.info("Inside code setter");
		this.code = code;
	}
	public String getName() {
		LOGGER.info("Inside name getter");
		return name;
	}
	public void setName(String name) {
		LOGGER.info("Inside name setter");
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	
}
