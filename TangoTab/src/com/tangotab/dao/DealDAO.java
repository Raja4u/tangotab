/**
 * 
 */
package com.tangotab.dao;

import java.util.ArrayList;

import com.tangotab.dao.pojo.AdminDealImage;
import com.tangotab.dao.pojo.DealDescription;
import com.tangotab.dao.pojo.DealName;
import com.tangotab.dao.pojo.DealRestriction;
import com.tangotab.dao.pojo.DealTemplate;
import com.tangotab.exception.ApplicationException;

/**
 * @author durga
 * 
 */
public interface DealDAO {

	public int saveDealTemplate(DealTemplate deal) throws ApplicationException;

	public boolean updateDealTemplate(DealTemplate deal) throws ApplicationException;

	public ArrayList<DealTemplate> getDealTemplates() throws ApplicationException;

	public DealTemplate getDealTemplateById(int dealTemplateId) throws ApplicationException;

	public DealTemplate getDealTemplateByName(String dealTemplateName) throws ApplicationException;

	public ArrayList<DealRestriction> getAllRestrictions() throws ApplicationException;

	public boolean setRestrictionStatus(Integer restrictionId, Short status)
			throws ApplicationException;

	public int saveRestriction(DealRestriction restriction) throws ApplicationException;

	public int updateRestriction(DealRestriction restriction) throws ApplicationException;

	public DealRestriction getRestrictionById(Integer rid) throws ApplicationException;

	public ArrayList<DealName> getAllDealNames() throws ApplicationException;

	public boolean setDealNameStatus(Integer nameId, Short status) throws ApplicationException;

	public int saveDealName(DealName dealName) throws ApplicationException;

	public int updateDealName(DealName dealName) throws ApplicationException;

	public DealName getNameById(Integer nid) throws ApplicationException;

	public ArrayList<DealDescription> getAllDealDesc(Integer nameId) throws ApplicationException;

	public int saveDealDesc(DealDescription dealdesc) throws ApplicationException;

	public DealDescription getDealDescById(Integer did) throws ApplicationException;

	public boolean updateDealDesc(DealDescription dealdesc) throws ApplicationException;

	public boolean setDealDescStatus(Integer descId, Short status) throws ApplicationException;

	public ArrayList<String> getAllDealImages() throws ApplicationException;

	public ArrayList<AdminDealImage> getAdminDealImages() throws ApplicationException;

	public int saveAdminDealImage(AdminDealImage image) throws ApplicationException;

	public ArrayList<DealDescription> getDealDescriptionsByNameId(String dealName)
			throws ApplicationException;

	public AdminDealImage getDealImgById(Integer did) throws ApplicationException;

	public boolean deleteDealImage(AdminDealImage image) throws ApplicationException;

	public ArrayList<AdminDealImage> getDealImagesByDealName(String dealname)
			throws ApplicationException;

	public ArrayList<AdminDealImage> getDealImagesByDealNameId(Integer nameId)
			throws ApplicationException;
}