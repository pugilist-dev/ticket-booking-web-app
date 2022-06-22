package com.atr.service;

import com.atr.dao.CustomerModelImplementation;
import com.atr.dao.CustomerModelInterface;
import com.atr.model.CustomerModel;

public class RegisterSO {

	public int RegisterCustomer(CustomerModel cm) {
		//System.out.println("Calling service");
	CustomerModelInterface cmi= new CustomerModelImplementation();
	 // System.out.println("returned from dao to so");
	int s=cmi.registerCustomer(cm);
	//System.out.println("returning back from so to bo");
	return s;
	}

}
