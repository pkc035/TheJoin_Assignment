package test.fwd.service.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
import test.fwd.service.FwdDefaultVO;
import test.fwd.service.FwdVO;
import test.fwd.service.SampleDefaultVO;

@Repository("FwdDAO")
public class FwdDAO extends EgovAbstractDAO{
	
	public List<?> selectAll(FwdDefaultVO vo) throws Exception{
		System.out.println("FwdDAO.java - selectAll()");
		return list("FwdDAO.selectAll", vo);
	}

	public int selectListTotCnt(FwdDefaultVO vo) {
		System.out.println("FwdDAO.java - selectListTotCnt()");
		return (Integer) select("FwdDAO.selectListTotCnt", vo);
	}

	public FwdVO selectDetailTest(int boardId) {
		System.out.println("FwdDAO.java - selectDetailTest()");
		return (FwdVO)select("FwdDAO.selectDetailTest", boardId);
	}
	
	public void insertTest(FwdVO vo) throws Exception{
		System.out.println("FwdDAO.java - insertTest()");
		insert("FwdDAO.insertTest", vo);
	}
	
	public void updateTest(FwdVO vo) throws Exception{
		System.out.println("FwdDAO.java - updateTest()");
		update("FwdDAO.updateTest", vo);
	}

	public void deleteTest(int boardId) throws Exception{
		System.out.println("FwdDAO.java - deleteTest()");
		delete("FwdDAO.deleteTest",boardId);
	}
}