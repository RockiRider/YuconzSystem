package authApp.Tests;

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
		assertFalse(auth.getConnected());
	}
	@Test
	void checkValidUserTest1() {
		assertTrue(auth.checkValidUser("Miles", "123"));
	}
	@Test
	void checkValidUserTest2() {
		assertFalse(auth.checkValidUser("Tsotne", "5asdjh"));
	}

}
