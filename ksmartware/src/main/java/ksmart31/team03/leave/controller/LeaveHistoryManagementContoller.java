package ksmart31.team03.leave.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ksmart31.team03.leave.service.LeaveHistoryManagementService;

@Controller
public class LeaveHistoryManagementContoller {
	@Autowired
	private LeaveHistoryManagementService leaveHistoryManagementService;
	
	@GetMapping("/leave/leaveHistoryManagement")
	public String getleaveHistoryManagement(Model model, String departmentName) {
		System.out.println("LeaveHistoryManagementContoller.getleaveHistoryManagement [GET] departmentName : "+departmentName);
		Map<String,Object> returnMap = leaveHistoryManagementService.getDepartmentList(departmentName);	
		// 데이터를 html로 뿌려주기 위해 model로 묶는다
		model.addAttribute("recursiveList", returnMap.get("recursiveList"));		
		model.addAttribute("departmentJoinMemberList", returnMap.get("departmentJoinMemberList"));
		return "leave/leaveHistoryManagement";
	}
}
