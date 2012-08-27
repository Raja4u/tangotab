package com.tangotab.businessImpl;

import com.tangotab.business.AdminBO;
import com.tangotab.business.BillingMethodsBO;
import com.tangotab.business.CommissionBO;
import com.tangotab.business.CommonBO;
import com.tangotab.business.ConfigBO;
import com.tangotab.business.DealBO;
import com.tangotab.business.LocationBO;
import com.tangotab.business.RestaurantAdminBO;
import com.tangotab.business.RestaurantDiscountBO;
import com.tangotab.business.TransactionBO;
import com.tangotab.business.UserBO;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 6/27/12
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class BusinessFactory {
    private static ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("resources/spring/spring.xml");

    public static UserBO getUserBO() {
        return getBean(UserBO.class);
    }


    private static <T> T getBean(Class<T> userDAOClass) {
        return (T) classPathXmlApplicationContext.getBean(userDAOClass.getName());
    }

    public static DealBO getDealBO() {
        return getBean(DealBO.class);
    }

    public static AdminBO getAdminBO() {
        return getBean(AdminBO.class);
    }

    public static BillingMethodsBO getBillingMethodsBO() {
        return getBean(BillingMethodsBO.class);
    }

    public static CommonBO getCommonBO() {
        return getBean(CommonBO.class);
    }

    public static CommissionBO getCommissionBO() {
        return getBean(CommissionBO.class);
    }

    public static ConfigBO getConfigBO() {
        return getBean(ConfigBO.class);
    }

    public static LocationBO getLocationBO() {
        return getBean(LocationBO.class);
    }

    public static RestaurantAdminBO getRestaurantAdminBO() {
        return getBean(RestaurantAdminBO.class);
    }

    public static RestaurantDiscountBO getRestaurantDiscountBO() {
        return getBean(RestaurantDiscountBO.class);
    }

    public static TransactionBO getTransactionBO() {
        return getBean(TransactionBO.class);
    }
}
