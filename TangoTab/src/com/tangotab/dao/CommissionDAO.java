package com.tangotab.dao;

import com.tangotab.dao.pojo.CommissionRate;
import com.tangotab.exception.ApplicationException;

public interface CommissionDAO {
	public int updateCommission(CommissionRate commission) throws ApplicationException;

	public CommissionRate getCommission() throws ApplicationException;
}
