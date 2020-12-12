package com.cenfotec.examen3Graphql.services;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

import com.cenfotec.examen3Graphql.entities.Customer;
import com.cenfotec.examen3Graphql.repositories.CustomerRepository;
import com.cenfotec.examen3Graphql.services.CustomerService;

import javassist.NotFoundException;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepo;

	public List<Customer> getAllCustomers(int count) {
		return this.customerRepo.findAll().stream().limit(count).collect(Collectors.toList());
	}

	public Optional<Customer> getCustomer(int id) {
		return this.customerRepo.findById(id);
	}

	public Customer createCustomer(String fullName, String address, String billingAddress, String cardNumber, String expDate,String expDate2) {

		Customer customer = new Customer();
		customer.setName(fullName);
		customer.setLast(address);
		customer.setAddress(billingAddress);
		customer.setCardNumber(cardNumber);
		customer.setMonthNumber(expDate);
		customer.setYearNumber(expDate2);
		return this.customerRepo.save(customer);
	}

	public Boolean deleteCustomer(int id) {
		customerRepo.deleteById(id);
		return true;
	}
	
	public Customer updateCustomer(String id, String fullName, String address, String billingAddress, String cardNumber, String expDate,String expDate2) throws NotFoundException {
	    Optional<Customer> opCustomer = customerRepo.findById(Integer.parseInt(id));

	    if (opCustomer.isPresent()) {
	    	Customer cx = opCustomer.get();

	      if (fullName != null)
	    	  cx.setName(fullName);
	      if (address != null)
	    	  cx.setAddress(address);

	      customerRepo.save(cx);
	      return cx;
	    }
	    throw new NotFoundException("Customer not found");
	  }
}
