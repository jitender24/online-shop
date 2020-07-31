package com.jitender.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jitender.bookStore.dao.BookDAO;
import com.jitender.bookStore.dao.CategoryDAO;
import com.jitender.bookStore.model.Book;



@Controller
public class PageController {
	
	@Autowired
	private CategoryDAO categoryDao;
	@Autowired
	private BookDAO bookDao;
	
	public PageController() {
		System.out.println("PageController()");
	}
    @RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index() {
    	ModelAndView mv = new ModelAndView("page");
    	mv.addObject("title","Home");
    	mv.addObject("categories",categoryDao.categoryList());
    	mv.addObject("Books",bookDao.homePageBooks());
    	mv.addObject("userClickHome", true);
		return mv;
	}
    
    @RequestMapping(value = "/book/{id}")
	public ModelAndView singleBook(@PathVariable("id") Long id) {
    	System.out.println("Single Book page Loaded");
    	ModelAndView mv = new ModelAndView("page");
    	Book book = bookDao.get(id);
    	mv.addObject("book",book);
    	mv.addObject("title",book.getTitle());
    	mv.addObject("userClickViewProduct", true);
		return mv;
	}
    
    @RequestMapping(value = "/book/category/{id}")
	public ModelAndView BooksByCategoryName(@PathVariable("id") Long id) {
    	System.out.println("Single Book page Loaded");
    	ModelAndView mv = new ModelAndView("page");
    	List<Book> list = bookDao.listofBookByCategory(id);
    	mv.addObject("Books",list);
    	mv.addObject("title","BookByCategory");
    	mv.addObject("userClickHome", true);
		return mv;
	}
    
    
    
    @RequestMapping(value = "/about")
	public ModelAndView about() {
    	System.out.println("ABOUT PAGE LOADED");
    	ModelAndView mv = new ModelAndView("page");
    	mv.addObject("title","About Us");
    	mv.addObject("userClickAbout", true);
		return mv;
	}
    
    @RequestMapping(value = "/contact")
	public ModelAndView contact() {
    	System.out.println("CONTACT PAGE LOADED");
    	ModelAndView mv = new ModelAndView("page");
    	mv.addObject("title","Contact Us");
    	mv.addObject("userClickContact", true);
		return mv;
	}
    
    
}
