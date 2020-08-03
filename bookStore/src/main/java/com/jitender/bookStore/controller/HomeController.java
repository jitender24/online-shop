package com.jitender.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jitender.bookStore.dao.BookDAO;
import com.jitender.bookStore.dao.CategoryDAO;
import com.jitender.bookStore.model.Book;

@Controller
public class HomeController {

	@Autowired
	private CategoryDAO categoryDao;

	@Autowired
	private BookDAO bookDao;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("categories", categoryDao.categoryList());
		mv.addObject("Books", bookDao.homePageBooks());
		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		
		System.out.println("ABOUT PAGE LOADED");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		
		System.out.println("CONTACT PAGE LOADED");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

}
