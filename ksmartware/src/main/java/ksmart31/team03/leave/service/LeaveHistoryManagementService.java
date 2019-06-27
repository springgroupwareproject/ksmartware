package ksmart31.team03.leave.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart31.team01.department.domain.Department;
import ksmart31.team03.leave.domain.LeaveCategory;
import ksmart31.team03.leave.domain.LeaveHistory;
import ksmart31.team03.leave.mapper.LeaveCategoryMapper;
import ksmart31.team03.leave.mapper.LeaveHistoryMapper;

@Service
@Transactional
public class LeaveHistoryManagementService {
	@Autowired
	private LeaveCategoryMapper leaveCategoryMapper;
	
	@Autowired
	private LeaveHistoryMapper leaveHistoryMapper;
	
	//조직도 departmentView.html
	public Map<String, Object> getDepartmentList(String departmentName){
		//재귀쿼리 사용한 departmentName 조직도 조회 리스트
		List<Department> recursiveList = leaveHistoryMapper.selectDepartmentList();
		System.out.println("LeaveHistoryManagementService.getDepartmentList recursiveList : "+recursiveList);		
		// StringUtils.countMatches() -> departmentName중에 -가 포함되어있는 갯수를 보여준다
		int departmentNumber = StringUtils.countMatches(departmentName, "-"); 
		System.out.println("LeaveHistoryManagementService.getDepartmentList departmentNumber -갯수 : " + departmentNumber);
		// replaceAll()메서드로 -가 포함된문자열을 없애준다 		
		if(departmentName != null){	
			departmentName = departmentName.replaceAll("-","");
			System.out.println("LeaveHistoryManagementService.getDepartmentList departmentName -제거 확인 : " + departmentName);
		}
		// 2개 이상의 데이터를 하나로 넘기기 위해 HashMap 사용
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("departmentName", departmentName);
		map.put("departmentNumber", departmentNumber);
		// 특정 부서에 해당하는  memberId 조회(휴가 내역 출력용)
		String[] memberId = leaveHistoryMapper.selectDepartmentJoinMemberListForLeaveHistory(map);		
		System.out.println("LeaveHistoryManagementService.getDepartmentList memberId.length : "+memberId.length);
		// 최종 리턴 값을 담을 맵
		Map<String, Object> returnMap = new HashMap<String, Object>();
		// 최종 리턴 값 -조직도
		returnMap.put("recursiveList", recursiveList);		
		if(memberId.length > 0) {
			// String 배열 값 확인
			for (int i=0; i<memberId.length; i++) {
				System.out.println("LeaveHistoryManagementService.getDepartmentList memberId : "+memberId[i]);
			}
			// String 배열을 ArrayList에 담고 ArrayList를 HashMap에 담는다
			ArrayList<String> memberIdList = new ArrayList<String>();
			for(String item : memberId) {
				memberIdList.add(item);
			}
			System.out.println("LeaveHistoryManagementService.getDepartmentList memberIdList : "+memberIdList);
			Map<String, Object> memberIdMap = new HashMap<String, Object>();
			memberIdMap.put("memberIdList", memberIdList);
			System.out.println("LeaveHistoryManagementService.getDepartmentList memberIdMap : "+memberIdMap.get("memberIdList"));
			// 특정 부서에 해당하는 조직원 휴가 내역 조회
			List<LeaveHistory> leaveHistoryByMemberList = leaveHistoryMapper.selectLeaveHistoryByMemberList(memberIdMap);
			System.out.println("LeaveHistoryManagementService.getDepartmentList leaveHistoryByMemberList : "+leaveHistoryByMemberList);
			// 최종 리턴 값 - 휴가 내역 리스트
			returnMap.put("leaveHistoryByMemberList", leaveHistoryByMemberList);
		}
		return returnMap;
	}	
	
	// 카테고리 리스트 조회
	public List<LeaveCategory> getLeaveCategoryList(){
		return leaveCategoryMapper.selectLeaveCategoryList();
	}
	// 조직원 아이디별 휴가 내역 조회
	public List<LeaveHistory> getLeaveHistoryByMemberId(String memberId){
		return leaveHistoryMapper.selectLeaveHistoryByMemberId(memberId);
	}
}