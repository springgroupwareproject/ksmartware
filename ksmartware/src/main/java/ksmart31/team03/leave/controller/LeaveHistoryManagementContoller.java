package ksmart31.team03.leave.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ksmart31.team01.member.domain.Member;
import ksmart31.team03.leave.domain.LeaveCategory;
import ksmart31.team03.leave.domain.LeaveHistory;
import ksmart31.team03.leave.service.LeaveHistoryManagementService;

@Controller
public class LeaveHistoryManagementContoller {
	@Autowired
	private LeaveHistoryManagementService leaveHistoryManagementService;
	
	@GetMapping("/leave/leaveHistoryManagement")
	public String getleaveHistoryManagement(HttpSession session, Model model, String departmentName) {
		Member loginMember = (Member) session.getAttribute("loginMember");
		System.out.println("LeaveHistoryManagementContoller.getleaveHistoryManagement [GET] departmentName : "+departmentName);
		if(loginMember == null) {
			return "redirect:"+"/login";
		}else {
			// 조직도
			Map<String,Object> returnMap = leaveHistoryManagementService.getDepartmentList(departmentName);	
			// 휴가 카테고리 리스트 조회
			List<LeaveCategory> leaveCategoryList = leaveHistoryManagementService.getLeaveCategoryList();
			System.out.println("LeaveHistoryManagementContoller.getleaveHistoryManagement [GET] leaveCategoryList : "+leaveCategoryList);
			// 조직원 아이디별 휴가 내역 조회
			List<LeaveHistory> leaveHistoryList = leaveHistoryManagementService.getLeaveHistoryByMemberId(loginMember.getMemberId());
			System.out.println("LeaveHistoryManagementContoller.getleaveHistoryManagement [GET] leaveHistoryList : "+leaveHistoryList);
			
			model.addAttribute("recursiveList", returnMap.get("recursiveList"));		
			model.addAttribute("departmentJoinMemberList", returnMap.get("departmentJoinMemberList"));
			model.addAttribute("leaveCategoryList", leaveCategoryList);
			model.addAttribute("leaveHistoryList", leaveHistoryList);
		
			return "leave/leaveHistoryManagement";
		}
	}
}
