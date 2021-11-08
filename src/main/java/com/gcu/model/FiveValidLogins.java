package com.gcu.model;

import com.gcu.business.SecurityServiceInterface;

public class FiveValidLogins implements SecurityServiceInterface{

	@Override
	public boolean isAuthenticated(LoginModel loginModel) {
		
		String[][] validLogins = new String[][] {
			{"Darius","Pass"},
			{"Sarafina","nothing"},
			{"Merlin","IHaveThePower"},
			{"Quinn","secret"},
			{"Fanta","drink"},
			{"Jillian","password"}
			
		};
		
		// Check to see if the login matches any of the valid logins
		boolean success = false;
		for (int i = 0; i < validLogins.length; i++) {
			if(loginModel.getUsername().equals(validLogins[i][0]) && loginModel.getPassword().equals(validLogins[i][1])){
				success = true;
			}
		}
		// successful login ; ie returns true
		if(success) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public void test() {
		System.out.println("We are running and using the SecurityService");
		
	}
	
	

}
