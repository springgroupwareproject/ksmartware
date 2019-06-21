package ksmart31.team02.document.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ksmart31.team02.document.mapper.DocumentFormMapper;
import ksmart31.team02.document.service.DocumentManagementService;
import ksmart31.team02.document.vo.ApprovalProcess;
import ksmart31.team02.document.vo.DocumentFormCategory;
import ksmart31.team02.document.vo.DraftDocument;

@Controller
public class DocumentManagementContorller {
	@Autowired private DocumentManagementService documentManagementService;
	@Autowired private DocumentFormMapper documentFormMapper;
	
	// 기안문서 조회(워크플로우 문서 관리)
	@GetMapping("/documentApprovalManagement")
	public String getDraftDocument(Model model) {
		System.out.println("(C) getDraftDocument() 실행");
		List<DraftDocument> list = documentManagementService.getDraftDocument();
		System.out.println("(C) getDraftDocument() list : "+list);
		model.addAttribute("list",list);
		return "admin/documentManagement/documentApprovalManagement";
	}
	
	// 관리자 결재선 관리(공통프로세스 목록)
	@GetMapping("/documentProcessManagement")
	public String getApprovalProcess(Model model) {
		System.out.println("(C) getApprovalProcess() 실행");
		List<ApprovalProcess> list = documentManagementService.getApprovalProcess();
		System.out.println("(C) getApprovalProcess() list : "+list);
		model.addAttribute("list",list);
		return "admin/documentManagement/documentProcessManagement";
	}
	
	// 공통양식 카테고리 목록
	@GetMapping("/documentFormManagement")
	public String getDocumentFormManagement(Model model) {
		System.out.println("(C) getDocumentFormManagement() 실행");
		List<DocumentFormCategory> list = documentFormMapper.selectDocumentFormCategory();
		System.out.println("(C) getDocumentFormManagement() list : "+list);
		model.addAttribute("list",list);
		return "admin/documentManagement/documentFormManagement";
	}
	
}
