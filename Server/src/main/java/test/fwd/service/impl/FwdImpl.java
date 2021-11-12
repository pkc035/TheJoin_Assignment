package test.fwd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import test.fwd.service.FwdDefaultVO;
import test.fwd.service.FwdService;
import test.fwd.service.FwdVO;

@Service("FwdService")
public class FwdImpl extends EgovAbstractServiceImpl implements FwdService{
	
	@Override
	public String addStringTest(String str) throws Exception {
		System.out.println("FwdImpl.java - addStringTest()");
		
		return str + " -> FwdImpl ";
		
	}
	
	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;
	
	@Resource(name="FwdDAO")
	private FwdDAO dao;

	@Override
	public List<?> selectAll(FwdDefaultVO fwdVO) throws Exception {
		
		System.out.println("FwdImpl.java - selectAll()");
		return dao.selectAll(fwdVO);
	}

	@Override
	public int selectListTotCnt(FwdDefaultVO fwdVO) {
		System.out.println("FwdImpl.java - selectListToCnt()");
		return dao.selectListTotCnt(fwdVO);
	}

	@Override
	public FwdVO selectDetailTest(int boardId) throws Exception {
		System.out.println("FwdImpl.java - selectDetailTest()");
		return dao.selectDetailTest(boardId);
	}
	
	@Override
	public void insertTest(FwdVO fwdvo) throws Exception {
		System.out.println("FwdImpl.java - insertTest()");
		dao.insertTest(fwdvo);
	}

	@Override
	public void updateTest(FwdVO fwdvo) throws Exception {
		System.out.println("FwdImpl.java - updateTest()");
		dao.updateTest(fwdvo);
	}

	@Override
	public void deleteTest(int boardId) throws Exception {
		System.out.println("FwdImpl.java - deleteTest()");
		dao.deleteTest(boardId);
		
	}

}
