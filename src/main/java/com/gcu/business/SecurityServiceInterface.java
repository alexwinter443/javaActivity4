package com.gcu.business;

import com.gcu.model.LoginModel;

public interface SecurityServiceInterface {

	public void test();
	public boolean isAuthenticated(LoginModel model);
}
