package com.jitender.bookStore.dao;

import com.jitender.bookStore.model.Address;
import com.jitender.bookStore.model.Cart;
import com.jitender.bookStore.model.User;

public interface UserDAO {

	boolean addUser(User user);
	
	boolean addAddress(Address address);
	
	boolean addCart(Cart cart);
	
}
