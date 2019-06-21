package ksmart31.team01.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ksmart31.team01.account.service.AccountService;
import ksmart31.team01.member.domain.Account;


@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	//account 리스트
	@GetMapping(value="/accountListView")
	public String getAccountList(Model model){
		List<Account> list = accountService.getAccountList();
		System.out.println(list + "AccountController getAccountList [get] list");
		model.addAttribute("accountList", list);
		return "accounting/accountListView";
	}
	
}
