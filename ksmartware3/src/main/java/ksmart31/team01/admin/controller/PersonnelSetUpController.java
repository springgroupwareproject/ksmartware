package ksmart31.team01.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonnelSetUpController {

	@GetMapping("/personnelSetUpView")
	public String personnelSetUp(){
		System.out.println("PersonnelSetUpController.personnelSetUp 인사 정보 설정 실행");
		return "personnelSetUpView";
	}
	
}
