package ksmart31.team03.leave.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class leaveMyPage {
	
	
	@GetMapping("/leaveMyPage")
	public String getleaveMyPage() {
		
		return "leave/leaveMyPage";
	}
}
