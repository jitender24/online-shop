package com.jitender.bookStore.daoImp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jitender.bookStore.dao.CategoryDAO;
import com.jitender.bookStore.model.BookCategory;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDAO {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<BookCategory> categoryList() {

		return sessionFactory.getCurrentSession()
				.createQuery("from category", BookCategory.class).list();
	}

	@Override
	public Long addCategory(BookCategory category) {

		sessionFactory.getCurrentSession().save(category);
		return category.getCategoryId();
	}

}
