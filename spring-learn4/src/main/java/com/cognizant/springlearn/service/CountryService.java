package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	public Country getCountry(String code) throws CountryNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		ArrayList<Country> country = (ArrayList<Country>) context.getBean("countryList");
		
		Country codeCountry = null;
		
		
		for(Country c : country) {
			
			if(c.getCode().equals(code)) {
				codeCountry = c;
			}
		}
		
		if(codeCountry == null) {
			throw new CountryNotFoundException();
		}
		
		return codeCountry;
		
	}
}
