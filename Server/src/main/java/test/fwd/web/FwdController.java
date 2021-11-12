package test.fwd.web;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.BatchResponse;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.MulticastMessage;
import com.google.firebase.messaging.SendResponse;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import test.fwd.service.FwdDefaultVO;
import test.fwd.service.FwdService;
import test.fwd.service.FwdVO;
import test.fwd.service.SampleDefaultVO;
import test.fwd.service.FcmService;

@Controller
public class FwdController {
	
	@Resource(name = "FcmService")
	private FcmService FcmService;
	
	@Resource(name = "FwdService")
	private FwdService FwdService;
	
	@RequestMapping(value="/mainTest.do", method = RequestMethod.GET)
	public String mainTest(@RequestParam(value="pageIndex", required=false, defaultValue="1") int pageIndex
			, FwdDefaultVO searchVO, ModelMap model) throws Exception {
	
		System.out.println("FwdController.java - mainTest()");
		
		searchVO.setPageUnit(searchVO.getPageUnit());
		searchVO.setPageSize(searchVO.getPageSize());
		
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(pageIndex);
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
		
		List<?> list = FwdService.selectAll(searchVO);
		model.addAttribute("resultList", list);
		
		int totCnt = FwdService.selectListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);
		
		return "test/hello";
	}
	
	@RequestMapping(value="/{board_id}/detailTest.do", method = RequestMethod.GET)
	public String selectDetailTest(@PathVariable("board_id") int board_id, ModelMap model) throws Exception {
		System.out.println("FwdController.java - selectDetailTest()");
		FwdVO fwdvo = FwdService.selectDetailTest(board_id);
		model.addAttribute("board", fwdvo);
		
		return "test/detail";
	}
	
	@RequestMapping(value="/insertTest.do", method = RequestMethod.POST)
	public String insertTest(FwdVO fwdvo,ModelMap model) throws Exception {
		System.out.println("FwdController.java - insertTest()");
		FwdService.insertTest(fwdvo);
		
		return "redirect:mainTest.do";
	}
	
	@RequestMapping(value="/writeTest.do")
	public String writeTest(ModelMap model) throws Exception {
		System.out.println("FwdController.java - writeTest()");
		
		return "test/register";
	}
	
	@RequestMapping(value="/{board_id}/updateTest.do", method = RequestMethod.POST)
	public String updateTest(FwdVO fwdvo) throws Exception {
		System.out.println("FwdController.java - updateTest()");
		FwdService.updateTest(fwdvo);
		FcmService.sendTest("Update");
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/{board_id}/deleteTest.do", method = RequestMethod.POST)
	public String deleteTest(@PathVariable("board_id") int board_id) throws Exception {
		System.out.println("FwdController.java - deleteTest()");
		FwdService.deleteTest(board_id);
		FcmService.sendTest("Delete");
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/testTest.do")
	public String testTest(@RequestParam(value="pageIndex", required=false, defaultValue="1") int pageIndex, @ModelAttribute("searchVO") FwdDefaultVO searchVO, ModelMap model) throws Exception {
		System.out.println("FwdController.java - testTest()");
		
		return "test/test";
	}
	
}
