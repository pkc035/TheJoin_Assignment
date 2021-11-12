package test.fwd.service;

import java.util.List;

public interface FwdService {
	
	String addStringTest(String str) throws Exception;
	
	List<?> selectAll(FwdDefaultVO fwdVO) throws Exception;
	
	int selectListTotCnt(FwdDefaultVO fwdVO) throws Exception;
	
	FwdVO selectDetailTest(int boardId) throws Exception;
	
	void insertTest(FwdVO fwdvo) throws Exception;
	
	void updateTest(FwdVO fwdvo) throws Exception;
	
	void deleteTest(int boardId) throws Exception;
	
}
