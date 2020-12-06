package it.unipd.tos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	private User us;
	
	@Before
	public void setup() {
		us = new User("Alice","Gibellato",21);
	}
	
	@Test
	public void getNameTest() {
		assertEquals("Alice", us.getName());
	}
	
	@Test
	public void getSurnameTest() {
		assertEquals("Gibellato", us.getSurname());
	}
	
	@Test
	public void getAgeTest() {
		assertEquals(21, us.getAge());
	}
	
	@Test
	public void invalidAgeTest() {
		boolean age = true;
		if(us.getAge()<0)
			age = false;
		assertEquals(true, age);
	}
}
