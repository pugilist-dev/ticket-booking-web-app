package com.atr.bo;

import com.atr.service.ForgotService;

public class ForgotBo {

	public String getQuestion(String emailID) {
		ForgotService obj=new ForgotService();
		String res =obj.getQuestion(emailID);
		return res;
	}

	public boolean resetPasswordCheck(String email, String answer,String question) {
		ForgotService obj=new ForgotService();
	    boolean res =obj.resetPasswordCheck(email,answer, question);
		return res;
	}

	public int resetPasswordUpdate(String password, String email) {
		ForgotService obj=new ForgotService();
		int res =obj.resetPasswordUpdate(password,email);
		return res;
	}

}
