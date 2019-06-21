package ksmart31.team01.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart31.team01.account.mapper.CustomerMapper;
import ksmart31.team01.member.domain.Customer;



@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	public List<Customer> getCustomerList(){
		//customer 리스트
		List<Customer> list = customerMapper.selectCustomerList();
		System.out.println(list + "CustomerService getCustomerList list");
		return list;
	}
}
