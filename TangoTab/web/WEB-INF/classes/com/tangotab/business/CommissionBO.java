package com.tangotab.business;

import com.tangotab.dao.pojo.CommissionRate;
import com.tangotab.exception.ApplicationException;

public interface CommissionBO {
	public void updateCommission(CommissionRate commission) throws ApplicationException;

	public CommissionRate getCommission() throws ApplicationException;
}
