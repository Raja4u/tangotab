package com.tangotab.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

/**
 * User: Admin
 * Date: 7/7/12
 */
@Component
public class TempDAOImpl extends HibernateDaoSupport {
    /**
     * Spring is unable to inject session factory for some strange reason
     */
    @Autowired
    public void setSessionFactory1(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

}
