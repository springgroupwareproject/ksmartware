package ksmart31.team03.leave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart31.team03.leave.domain.LeaveCategory;
import ksmart31.team03.leave.domain.LeaveGrant;
import ksmart31.team03.leave.domain.LeaveHistory;
import ksmart31.team03.leave.mapper.LeaveCategoryMapper;
import ksmart31.team03.leave.mapper.LeaveGrantMapper;
import ksmart31.team03.leave.mapper.LeaveHistoryMapper;

@Service
@Transactional
public class LeaveMyPageService {
	@Autowired
	private LeaveCategoryMapper leaveCategoryMapper;
	
	@Autowired
	private LeaveHistoryMapper leaveHistoryMapper;
	
	@Autowired
	private LeaveGrantMapper leaveGrantMapper;
	
	// 카테고리 리스트 조회
	public List<LeaveCategory> getLeaveCategoryList(){
		return leaveCategoryMapper.selectLeaveCategoryList();
	}
	// 조직원 아이디별 휴가 내역 조회
	public List<LeaveHistory> getLeaveHistoryByMemberId(String memberId){
		return leaveHistoryMapper.selectLeaveHistoryByMemberId(memberId);
	}
	// 조직원 아이디별 휴가 부여 내역 조회
	
	public List<LeaveGrant> getLeaveGrantByMemberId(String memberId){
		return leaveGrantMapper.selectLeaveGrantByMemeberId(memberId);
	}
}
