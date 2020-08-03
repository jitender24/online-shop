package com.jitender.bookStore.daoImp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jitender.bookStore.dao.BookDAO;
import com.jitender.bookStore.model.Book;

@Repository
@Transactional
public class BookDaoImpl implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Long save(Book book) {
		sessionFactory.getCurrentSession().persist(book);
		return book.getId();
	}

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

	@Override
	public boolean update(Book book) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(book);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Book> homePageBooks() {

		String Query = "from Book where categoryId = 1";
		return sessionFactory.getCurrentSession().createQuery(Query, Book.class).list();
	}

	@Override
	@Transactional
	public List<Book> listofBookByCategory(long id) {

		String Query = "from Book b where b.categoryId =";
		List<Book> books = sessionFactory.getCurrentSession().createQuery(Query + id, Book.class).list();
		return books;
	}
}
