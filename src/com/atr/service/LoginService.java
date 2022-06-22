package com.atr.service;

import com.atr.model.CustomerModel;
import com.atr.dao.LoginDaoImp;

public class LoginService {

	public CustomerModel login(String email, String password) {
		LoginDaoImp obj=new LoginDaoImp();
		CustomerModel cm =obj.login(email,password);
		return cm;
	}

}
