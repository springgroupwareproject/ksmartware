package ksmart31.team01.member.mapper;

import org.apache.ibatis.annotations.Mapper;

import ksmart31.team01.member.vo.Member;

@Mapper
public interface MemberLoginMapper {
	public Member selectMemberForLogin(Member member); //로그인 처리를 위한 회원 정보 조회




}
