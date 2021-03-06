package com.test.sp1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.sp1.entity.Result;
import com.test.sp1.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	private MovieService mService;

	@RequestMapping(value="/movies",method=RequestMethod.GET)
	public @ResponseBody Result getResult() {
		return mService.getResult();
	}
}
