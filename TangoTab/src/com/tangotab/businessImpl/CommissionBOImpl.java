package com.tangotab.businessImpl;

import com.tangotab.business.CommissionBO;
import com.tangotab.dao.UserDAO;
import com.tangotab.dao.pojo.CommissionRate;
import com.tangotab.daoImpl.CommissionDAO;
import com.tangotab.exception.ApplicationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class CommissionBOImpl implements CommissionBO {

    @Autowired
    protected CommissionDAO commissionDAO;

    @Autowired
    protected UserDAO userDAO;

    /**
     * Update Commission
     */
    public void updateCommission(CommissionRate commission) throws ApplicationException {
        commissionDAO.update(commission);
    }

    /**
     * Get Commission Data of TangoTab
     */
    public CommissionRate getCommission() throws ApplicationException {
        return commissionDAO.getCommission();
    }
}
