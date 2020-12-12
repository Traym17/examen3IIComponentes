package com.cenfotec.examen3Graphql.mutation;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cenfotec.examen3Graphql.entities.Customer;
import com.cenfotec.examen3Graphql.services.CustomerService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import javassist.NotFoundException;

@Component
public class CustomerMutation implements GraphQLMutationResolver {

	@Autowired
	private CustomerService customerService;

	public Customer createCustomer(String name, String last, String address, String cardNumber, String monthNumber, String yearNumber) {
	 return this.customerService.createCustomer(name, last,
			 address, cardNumber, monthNumber,yearNumber);
	}
	
	 public boolean deleteCustomer(int id) {
		 customerService.deleteCustomer(id);
		 return true;
	}
	 
	 public Customer updateCustomer(String id, String name, String last, String address, String cardNumber, String monthNumber, String yearNumber) throws NotFoundException {
	    	 return this.customerService.updateCustomer(id, name, last,
	    			 address, cardNumber, monthNumber,yearNumber);
	    }

}
