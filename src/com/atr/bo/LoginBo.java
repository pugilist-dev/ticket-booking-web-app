package com.atr.bo;

import com.atr.service.LoginService;
import com.atr.model.CustomerModel;

public class LoginBo {

	public CustomerModel login(String email, String password) {
		LoginService obj=new LoginService();
		CustomerModel cm =obj.login(email,password);
		return cm;
	}

}
