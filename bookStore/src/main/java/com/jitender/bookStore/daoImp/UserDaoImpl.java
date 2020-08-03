package com.jitender.bookStore.daoImp;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jitender.bookStore.dao.UserDAO;
import com.jitender.bookStore.model.Address;
import com.jitender.bookStore.model.Cart;
import com.jitender.bookStore.model.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addCart(Cart cart) {
	
		try {
			sessionFactory.getCurrentSession().persist(cart);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
