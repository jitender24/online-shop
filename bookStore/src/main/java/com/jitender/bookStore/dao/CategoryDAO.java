package com.jitender.bookStore.dao;

import java.util.List;

import com.jitender.bookStore.model.BookCategory;

public interface CategoryDAO {
       
	List<BookCategory> categoryList();
	
	Long addCategory(BookCategory category);
}
