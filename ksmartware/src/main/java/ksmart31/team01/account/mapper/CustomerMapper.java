package ksmart31.team01.account.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart31.team01.member.domain.Customer;



@Mapper
public interface CustomerMapper {
	//customer 리스트
	public List<Customer> selectCustomerList();
	
}
