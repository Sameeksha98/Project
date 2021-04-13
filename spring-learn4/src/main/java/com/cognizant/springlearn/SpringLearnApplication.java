package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	public static void main(String[] args) {
		LOGGER.info("START MAIN");
		SpringApplication.run(SpringLearnApplication.class, args);
		LOGGER.info("STOP MAIN");
//		SpringLearnApplication sla = new SpringLearnApplication();
//		sla.displayDate();
//		sla.displayCountry();
//		sla.displayCountries();
	}
	
	
	
	
	public void displayDate() {
		LOGGER.info("START Display Date method");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		String dateString = "31/12/2018";
		try {
			Date date = format.parse(dateString);
			System.out.println(date);
			//LOGGER.debug(dateString);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			LOGGER.info("END Display Date method");
		}
	}

	public void displayCountry() {
		LOGGER.info("Start displayCountry method");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = (Country) context.getBean("country", Country.class);
		
		Country anotherCountry = context.getBean("country", Country.class);
		
		LOGGER.debug("Country : {}", country.toString());
		
		LOGGER.info("Stop displayCountry method");
	}
	
	public void displayCountries() {
		LOGGER.info("Start displayCountries method");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		ArrayList<Country> country = (ArrayList<Country>) context.getBean("countryList");
		
		LOGGER.debug("Country : {}", country.toString());
		LOGGER.info("Stop displayCountries method");
	}
}
