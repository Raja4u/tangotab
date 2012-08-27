package com.tangotab.daoImpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.dao.CommissionDAO;
import com.tangotab.dao.pojo.CommissionRate;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;

public class CommissionDAOImpl extends TempDAOImpl implements CommissionDAO {
	private Logger log = LoggerFactory.getLogger(CommissionDAOImpl.class);

	/*
	 * Update Commission
	 * (non-Javadoc)
	 * @see com.tangotab.dao.CommissionDAO#updateCommission(com.tangotab.dao.pojo.CommissionRate)
	 */
	public int updateCommission(CommissionRate commission) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of updateConsumer ");
		Session session = getSession(false);
		Transaction transaction = session.beginTransaction();
		try {
			//	
			session.update(commission);
			transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveConsumer" + e.getMessage());
			}
			e.printStackTrace();
			transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			session.close();
		}
		return commission.getCommissionRateId();
	}
/*
 * Commission Rate
 * (non-Javadoc)
 * @see com.tangotab.dao.CommissionDAO#getCommission()
 */
	public CommissionRate getCommission() throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of updateConsumer ");
		Session session = getSession(false);
		Transaction transaction = session.beginTransaction();
		CommissionRate commission = null;
		try {

			Criteria criteria = session.createCriteria(CommissionRate.class);
			commission = (CommissionRate) criteria.uniqueResult();
			//	
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveConsumer" + e.getMessage());
			}
			e.printStackTrace();
			transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			session.close();
		}
		return commission;
	}
}
