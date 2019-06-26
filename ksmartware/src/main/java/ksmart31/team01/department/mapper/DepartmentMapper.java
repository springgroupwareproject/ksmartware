package ksmart31.team01.department.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ksmart31.team01.department.domain.Department;
import ksmart31.team01.department.domain.DepartmentJoinMember;
import ksmart31.team01.member.domain.Member;

@Mapper
public interface DepartmentMapper {
	//조직도 리스트
	public List<Department> selectDepartmentList();
	//department부서명과 member조직원 기본정보를 조인
	public List<DepartmentJoinMember> selectDepartmentJoinMemberList(Map<String, Object> map);
	// department부서명과 member조직원 기본정보를 조인(휴가 내역 출력용)
	public List<Member> selectDepartmentJoinMemberListForLeaveHistory(Map<String, Object> map);
	
}
