package com.tangotab.businessImpl;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 7/6/12
 * Time: 9:17 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class BaseBOImpl {
    private Logger logger = Logger.getLogger(getClass());

    protected void copyProperties(Object t1, Object transto) {
        try {
            BeanUtils.copyProperties(transto, t1);
        } catch (Exception e) {
            logger.error("Error Copying bean", e);
        }
    }

}
