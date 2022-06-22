package com.atr.model;

import java.io.Serializable;

public class LocationModel implements Serializable{
	private static final long serialVersionUID = -4638381903755922245L;
	private String locationId;
	private String locationName;
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
