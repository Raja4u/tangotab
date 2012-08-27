package com.tangotab.daoImpl;

import org.hibernate.SessionFactory;

public class TangoTabCommonDAOImpl {

	/*
	 * protected SessionFactory sessionFactory = new Configuration().configure()
	 * .addResource(TangotabConstants.HIBERNATE_CONFIG_FILE) .buildSessionFactory();
	 */

	protected SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();

	public void silentCloseFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
