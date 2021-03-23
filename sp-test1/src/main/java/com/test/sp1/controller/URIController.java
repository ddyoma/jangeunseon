package com.test.sp1.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/views") //value를 생략해도 무방함. get도 post아니니까 url패턴만쓰고싶으니가
public class URIController {
	
	@RequestMapping(value="/views/**", method = RequestMethod.GET)
	public void goPage(HttpServletRequest request) {
		
		//기존에 스트링으로했을때 리턴값return request.getRequestURI().substring(7); //스트링에 리퀘스트바리 안붙으니 프리픽스 사픽스붙으
	}

}
