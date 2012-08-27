package com.tangotab.business;

import java.util.ArrayList;

import com.tangotab.TO.LandingTO;
import com.tangotab.dao.pojo.City;
import com.tangotab.dao.pojo.Landing;
import com.tangotab.exception.ApplicationException;

public interface AdminBO {

	public void saveCity(City city) throws ApplicationException;

	public boolean setCityStatus(int city_id, Integer status) throws ApplicationException;

	public boolean setStateStatus(int city_id, Integer status) throws ApplicationException;

	public String[] getImages(String dealName) throws ApplicationException;

	public void saveLanding(Landing landing) throws ApplicationException;

	public ArrayList<LandingTO> getLandings() throws ApplicationException ;
}
