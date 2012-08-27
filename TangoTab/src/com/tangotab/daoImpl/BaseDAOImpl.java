package com.tangotab.daoImpl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tangotab.dao.BaseDAO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.StringUtil;
import com.tangotab.util.TangotabConstants;

/**
 * User: Amar Mattey
 * Date: 7/1/12
 */
public abstract class BaseDAOImpl<B, ID extends Serializable> extends HibernateDaoSupport implements BaseDAO<B, ID> {
    private Logger logger = Logger.getLogger(getClass());

    private String beanClassSimpleName;

    private boolean enableDebug = true;

    public BaseDAOImpl() {
    }

    /**
     * Spring is unable to inject session factory for some strange reason
     * @deprected
     */
    @Autowired
    public void setSessionFactory1(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public ID save(B bean) throws ApplicationException {
        try {
            return (ID) getSession(false).save(bean);
        } catch (Exception e) {
            logger.error("Error saving", e);
            throw new ApplicationException("DB001", TangotabConstants.ERROR);
        }
    }

    @Override
    public void update(B bean) throws ApplicationException {
        try {
            getSession(false).update(bean);
        } catch (Exception e) {
            logger.error("Error update", e);
            throw new ApplicationException("DB004", TangotabConstants.ERROR);
        }
    }

    @Override
    public void merge(B bean) throws ApplicationException {
        try {
            getSession(false).merge(bean);
        } catch (Exception e) {
            logger.error("Error saving", e);
            throw new ApplicationException("DB001", TangotabConstants.ERROR);
        }
    }

    @Override
    public B findFirst(String propertyName, Object propertyValue) {
        List<B> bs = doFind(Collections.singletonMap(propertyName, propertyValue), true, null, 1);
        if (bs == null || bs.isEmpty()) {
            return null;
        }
        return bs.get(0);
    }

    @Override
    public List<B> find(String propertyName, Object propertyValue) {
        return doFind(Collections.singletonMap(propertyName, propertyValue), true, null, -1);
    }

    @Override
    public List<B> find(Map<String, Object> searchCriteria) {
        return doFind(searchCriteria, true, null, -1);
    }

    @Override
    public List<B> find(Map<String, Object> searchCriteria, boolean andFlag, String... orderByList) {
        if (orderByList != null && orderByList.length > 0) {
            doFind(searchCriteria, andFlag, new ArrayList<String>(Arrays.asList(orderByList)), -1);
        }
        return doFind(searchCriteria, andFlag, null, -1);
    }

    protected List<B> doFind(Map<String, ?> searchCriteria, boolean andFlag, List<String> orderByList, int maxResult) {
        Session session = getSession(false);
        StringBuilder queryString = doBuildQuery(searchCriteria, andFlag, orderByList);

        Query query = doCreateQuery(session, queryString, searchCriteria);
        if (maxResult > 0) {
            query.setMaxResults(maxResult);
        }
        return queryList(query);
    }

    protected List<B> doLimitFind(Map<String, Object> searchCriteria, boolean andFlag, List<String> orderByList) {
        Session session = getSession(false);
        StringBuilder queryString = doBuildLimitQuery(searchCriteria, andFlag, orderByList);
        Query query = doCreateQuery(session, queryString, searchCriteria);
        return queryList(query);
    }

    public List queryList(Query query) {
        try {
            return query.list();
        } catch (JDBCConnectionException ex) {
            if (ex.getMessage().indexOf("The last packet successfully received ") > -1) {
                return query.list();
            }
            throw ex;
        }
    }

    public long doGetMaxOid() {
        Session session = getSession(false);
        String alias = getAlias();
        StringBuilder queryString = new StringBuilder("select max(" + alias + ".oid) from " + alias + " in " + getBeanClass());
        Query query = session.createQuery(queryString.toString());

        List list = queryList(query);
        if (list == null || list.isEmpty()) {
            return 0;
        }
        Number number = (Number) list.get(0);

        if (number == null) {
            return 0;
        }
        return number.longValue();
    }

    public List doExecuteCustomQuery(String customQuery, Map propertyMap) {
        Session session;
        session = getSession(false);
        Query query = session.getNamedQuery(customQuery);
        String[] namedParameters = query.getNamedParameters();
        if (namedParameters != null) {
            for (String namedParameter : namedParameters) {
                Object value = propertyMap.get(namedParameter);
                if (value == null) {
                    throw new IllegalArgumentException(namedParameter + " not found for query " + customQuery);
                }
                if (value instanceof Collection) {
                    query.setParameterList(namedParameter, (Collection<?>) value);
                } else {
                    query.setParameter(namedParameter, value);
                }
            }
        }

        return queryList(query);
    }

    public int doExecuteCountCustomQuery(String customQuery, Map propertyMap) {
        Session session = null;
        session = getSession(false);
        Query query = session.getNamedQuery(customQuery);
        String[] namedParameters = query.getNamedParameters();
        if (namedParameters != null) {
            for (String namedParameter : namedParameters) {
                Object value = propertyMap.get(namedParameter);
                if (value == null) {
                    throw new IllegalArgumentException(namedParameter + " not found for query " + customQuery);
                }
                if (value instanceof Collection) {
                    query.setParameterList(namedParameter, (Collection<?>) value);
                } else {
                    query.setParameter(namedParameter, value);
                }
            }
        }
        List list = queryList(query);
        Number number = (Number) list.get(0);

        if (number == null) {
            return 0;
        }
        return number.intValue();
    }

    protected Query doCreateQuery(Session session, StringBuilder queryString, Map<String, ?> searchCriteria) {
        Query query = session.createQuery(queryString.toString());
        String[] parameters = query.getNamedParameters();
        if (parameters != null) {
            // Query Iterator
            for (String parameterName : parameters) {
                Object value = searchCriteria.get(parameterName);

                if (value instanceof Collection) {
                    query.setParameterList(parameterName, (Collection) value);
                } else {
                    query.setParameter(parameterName, value);
                }
            }
        }
        return query;
    }

    private StringBuilder doBuildQuery(Map<String, ?> searchCriteria, boolean andFlag, List<String> orderByList) {
        StringBuilder queryString = doBuildWhereClause(searchCriteria, andFlag);

        doBuildOrderByClause(orderByList, queryString);
        return queryString;
    }

    private void doBuildOrderByClause(List<String> orderByList, StringBuilder queryString) {
        if (isNotEmpty(orderByList)) {
            queryString.append(" order by ");
            Iterator<String> orderIterator = orderByList.iterator();
            while (orderIterator.hasNext()) {
                String columnName = orderIterator.next();
                queryString.append(getAlias()).append(".").append(columnName);
                if (orderIterator.hasNext()) {
                    queryString.append(" , ");
                }
            }
        }
    }

    private StringBuilder doBuildLimitQuery(Map<String, Object> searchCriteria, boolean andFlag, List<String> orderByList) {

        StringBuilder queryString = doBuildWhereClause(searchCriteria, andFlag);

        if (isNotEmpty(searchCriteria)) {
            queryString.append(getMaxLimitText(" and "));
        } else {
            queryString.append(getMaxLimitText(" where "));
        }

        doBuildOrderByClause(orderByList, queryString);
        return queryString;
    }

    private StringBuilder doBuildWhereClause(Map<String, ?> searchCriteria, boolean andFlag) {
        validateFields(searchCriteria, getBeanClass());
        String alias = getAlias();
        Class beanClass = getBeanClass();
        StringBuilder queryString = new StringBuilder("select " + alias + " from " + alias + " in " + beanClass);
        if (isNotEmpty(searchCriteria)) {
            queryString.append(" where (");
            Iterator<? extends Map.Entry<String, ?>> iterator = searchCriteria.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, ?> entry = iterator.next();
                String key = entry.getKey();
                Object value = entry.getValue();

                queryString.append(alias).append(".").append(key);
                if (value == null) {
                    queryString.append(" is null ");
                } else if (value.getClass().equals(String.class) && value.toString().indexOf('*') > -1) {
                    queryString.append(" like '");
                    queryString.append(value.toString().replace('*', '%'));
                    queryString.append("'");
                } else {
                    queryString.append(" = :").append(key);
                }
                if (iterator.hasNext()) {
                    if (andFlag) {
                        queryString.append(" and ");
                    } else {
                        queryString.append(" or ");
                    }
                }
            }
            queryString.append(" )");
        }
        return queryString;
    }

