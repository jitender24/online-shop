package com.jitender.bookStore.dao;

import java.util.List;

import com.jitender.bookStore.model.Book;

public interface BookDAO {

	// save the record 
	Long save(Book book);
	
	// get a single record
	Book get(long id);
	
	// list of all record
	List<Book> list();
	
	// update the record
	boolean update(Book book);
	
	// delete the record 
//	void delete(long id); 	
	
	// List of book of pertcular category
	List<Book> homePageBooks();
	
	List<Book> listofBookByCategory(long categoryId);
}
