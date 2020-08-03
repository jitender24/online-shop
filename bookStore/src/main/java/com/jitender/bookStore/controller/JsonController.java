package com.jitender.bookStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jitender.bookStore.dao.BookDAO;
import com.jitender.bookStore.dao.CategoryDAO;
import com.jitender.bookStore.model.Book;
import com.jitender.bookStore.model.BookCategory;

@Controller
@RequestMapping("/json")
public class JsonController {

	@Autowired
	private CategoryDAO categoryDao;

	@Autowired
	private BookDAO bookDao;

	@RequestMapping("/categories")
	@ResponseBody
	List<BookCategory> listOfCategory() {

		return categoryDao.categoryList();
	}

	@RequestMapping("/books")
	@ResponseBody
	List<Book> BookList() {

		return bookDao.list();
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<?> getBookById(@PathVariable("id") Long id) {

		Book singleBook = bookDao.get(id);
		return ResponseEntity.ok(singleBook);
	}

	@PostMapping("/categories")
	public ResponseEntity<?> save(@RequestBody BookCategory category) {

		long id = categoryDao.addCategory(category);
		return ResponseEntity.ok().body("Category created with id:" + id);
	}

	@GetMapping("categories/{id}/books")
	public ResponseEntity<?> getHomePageBooks(@PathVariable("id") Long id) {

		List<Book> list = bookDao.listofBookByCategory(id);
		return ResponseEntity.ok().body(list);
	}

	/*
	 * @GetMapping("/books/homepage") public ResponseEntity<?> HomePageBooks() {
	 * 
	 * List<Book> list = bookDao.homePageBooks(); return
	 * ResponseEntity.ok().body(list); }
	 */

	/*
	 * @PostMapping("/books") public ResponseEntity<?> addBook(@RequestBody Book
	 * book) {
	 * 
	 * long id = bookDao.save(book); return
	 * ResponseEntity.ok().body("Book created with id:" + id); }
	 */
}
