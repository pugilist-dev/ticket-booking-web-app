package com.atr.bo;


import com.atr.service.ProfileUpdateService;
import com.atr.model.CustomerModel;

public class ProfileUpdateBo {

	public CustomerModel update(CustomerModel cmodel) {
		ProfileUpdateService updt=new ProfileUpdateService();
		CustomerModel res=updt.Update(cmodel);;
		return res;
		
	}

}
