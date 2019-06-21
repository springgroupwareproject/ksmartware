package ksmart31.team01.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart31.team01.account.mapper.AccountMapper;
import ksmart31.team01.member.domain.Account;



@Service
@Transactional
public class AccountService {
	@Autowired
	private AccountMapper accountMapper;
	//Account리스트
	public List<Account> getAccountList(){
		List<Account> list = accountMapper.selectAccountList();
		System.out.println(list + "AccountService getAccountList list");
		return list;
	}
}
