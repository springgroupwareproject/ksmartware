package ksmart31.team01.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart31.team01.member.mapper.MemberMapper;

@Service
@Transactional
public class MemberService {

	@Autowired private MemberMapper memberMapper;
	
	
}
