package com.cognizant.springlearn.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.GlobalExceptionHandler;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;


@RestController
@RequestMapping("/countries")
public class CountryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	CountryService countryService;
	//Hands-on 4
	
	/*
	@PostMapping("/countries")
	public void addCountry(@RequestBody Country country) {
		LOGGER.info("START POST METHOD addCountry");
		LOGGER.debug("Country:",country);
		LOGGER.info("STOP POST METHOD addCountry");
	}
	*/
	
	@PostMapping("/add")
	public Country addCountry(@RequestBody @Valid Country country){
		LOGGER.info("START POST METHOD addCountry");
		
		//LOGGER.debug("Country:",country);
		
		
		// Create validator factory
/*
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

		Validator validator = factory.getValidator();

		// Validation is done against the annotations defined in country bean

		Set<ConstraintViolation<Country>> violations = validator.validate(country);

		List<String> errors = new ArrayList<String>();

		// Accumulate all errors in an ArrayList of type String

		for (ConstraintViolation<Country> violation : violations) {

			errors.add(violation.getMessage());
		}

		// Throw exception so that the user of this web service receives appropriate error message

		if (violations.size() > 0) {

		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());

		}*/
		LOGGER.info("STOP POST METHOD addCountry");
		return country;
		
	}
	//Hands-on 2
	@RequestMapping("/country")
	public Country getCountryIndia() {
		LOGGER.info("START getCountryIndia method");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = (Country) context.getBean("in");
		
		LOGGER.info("STOP getCountryIndia method");
		return country;
		
	}
	
	
	@GetMapping
	public ArrayList<Country> getAllCountries() {
		
		LOGGER.info("START getAllCountries method");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		ArrayList<Country> country = (ArrayList<Country>) context.getBean("countryList");
		
		LOGGER.info("STOP getAllCountries method");
		return country;
		
	}
	
	@GetMapping("/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.info("START getCountry method");
		
		
		
		Country country = countryService.getCountry(code);
		
		LOGGER.info("STOP getCountry method");
		
		return country;
		
	}
}
