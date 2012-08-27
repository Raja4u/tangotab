package com.tangotab.businessImpl;

import com.tangotab.business.ConfigBO;
import com.tangotab.dao.ConfigDAO;
import com.tangotab.dao.pojo.ConfigPojo;
import com.tangotab.exception.ApplicationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class ConfigBOImpl implements ConfigBO {

    @Autowired
    protected ConfigDAO configDAO;

    /* get configuration details for display for administrator */
	public ConfigPojo getConfigDetails() throws ApplicationException {
		ConfigPojo config = null;
		try {
			config = getConfigDAO().getConfigDetails();

		} catch (Exception e) {

			e.printStackTrace();
		}
		return config;
	}

    private ConfigDAO getConfigDAO() {
        return configDAO;
    }

    /* Update the configuration details done by administrator */
	public void updateConfig(ConfigPojo config) throws ApplicationException {
		try {

			getConfigDAO().updateConfig(config);

		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}

	}

}
