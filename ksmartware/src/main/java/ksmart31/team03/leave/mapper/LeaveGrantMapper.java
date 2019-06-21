package ksmart31.team03.leave.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart31.team03.leave.domain.LeaveGrant;

@Mapper
public interface LeaveGrantMapper {
	// 조직원 아이디별 휴가 부여 내역 조회
	public List<LeaveGrant> selectLeaveGrantByMemeberId(String memberId);
}
