package tests;

import java.util.Date;

import model.Account;

public class AccountTest {
	
	public static void testConstructor() {
		
		String test_account_number = "12345";
		String test_username_of_account_holder = "mike";
		String test_account_type = "Standard";
		Date test_account_opening_date = new Date(2024-02-03);
		
		Account testAccount = new Account(test_account_number, test_username_of_account_holder, 
				test_account_type, test_account_opening_date);
		
		boolean passed = true;
		
		if (testAccount.getAccount_number() != test_account_number) {
			System.out.println("TC1 failed: account_number did not match");
			passed = false;
		}
			
		if (testAccount.getUsername_of_account_holder() != test_username_of_account_holder) {
			System.out.println("TC2 failed: username_of_account_holder did not match");
			passed = false;
		}
		
		if (testAccount.getAccount_type() != test_account_type) {
			System.out.println("TC3 failed: account_type did not match");
			passed = false;

		}
		
		if (testAccount.getAccount_opening_date() != test_account_opening_date) {
			System.out.println("TC4 failed: account_opening_date did not match");
			passed = false;
		}
		
	
		if (passed) 
			System.out.println("All Getter TC's passed.");
	}
	
	public static void testSetters() {
		
		String test_account_number = "12345";
		String test_username_of_account_holder = "mike";
		String test_account_type = "Standard";
		Date test_account_opening_date = new Date(2024-02-03);
		
		String updated_test_account_number = "54321";
		String updated_test_username_of_account_holder = "smith";
		String updated_test_account_type = "Savings";
		Date updated_test_account_opening_date = new Date(2023-02-03);
		
		Account testAccount = new Account(test_account_number, test_username_of_account_holder, 
				test_account_type, test_account_opening_date);
		
		boolean passed = true;
		
		testAccount.setAccount_number(updated_test_account_number);
		if (testAccount.getAccount_number() != updated_test_account_number) {
			System.out.println("TC1 failed: account_number did not match after being changed using setter");
			passed = false;
		}
			
		testAccount.setUsername_of_account_holder(updated_test_username_of_account_holder);
		if (testAccount.getUsername_of_account_holder() != updated_test_username_of_account_holder) {
			System.out.println("TC2 failed: username_of_account_holder did not match after being changed using setter");
			passed = false;
		}
		
		testAccount.setAccount_type(updated_test_account_type);
		if (testAccount.getAccount_type() != updated_test_account_type) {
			System.out.println("TC3 failed: account_type did not match after being changed using setter");
			passed = false;

		}
		
		testAccount.setAccount_opening_date(updated_test_account_opening_date);
		if (testAccount.getAccount_opening_date() != updated_test_account_opening_date) {
			System.out.println("TC4 failed: account_opening_date did not match after being changed using setter");
			passed = false;
		}
		
		if (passed) 
			System.out.println("All Setter TC's passed.");
		
	}
	
	public static void main(String[] args) {
		testConstructor();
		testSetters();
	}

}
