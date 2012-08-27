package com.tangotab.spring;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;

/**
 * User: Admin
 * Date: 7/4/12
 */
public class TGPerformanceInterceptor extends PerformanceMonitorInterceptor {

    public TGPerformanceInterceptor() {
    }

    public TGPerformanceInterceptor(boolean useDynamicLogger) {
        super(useDynamicLogger);
    }

    @Override
    protected boolean isLogEnabled(Log logger) {
        return true;
    }

    @Override
    protected boolean isInterceptorEnabled(MethodInvocation invocation, Log logger) {
        return true;
    }

    @Override
    protected Object invokeUnderTrace(MethodInvocation invocation, Log logger) throws Throwable {
        Method method = invocation.getMethod();
        logger.debug("Invoking method " +((ReflectiveMethodInvocation) invocation).getMethod().toGenericString());
        return super.invokeUnderTrace(invocation, logger);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
