package tests;

import model.User;
import utils.TestUtils;

public class UserTest {

	public static void main(String[] args) {
		/* Old Manual Testing
		User testUser = new User("mike", "my_passwd", "Mike", "Smith", "07771234567");
		System.out.println(testUser);
		*/
		testUserConstructor();
		
	}
	
	public static void testUserConstructor() {
		// 1-Setup
		String test_username = "mike";
		String test_password = "my_passwd";
		String test_first_name = "Mike";
		String test_last_name = "Smith";
		String test_mobile_number = "07771234567";
		
		// 2-Exercise
		User testUser = new User(test_username, test_password, test_first_name, 
				test_last_name, test_mobile_number);
		
		// 3-Verify
		System.out.println("Starting the assertions of the test method: testUserConstructor");
		
		
		/*
		if(testUser.getUsername() == test_username) 
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC1-getUsername-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getUsername-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		if (testUser.getPassword() == test_password)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getPassword-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getPassword-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		if (testUser.getFirst_name() == test_first_name)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getFirst_name-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getFirst_name-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		if (testUser.getLast_name() == test_last_name)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getLast_name-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getLast_name-FAILED" + TestUtils.TEXT_COLOR_RESET);
		
		if (testUser.getMobile_number() == test_mobile_number)
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TC2-getMobile_number-Passed" + TestUtils.TEXT_COLOR_RESET);
		else
			System.out.println(TestUtils.TEXT_COLOR_RED + "TC1-getMobile_number-FAILED" + TestUtils.TEXT_COLOR_RESET);
		*/
		
		boolean passed = true;
		
		if (testUser.getUsername() != test_username) {
			System.out.println("TC1 failed: username did not match");
			passed = false;
		}
			
		if (testUser.getPassword() != test_password) {
			System.out.println("TC2 failed: password did not match");
			passed = false;
		}
		
		if (testUser.getFirst_name() != test_first_name) {
			System.out.println("TC3 failed: first_name did not match");
			passed = false;

		}
		
		if (testUser.getLast_name() != test_last_name) {
			System.out.println("TC4 failed: last_name did not match");
			passed = false;
		}
		
		if (testUser.getMobile_number() != test_mobile_number) {	
			System.out.println("TC5 failed: mobile_number did not match");
			passed = false;
		}
	
		if (passed) 
			System.out.println("All TC's passed.");
			
		//Using assert's
		assert testUser.getUsername() == test_username;
		assert testUser.getPassword() == test_password;
		assert testUser.getFirst_name() == test_first_name;
		assert testUser.getLast_name() == test_last_name;
		assert testUser.getMobile_number() == test_mobile_number;
		
		System.out.println("All Java assertions in the test suite passed (none failed).");
		
	}

}
