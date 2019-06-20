package ksmart31.common.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping(value = { "/", "/index" })
	public String index(HttpSession session, Model model) {
		System.out.println("IndexController.index()");
		return "index";
	}
	
}