    private void validateFields(Map<String, ?> searchCriteria, Class beanClass) {
        if (!getEnableDebug() || isEmpty(searchCriteria)) {
            return;
        }
        Method[] methods = beanClass.getMethods();
        Map<String, Method> getMethodNames = new HashMap<String, Method>();
        Map<String, Method> setMethodNames = new HashMap<String, Method>();
        for (Method method : methods) {
            String name = method.getName();
            if (name.startsWith("get") || name.startsWith("is") || name.startsWith("has")) {
                getMethodNames.put(name, method);
            } else if (name.startsWith("set")) {
                setMethodNames.put(name, method);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, ?> entry : searchCriteria.entrySet()) {
            String getterMethod = StringUtil.getGetterMethod(entry.getKey());
            String setterMethod = StringUtil.getSetterMethod(entry.getKey());
            Method getMethod = getMethodNames.get(getterMethod);
            Method setMethod = setMethodNames.get(setterMethod);
            if (getMethod != null && setMethod != null) {
                Object searchCriteriaValue = entry.getValue();
                if (searchCriteriaValue != null
                        && !searchCriteriaValue.getClass().isAssignableFrom(getMethod.getReturnType())) {
                    builder.append("Error -- Parameter Name= " + entry.getKey() + "; Value= " + searchCriteriaValue + "; Class= " + searchCriteriaValue.getClass() +
                            ";Getter Method Name= " + getMethod.getName() + "; Return Type= " + getMethod.getReturnType());
                    builder.append("\n");
                }
            } else {
                if (getMethod == null) {
                    builder.append("Error -- Parameter Name= " + entry.getKey() + " Getter Method is not found");
                } else {
                    builder.append("Error -- Parameter Name= " + entry.getKey() + " Setter Method is not found");
                    builder.append("\n");
                }
            }
        }
        if (builder.length() > 0) {
            throw new IllegalArgumentException(builder.toString().trim());
        }
    }

    private String getMaxLimitText(String prefix) {
        int maxResults = getMaxResults();
        long maxOid = doGetMaxOid();
        if (maxOid > 0 && maxResults > 0 && maxOid > maxResults) {
            return prefix + "(" + getAlias() + ".oid > " + (maxOid - maxResults) + ")";
        }
        return "";
    }

    protected boolean isEmpty(Map searchCriteria) {
        return !isNotEmpty(searchCriteria);
    }

    protected boolean isNotEmpty(Map searchCriteria) {
        return searchCriteria != null && !searchCriteria.isEmpty();
    }

    protected boolean isNotEmpty(List orderByList) {
        return orderByList != null && !orderByList.isEmpty();
    }

    protected boolean isNotEmpty(String str) {
        return str != null && str.trim().length() > 0;
    }

    protected int getMaxResults() {
        return 500;
    }

    @Override
    public B getById(ID id) {
        List<B> list = find("id", id);
        if (isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<B> getAll() {
        return doFind(null, true, null, -1);
    }

    public boolean isDataModifiedAfter(Date lastKnownModificationDatetime) {
        Session session = getSession(false);
        String alias = getAlias();
        Class beanClass = getBeanClass();
        StringBuilder queryString = new StringBuilder("select count(*) from " + alias + " in " + beanClass + " where " + alias + ".modificationDatetime > :modificationDatetime");
        Query query = doCreateQuery(session, queryString, Collections.singletonMap("modificationDatetime", lastKnownModificationDatetime));
        List<B> list = queryList(query);
        if (list == null || list.isEmpty()) {
            return false;
        }
        Number number = (Number) list.get(0);
        return number != null && number.intValue() > 0;
    }

    protected abstract Class getBeanClass();

    private String getAlias() {
        if (beanClassSimpleName == null) {
            beanClassSimpleName = getBeanClass().getSimpleName();
            beanClassSimpleName = beanClassSimpleName.substring(0, 1).toLowerCase() + beanClassSimpleName.substring(1);
            if (beanClassSimpleName.endsWith("Bean")) {
                beanClassSimpleName = beanClassSimpleName.substring(0, beanClassSimpleName.length() - 4);
            }
        }
        return beanClassSimpleName;
    }

    protected String trim(String string) {
        if (string == null) {
            return string;
        }
        return string.trim();
    }

    public boolean getEnableDebug() {
        return enableDebug;
    }

    public void setEnableDebug(boolean enableDebug) {
        this.enableDebug = enableDebug;
    }
}
