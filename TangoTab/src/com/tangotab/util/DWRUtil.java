package com.tangotab.util;

import java.util.ArrayList;

import com.tangotab.TO.CountryTO;
import com.tangotab.businessImpl.BusinessFactory;

/**
 * User: Admin
 * Date: 7/4/12
 */
public class DWRUtil {
    public ArrayList<CountryTO> getCountries(){
        return BusinessFactory.getCommonBO().getCountries();
    }
}
