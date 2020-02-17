package authApp.Tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import authApp.Auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthTest {

	private Auth auth;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}
	/*
	* Testing Database connection
	*/
	@Test
	void connectToDbTest() {
		Auth auth = new Auth();
		assertNotNull("Connected To DB", auth.connectToDb());
	}
	/*
	* Testing existing user (Director type)
	*/
	@Test
	void checkValidUserTest1() {
		Auth auth = new Auth();
		assertTrue(auth.checkValidUser("theRealMiles", "password321"));
	}
	/*
	* Testing real existing user (Employee type)
	*/
	@Test
	void checkValidUserTest2() {
		Auth auth = new Auth();
		assertTrue(auth.checkValidUser("johnIsReal", "password123"));
	}
	/*
	* Testing non existing user
	*/
	@Test
	void checkValidUserTest3() {
		Auth auth = new Auth();
		assertFalse(auth.checkValidUser("Tsotne","asjdhakjsd123"));
	}

}
