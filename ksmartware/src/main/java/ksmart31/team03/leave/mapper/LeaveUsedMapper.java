package ksmart31.team03.leave.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart31.team03.leave.domain.LeaveUsed;

@Mapper
public interface LeaveUsedMapper {
	// 조직원 아이디별 휴가 사용 내역 조회
	public List<LeaveUsed> selectLeaveUsedByMemberId(String memberId);
}
