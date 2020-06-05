package com.jitender.bookStore.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ManagementController {
	
	
    @RequestMapping(value = "/manage/book")
	public ModelAndView singleBook() {
    	System.out.println("Single Book page Loaded");
    	ModelAndView mv = new ModelAndView("page");
    	mv.addObject("title","Manage Book");
    	mv.addObject("userClickManageBook", true);
		return mv;
	}

}
