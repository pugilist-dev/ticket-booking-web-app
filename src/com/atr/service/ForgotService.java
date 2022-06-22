package com.atr.service;

import com.atr.dao.ForgotDaoImp;

public class ForgotService {

	public String getQuestion(String emailID) {
		ForgotDaoImp obj=new ForgotDaoImp();
		String res =obj.getQuestion(emailID);
		return res;
	}
	public boolean resetPasswordCheck(String email, String answer,
			String question) {
		ForgotDaoImp obj=new ForgotDaoImp();
	    boolean res =obj.resetPasswordCheck(email,answer, question);
		return res;
	}
	public int resetPasswordUpdate(String password, String email) {
		ForgotDaoImp obj=new ForgotDaoImp();
		int res =obj.resetPasswordUpdate(password,email);
		return res;
	}

}
