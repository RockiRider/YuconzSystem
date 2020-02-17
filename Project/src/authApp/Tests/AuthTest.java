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

	@Test
	void connectToDbTest() {
		Auth auth = new Auth();
		assertNotNull("Connected To DB", auth.connectToDb());
	}
	@Test
	void checkValidUserTest1() {
		Auth auth = new Auth();
		assertTrue(auth.checkValidUser("theRealMiles", "password321"));
	}
	@Test
	void checkValidUserTest2() {
		Auth auth = new Auth();
		assertTrue(auth.checkValidUser("johnIsReal", "password123"));
	}
	@Test
	void checkValidUserTest3() {
		Auth auth = new Auth();
		assertFalse(auth.checkValidUser("Tsotne","asjdhakjsd123"));
	}

}
