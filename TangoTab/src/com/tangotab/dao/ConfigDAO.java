package com.tangotab.dao;

import com.tangotab.dao.pojo.ConfigPojo;
import com.tangotab.exception.ApplicationException;

public interface ConfigDAO {
	public ConfigPojo getConfigDetails() throws ApplicationException;

	public int updateConfig(ConfigPojo config) throws ApplicationException;

}
