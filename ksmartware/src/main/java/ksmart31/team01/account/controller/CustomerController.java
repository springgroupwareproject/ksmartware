package ksmart31.team01.account.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ksmart31.team01.account.service.CustomerService;
import ksmart31.team01.member.domain.Customer;


@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	//customer 리스트
	@GetMapping(value="/customerListView")
	public String getCustomerList(Model model){
		List<Customer> customerList = customerService.getCustomerList();
		System.out.println(customerList + "CustomerController getCustomerList [get] customerList");
		model.addAttribute("customerList", customerList);
		return "accounting/customerListView";		
	}	
}
