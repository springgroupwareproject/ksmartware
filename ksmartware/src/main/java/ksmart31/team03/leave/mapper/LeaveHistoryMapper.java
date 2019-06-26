package ksmart31.team03.leave.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart31.team03.leave.domain.LeaveHistory;

@Mapper
public interface LeaveHistoryMapper {
	// 조직원 아이디별 휴가 내역 조회
	public List<LeaveHistory> selectLeaveHistoryByMemberId(String memberId);
}
