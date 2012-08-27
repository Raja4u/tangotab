package com.tangotab.businessImpl;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.commons.beanutils.BeanUtils;

import com.tangotab.TO.LandingTO;
import com.tangotab.business.AdminBO;
import com.tangotab.dao.AdminDAO;
import com.tangotab.dao.pojo.AdminDealImages;
import com.tangotab.dao.pojo.City;
import com.tangotab.dao.pojo.Landing;
import com.tangotab.exception.ApplicationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("com.tangotab.business.AdminBO")
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class AdminBOImpl implements AdminBO {

 

	@Autowired
    protected AdminDAO adminDAO;

    /* Save a new city added by administrator */
	public void saveCity(City city) throws ApplicationException {

		try {
			try {
				String cityname = city.getCityName();
				String statename = city.getState().getStateName();
				String url = "http://maps.googleapis.com/maps/geo?q="
						+ cityname + "," + statename
						+ "&output=csv&sensor=true";
				url = url.replace("#", ",");
				url = url.replace("$", ",");
				url = url.replace("\n", "");
				url = url.replace("\r", "");
				URL getURL = new URL(url);
				InputStream inStream = null;
				inStream = getURL.openConnection().getInputStream();
				byte[] b = new byte[inStream.available()];
				inStream.read(b);
				String jsonContent = new String(b);
				if (jsonContent.split(",").length == 4) {
					String csv[] = jsonContent.split(",");
					if (Integer.parseInt(csv[0]) == 200) {
						city.setLatitude(Double.parseDouble(csv[2]));
						city.setLongitude(Double.parseDouble(csv[3]));
					}
				}

				inStream.close();

			} catch (MalformedURLException me) {
				me.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (city.getLatitude() == null) {
				city.setLatitude(0.0);
			}
			if (city.getLongitude() == null) {
				city.setLongitude(0.0);
			}

			adminDAO.saveCity(city);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	

	/* Update the status of city */
	public boolean setCityStatus(int state_id, Integer status) throws ApplicationException {

		try {
                // adminDAO.getLandings();
			boolean result = adminDAO.setCityStatus(state_id, status);
			return result;
		} catch (ApplicationException e) {
			throw e;
		}
	}

   /* private AdminDAO adminDAO {
        return adminDAO;
    }*/

    /* Update the status of state */
	public boolean setStateStatus(int state_id, Integer status) throws ApplicationException {

		try {

			boolean result = adminDAO.setStateStatus(state_id, status);
			return result;
		} catch (ApplicationException e) {
			throw e;
		}
	}

	/* get all images corresponds to the dealname given */
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public String[] getImages(String dealName) throws ApplicationException {
		ArrayList<AdminDealImages> images = adminDAO.getImages(dealName);
		String[] imagesArray = null;
		ArrayList<String> imagesPathStore = new ArrayList<String>();
		for (AdminDealImages adminDealImg : images) {
			imagesPathStore.add(adminDealImg.getDealImgPath());
		}
		if (!imagesPathStore.isEmpty()) {
			imagesArray = (String[]) imagesPathStore.toArray(new String[imagesPathStore.size()]);
		}
		return imagesArray;
	}

	public void saveLanding(Landing landing) throws ApplicationException {
		// TODO Auto-generated method stub
		try {

			adminDAO.saveLanding(landing);

		} catch (ApplicationException e) {
			throw e;
		}
	}
	
	
	public ArrayList<LandingTO> getLandings() throws ApplicationException {
		ArrayList<LandingTO> landingsTO=new ArrayList<LandingTO>();
		ArrayList<Landing> landings;
		
		try{
			
			//landings=;
			landings = adminDAO.getLandings();
			for (Landing landing : landings) {
				LandingTO landTO=new LandingTO();
				BeanUtils.copyProperties(landTO, landing);
				landingsTO.add(landTO);
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return landingsTO;
	}

}
