package com.jitender.bookStore.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jitender.bookStore.model.Book;
@Repository
@Transactional
public class BookDaoImpl implements BookDAO {
    
	@Autowired
	private SessionFactory sessionFactory;
	
/*
	@Override
	public Long save(Book book) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	public Book get(long id) {
          Book book = sessionFactory.getCurrentSession().get(Book.class, id);
          return book;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Book> list() {
		return sessionFactory.getCurrentSession().createQuery("from Book").list();
	}

	/*
	@Override
	public void update(long id, Book book) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}
*/
	@Override
	public List<Book> homePageBooks(){
		return sessionFactory.getCurrentSession().createQuery("from Book where category = 1", Book.class).list();
	}
	
    @Override
    @Transactional
	public List<Book> listofBookByCategory(long id) {
   
	    List<Book> books = sessionFactory.getCurrentSession().createQuery("from Book b where b.category ="+id,Book.class).list();
	    return books;
	}

}
