package authApp.Tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import authApp.Auth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This is a jUnit Test Class that Tests all the Authentication Tests, including connecting to the Database.
 * @author Tsotne
 *
 */
class AuthTest {

	private Auth auth;
	
	/**
	 * Default constructor for test class AuthTest.
	 */
	AuthTest() {
		
	}
	
	@BeforeEach
	void setUp() throws Exception {
		
	}
	/*
	* Testing Database connection
	*/
	@Test
	void connectToDbTest() {
		auth = new Auth();
		assertNotNull("Connected To DB", auth.connectToDb());
	}
	/*
	* Testing existing user (Director type)
	*/
	@Test
	void checkValidUserTest1() {
		auth = new Auth();
		assertTrue(auth.checkValidUser("theRealMiles", "password321"));
	}
	/*
	* Testing real existing user (Employee type)
	*/
	@Test
	void checkValidUserTest2() {
		auth = new Auth();
		assertTrue(auth.checkValidUser("johnIsReal", "password123"));
	}
	/*
	* Testing non existing user
	*/
	@Test
	void checkValidUserTest3() {
		auth = new Auth();
		assertFalse(auth.checkValidUser("Tsotne","asjdhakjsd123"));
	}

}
