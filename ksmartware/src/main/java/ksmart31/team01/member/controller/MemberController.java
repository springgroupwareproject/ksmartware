package ksmart31.team01.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import ksmart31.team01.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired private MemberService memberService;
	
}
