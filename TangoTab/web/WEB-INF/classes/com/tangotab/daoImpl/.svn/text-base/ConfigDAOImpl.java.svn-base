package com.tangotab.daoImpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tangotab.dao.ConfigDAO;
import com.tangotab.dao.pojo.ConfigPojo;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;

@Component
public class ConfigDAOImpl extends TempDAOImpl implements ConfigDAO {
	private static Logger log = LoggerFactory.getLogger(ConfigDAOImpl.class);
/*
 * Get Config Deatais 
 */
	public ConfigPojo getConfigDetails() throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveCuisine ");
		ConfigPojo config = null;
		Session session = getSession(false);
 
		try {
			Criteria criteria = session.createCriteria(ConfigPojo.class);

			config = (ConfigPojo) criteria.uniqueResult();

		} catch (Exception e) {
 

			e.printStackTrace();
		}finally{
			//session.close();
		}
		return config;
	}
/*
 * Update Config Data
 */
	public int updateConfig(ConfigPojo config) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveConsumer ");
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			session.update(config);
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in updateConfig" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return config.getConfigId();

	}

}
