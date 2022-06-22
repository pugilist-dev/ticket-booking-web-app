package com.atr.service;

import com.atr.model.CustomerModel;
import com.atr.dao.ProfileUpdateDao;

public class ProfileUpdateService {

	public CustomerModel Update(CustomerModel cmodel) {
		ProfileUpdateDao updt=new ProfileUpdateDao();
		CustomerModel res=updt.update(cmodel);
		return res;
	}

}
