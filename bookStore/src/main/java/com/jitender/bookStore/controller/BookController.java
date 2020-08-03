package com.jitender.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jitender.bookStore.dao.BookDAO;
import com.jitender.bookStore.model.Book;

@Controller
public class BookController {
	
	@Autowired
	private BookDAO bookDao;
	
	@RequestMapping(value = "/books/{id}")
	public ModelAndView singleBook(@PathVariable("id") Long id) {
		
		System.out.println("Single Book page Loaded");
		ModelAndView mv = new ModelAndView("page");
		Book book = bookDao.get(id);
		mv.addObject("book", book);
		mv.addObject("title", book.getTitle());
		mv.addObject("userClickViewProduct", true);
		return mv;
	}
	
	@RequestMapping(value = "categories/{id}/books")
	public ModelAndView BooksByCategoryName(@PathVariable("id") Long id) {
		
		System.out.println("Single Book page Loaded");
		ModelAndView mv = new ModelAndView("page");
		List<Book> list = bookDao.listofBookByCategory(id);
		mv.addObject("Books", list);
		mv.addObject("title", "BookByCategory");
		mv.addObject("userClickHome", true);
		return mv;	
	}
	
}
