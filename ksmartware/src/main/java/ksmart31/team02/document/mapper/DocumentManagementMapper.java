package ksmart31.team02.document.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart31.team02.document.domain.ApprovalProcess;
import ksmart31.team02.document.domain.DocumentForm;
import ksmart31.team02.document.domain.DocumentFormCategory;
import ksmart31.team02.document.domain.DraftDocument;


@Mapper
public interface DocumentManagementMapper {
	// 기안문서 삭제
	public int deleteDraftDocument(DraftDocument draftDocument);
	
	// 기안문서 조회(워크플로우 문서 관리)
	public List<DraftDocument> selectDraftDocument();
	
	// 관리자 결재선 관리(공통프로세스 목록)
	public List<ApprovalProcess> selectApprovalProcess();

}
