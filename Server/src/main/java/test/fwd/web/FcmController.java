package test.fwd.web;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import test.fwd.service.FcmService;

@Controller
public class FcmController {
	
	@Resource(name = "FcmService")
	private FcmService FcmService;
	
	@PostConstruct
	private void initTest() throws Exception{
		
		FcmService.init();
		System.out.println("FwdController.java - initTest()");
		
	}
	
	@RequestMapping(value = "/push.do")
	public void pushTest() throws Exception{
//		FcmService.sendTest("Test");
		System.out.println("FwdController.java - sendTest()");
	}
	
	@RequestMapping(value="/fcmTest.do", method=RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public void fcmTest() throws Exception{
	}
	
}
