package com.jitender.bookStore.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jitender.bookStore.dao.UserDAO;
import com.jitender.bookStore.model.Address;
import com.jitender.bookStore.model.Cart;
import com.jitender.bookStore.model.User;

public class UserTest {
     private static AnnotationConfigApplicationContext context;
     
	private static UserDAO userDao;
	private User user=null;
	private Address address=null;
	private Cart cart= null;
	
	
	public static void init() {
		 	context = new AnnotationConfigApplicationContext();
		 	context.scan("com.jitender.bookStore");
		 	context.refresh();	 
		 	userDao = (UserDAO) context.getBean("userDao");
		 	
	}
	/*
	@Test
	public void testAdd() {
		user = new User();
		user.setFirstName("jitender");
		user.setLastName("singh");
		user.setEmail("jitender@gmail.com");
		user.setContactNumber("868435435");
		user.setRole("USER");
		user.setPassword("12345");
		user.setConfirmPassword("12345");
		
		//add ther user
		assertEquals("Failed to save the user", true, userDao.addUser(user));
		
		
		address = new Address();
		address.setAddressLineOne("a/66,jaitpur");
		address.setAddressLineTwo("badarpur");
		address.setCity("new Delhi");
		address.setState("Delhi");
		address.setCountry("INDIA");
		address.setPostalCode("400022");
		address.setBilling(true);
		
		// LInk the user with the address
		
		address.setUserId(user.getId());
		
		//add the address
		assertEquals("Failed to add the address", true, userDao.addAddress(address));
		
		if(user.getRole().equals("USER")) {
			cart = new Cart();	
			cart.setUser(user);
			
			//add the Cart
			assertEquals("Failed to add cart", true, userDao.addCart(cart));
			
			// add shipping address for the user
			address = new Address();
			address.setAddressLineOne("a/66,jaitpur");
			address.setAddressLineTwo("boriwali east");
			address.setCity("mumbai");
			address.setState("Maharastra");
			address.setCountry("INDIA");
			address.setPostalCode("400022");
			// set shipping to true
			address.setShipping(true);
			
			// link it with user
			
			address.setUserId(user.getId());
			assertEquals("Failed to save the shipping address", true, userDao.addAddress(address));			
		}

	}
	*/
}
