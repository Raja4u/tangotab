package com.tangotab.TO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QueryTO {
	
	private Date startDate;
	private Date endDate;
	private String cityId;
	private List<CityTO> cities = new ArrayList<CityTO> ();
	private String getAll;
			
	public String getGetAll() {
		return getAll;
	}
	public void setGetAll(String getAll) {
		this.getAll = getAll;
	}
	public List<CityTO> getCities() {
		return cities;
	}
	public void setCities(List<CityTO> cities) {
		this.cities = cities;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

}
