package com.tangotab.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.tangotab.exception.ApplicationException;

/**
 * Created by IntelliJ IDEA.
 * User: Admin
 * Date: 7/7/12
 * Time: 3:39 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BaseDAO<B, ID extends Serializable> {
    ID save(B bean) throws ApplicationException;

    void update(B bean) throws ApplicationException;

    void merge(B bean) throws ApplicationException;

    B findFirst(String propertyName, Object propertyValue) throws ApplicationException;

    List<B> find(String propertyName, Object propertyValue) throws ApplicationException;

    List<B> find(Map<String, Object> searchCriteria) throws ApplicationException;

    List<B> find(Map<String, Object> searchCriteria, boolean andFlag, String... orderByList) throws ApplicationException;

    B getById(ID id) throws ApplicationException;

    List<B> getAll() throws ApplicationException;
}
