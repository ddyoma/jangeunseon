package com.test.sp1.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.sp1.HomeController;
import com.test.sp1.entity.UserInfo;
import com.test.sp1.service.UserInfoService;

@Controller
public class UserInfoController {
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserInfoService uService;
	// UserInfoService userService = new UserInfoServiceImpl(); 이거이제안해

	
	
	//총셀렉트
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody List<UserInfo> getUserInfoList() { // responsebody는 제이슨형태로 사용하기위해 썼던거임

		List<UserInfo> ul = new ArrayList<>();
		ul = uService.getUserInfoList();

		log.debug("uiList=>{}", ul); // 컴마 우측에 있는것을 컴마좌측에 출력하고싶다면 {} 가 필수다 "uiList=>{},{}",ul,ul 이렇게 두개까지가능 이것만으로는
										// 출력불가 log4j.xml에서 레벨수정시 출력가능
		log.info("uiList=>{}", ul); // 콘솔창에 INFO : 하고 찎힐거임
		return ul;
	}
	
	

	//인서트
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public @ResponseBody Integer insertUser(@RequestBody UserInfo userInfo) { // json형태로 받고 json형태로 리턴 리퀘스트바디 리스폰스바디

		return uService.saveUserInfo(userInfo);
	}

	
	//부분셀렉트
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public @ResponseBody UserInfo getUserInfo(@RequestParam int uiNum) {
		log.debug("uiNum=" +uiNum);
		return uService.findUserInfo(uiNum);
	}
	
	
	//딜리트
	@RequestMapping(value = "/user/{uiNum}", method = RequestMethod.DELETE)
	public @ResponseBody Integer deleteUser(@PathVariable Integer uiNum) { //get,post말고 pathvariable로 하는법
		log.debug("uiNum=" +uiNum);
		return uService.deleteUserinfo(uiNum);
	}
	
	//업데이트
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public @ResponseBody Integer updateUser(@RequestBody UserInfo userInfo) {
		log.debug("유저정보" ,userInfo);
		return uService.updateUserInfo(userInfo);
	}
}
