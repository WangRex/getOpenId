package com.getOpenId.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.getOpenId.service.IUserService;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private IUserService service;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String loginPage(HttpServletResponse response) {
		
		try {
			service.getUserById(9);
			response.setCharacterEncoding("UTF-8");
			return "index";
		} catch (BeansException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
