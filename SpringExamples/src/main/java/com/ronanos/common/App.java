package com.ronanos.common;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ronanos.customer.dao.CustomerDAO;
import com.ronanos.customer.model.Customer;
import com.ronanos.output.IOutputGenerator;
import com.ronanos.output.OutputHelper;
import com.ronanos.output.SpringOutputHelper;
import com.ronanos.output.impl.CsvOutputGenerator;


/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "Hello World from System out" );
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring-Module.xml");

		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		obj.printHello();

		CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
		Customer customer = new Customer(1, "ronanos",40);

		Customer customer1 = customerDAO.findByCustomerId(1);
		if (customer1 == null) {
			customerDAO.insert(customer);	
			customer1 = customerDAO.findByCustomerId(1);
		}

		if (customer1 != null) {
			System.out.println(customer1);
		}


		//		CustomerDAO customerDAOtemplate = (CustomerDAO) context.getBean("customerDAOtemplate");
		//		Customer newCustomer = new Customer(3, "ronanos",40);
		//
		//		Customer customer2 = customerDAOtemplate.findByCustomerId(3);
		//		if (customer2 == null) {
		//			customerDAOtemplate.insert(newCustomer);	
		//			customer2 = customerDAO.findByCustomerId(3);
		//		}
		//
		//		if (customer2 != null) {
		//			System.out.println(customer2);
		//		}
		//		

		// Direct call
		// Tightly coupled
		IOutputGenerator output = new CsvOutputGenerator();
		output.generateOutput();

		// Helper class
		// less coupled but still coupled
		OutputHelper outputHelper = new OutputHelper();
		outputHelper.generateOutput(); 


		// Spring
		// Use Dependency Injection which only involves changing the XML file.
		ApplicationContext context2 = 
				new ClassPathXmlApplicationContext(new String[] {"Spring-Common.xml"});

		SpringOutputHelper output2 = (SpringOutputHelper)context2.getBean("SpringOutputHelper");
		output2.generateOutput();

	}
}
