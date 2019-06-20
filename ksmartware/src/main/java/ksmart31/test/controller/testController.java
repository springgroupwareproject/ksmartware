package ksmart31.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {

	@GetMapping(value = "/test")
	public String index() {
		System.out.println("IndexController.index()");
		return "test";
	}
		
	@GetMapping(value = "/calendar")
	public String calendar() {
		System.out.println("IndexController.calendar()");
		return "/pages/calendar";
	}	
			
	@GetMapping("/layouts")
	public String layouts(){
		
		return "pages/layouts";
	}
}