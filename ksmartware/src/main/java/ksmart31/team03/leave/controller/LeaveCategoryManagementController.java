package ksmart31.team03.leave.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart31.team03.leave.domain.LeaveCategory;
import ksmart31.team03.leave.service.LeaveCategoryManagementService;

@Controller
public class LeaveCategoryManagementController {
	@Autowired
	private LeaveCategoryManagementService leaveCategoryManagementService;
	
	@GetMapping("/leaveCategoryManagement")
	public String getleaveCategoryManagement(Model model, @RequestParam(required = false) String leaveCategoryCode) {
		List<LeaveCategory> categoryList = leaveCategoryManagementService.getLeaveCategoryList();
		System.out.println("LeaveCategoryController.leaveCategoryManagement [GET] list : "+categoryList);
		model.addAttribute("leaveCategoryList", categoryList);
		
		System.out.println("LeaveCategoryController.getleaveCategoryManagement [GET] leaveCategoryCode : "+leaveCategoryCode);
		Map<String, Object> map = new HashMap<String, Object>();
		if(leaveCategoryCode != null) {
			map =  leaveCategoryManagementService.getLeaveDetailAndPolicyList(leaveCategoryCode);
		}
		model.addAttribute("resultMap", map);
		System.out.println("LeaveCategoryController.getleaveCategoryManagement [GET] model : "+model);
		return "leave/leaveCategoryManagement";
	}
	
	
}
