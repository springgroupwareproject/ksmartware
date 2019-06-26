package ksmart31.team01.accounting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ksmart31.team01.accounting.service.CustomerService;
import ksmart31.team01.accounting.domain.Customer;

@RestController
public class RestCustomerController {
	@Autowired
	private CustomerService customerService;
	//customer 리스트
	@GetMapping(value="/getCustomer")
	public List<Customer> getCustomer(){
		List<Customer> customerList = customerService.getCustomerList();
		System.out.println(customerList +"RestCustomerController getCustomer customerList");
		return customerList;
	}
	@PostMapping(value="/addCustomer")
	public void addCustomer(Customer customer){
		System.out.println("/addCustomer 요청");
		System.out.println(customer + "RestCustomerController.java addCustomer customer");
		customerService.addCustomer(customer);
	}	
}
