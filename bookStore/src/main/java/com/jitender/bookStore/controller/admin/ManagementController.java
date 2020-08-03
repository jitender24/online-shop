package com.jitender.bookStore.controller.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jitender.bookStore.dao.BookDAO;
import com.jitender.bookStore.dao.CategoryDAO;
import com.jitender.bookStore.model.Book;
import com.jitender.bookStore.model.BookCategory;

@Controller
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDao;

	@Autowired
	private BookDAO bookDao;

	@RequestMapping(value = "/manage")
	public ModelAndView singleBook(@RequestParam(name = "operation", required = false) String operation) {

		System.out.println("Single Book page Loaded");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Manage Book");
		Book newBook = new Book();
		mv.addObject("BooksList", bookDao.list());
		mv.addObject("book", newBook);
		mv.addObject("userClickManageBook", true);

		if (operation != null) {
			if (operation.equals("book")) {
				mv.addObject("message", "Book Submitted Successfully");
			} else if (operation.equals("category")) {
				mv.addObject("message", "Category Submitted Successfully");
			}
		}
		return mv;
	}

	@PostMapping(value = "/manage/book")
	public String handleBookSubmission(@Valid @ModelAttribute("book") Book mBook, BindingResult bindingResult,
			Model model) {
		/*
		 * System.out.println("Single Book record save "); if(bindingResult.hasErrors())
		 * { model.addAttribute("title","Manage Book");
		 * model.addAttribute("userClickManageBook", true);
		 * model.addAttribute("message","Validation fail for Book Submission"); return
		 * "page"; }
		 */
		if (mBook.isActive() == false) {

			// creating a new book if Id is 0 or earlier book is not added
			System.out.println("New Book record save ");
			mBook.setActive(true);
			bookDao.save(mBook);
		} else {
			/* Update the Existing book */
			System.out.println("Old Book record Edited Succesfuly ");
			bookDao.update(mBook);
		}

		return "redirect:/manage?operation=book";
	}

	// for Edit the Single Book
	@RequestMapping(value = "/manage/{id}/book")
	public ModelAndView ManageBookEdit(@PathVariable Long id) {

		System.out.println("Single Book Editing form");
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Manage Book");

		// Fetch the book from the DataBase
		Book bookForEditing = bookDao.get(id);

		// mv.addObject("BooksList",bookDao.list());
		mv.addObject("book", bookForEditing);
		mv.addObject("userClickManageBook", true);

		return mv;
	}

	@PostMapping(value = "/book/{id}/activation")
	@ResponseBody
	public String handleBookActivation(@PathVariable int id) {

		Book book = bookDao.get(id);
		boolean isActive = book.isActive();
		book.setActive(!book.isActive());
		bookDao.update(book);

		return (isActive) ? "You have successfully deactivated the book with id " + book.getId()
				: "You have successfully Activated the book" + book.getId();
	}

	// For adding new Book Category
	@PostMapping(value = "/manage/category")
	public String handelCategorySubmission(@ModelAttribute BookCategory category) {
		categoryDao.addCategory(category);
		return "redirect:/manage?operation=category";
	}

	// returning categories for all the request
	@ModelAttribute("categories")
	public List<BookCategory> getCategories() {
		return categoryDao.categoryList();
	}

	@ModelAttribute("category")
	public BookCategory getCategory() {
		return new BookCategory();
	}
}
