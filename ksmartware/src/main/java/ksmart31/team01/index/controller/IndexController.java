package ksmart31.team01.index.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ksmart31.team01.index.service.IndexService;
@Controller
public class IndexController {
	
	@Autowired private IndexService indexService;
	
	@GetMapping("/")
	public String index(HttpSession session, Model model){
	
	
		return "index";
	}
	

	
		
}
