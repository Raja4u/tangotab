package com.tangotab.daoImpl;

import org.springframework.stereotype.Component;

import com.tangotab.dao.pojo.CommissionRate;
import com.tangotab.exception.ApplicationException;

@Component
public class CommissionDAO extends BaseDAOImpl<CommissionRate, Integer> {

    /**
    * Commission Rate
    * (non-Javadoc)
    * @see com.tangotab.dao.CommissionDAO_original#getCommission()
    */
    public CommissionRate getCommission() throws ApplicationException {
        return getAll().get(0);
    }

    @Override
    protected Class getBeanClass() {
        return CommissionRate.class;
    }
}
