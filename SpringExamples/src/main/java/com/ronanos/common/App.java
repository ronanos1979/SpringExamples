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
	}
}
