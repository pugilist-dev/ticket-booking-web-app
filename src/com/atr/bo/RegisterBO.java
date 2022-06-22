package com.atr.bo;

import com.atr.service.RegisterSO;
import com.atr.model.CustomerModel;

public class RegisterBO {

	public int RegisterCustomer(CustomerModel cm) {
		//System.out.println("Calling BO");
		RegisterSO rso=new RegisterSO();
		// System.out.println("returned from so to bo");
		int s=rso.RegisterCustomer(cm);
		//System.out.println("returning back from bo to servlet");
		return s;
	}

}
