package com.tangotab.businessImpl;

import com.tangotab.TO.DealDescriptionTO;
import com.tangotab.business.DealBO;
import com.tangotab.dao.DealDAO;
import com.tangotab.dao.pojo.AdminDealImage;
import com.tangotab.dao.pojo.DealDescription;
import com.tangotab.dao.pojo.DealName;
import com.tangotab.dao.pojo.DealRestriction;
import com.tangotab.dao.pojo.DealTemplate;
import com.tangotab.exception.ApplicationException;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class DealBOImpl implements DealBO {

	public static Logger log = LoggerFactory.getLogger(DealBOImpl.class);

    @Autowired
    protected DealDAO dealDAO;

    /**
	 *  Save Deal Template
	 * 
	 */
	public int saveDealTemplate(DealTemplate deal) throws ApplicationException {

		try {

			return getDealDAO().saveDealTemplate(deal);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;

		}

	}

    private DealDAO getDealDAO() {
        return dealDAO;
    }

    /**
	 *  Update Deal Template
	 * 
	 */
	public boolean updateDealTemplate(DealTemplate deal) throws ApplicationException {
		try {
			
			return getDealDAO().updateDealTemplate(deal);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 *  Get  Deal Template
	 * 
	 */
	public DealTemplate getDealTemplateById(int dealTemplateId) throws ApplicationException {
		DealTemplate deal = null;
		try {
			deal = getDealDAO().getDealTemplateById(dealTemplateId);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
		return deal;
	}
	/**
	 *  Get All Deal Templates
	 * 
	 */
	public ArrayList<DealTemplate> getDealTemplates() throws ApplicationException {
		try {
			return getDealDAO().getDealTemplates();
		} catch (ApplicationException e) {
			if (log.isErrorEnabled()) {
				log.error("Got following error while retrieving deal templates, Message: "
						+ e.getMessage());
			}
			throw e;
		}
	}
	/**
	 *  Get Deal Template by deal template name
	 * 
	 */
	public DealTemplate getDealTemplateByName(String dealTemplateName) throws ApplicationException {
		DealTemplate deal = null;
		try {
			deal = getDealDAO().getDealTemplateByName(dealTemplateName);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
		return deal;
	}

	/**
	 *  Get all Deal Restrictions
	 * 
	 */
	public ArrayList<DealRestriction> getAllRestrictions() throws ApplicationException {
		ArrayList<DealRestriction> dealrest = null;
		try {
			dealrest = getDealDAO().getAllRestrictions();
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
		return dealrest;
	}
	/**
	 *  Set  Deal Restriction status
	 * 
	 */
	public boolean setRestrictionStatus(Integer restrictionId, Short status)
			throws ApplicationException {

		try {
			return getDealDAO().setRestrictionStatus(restrictionId, status);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 *  Save Deal Restriction
	 * 
	 */
	public int saveRestriction(DealRestriction restriction) throws ApplicationException {

		try {
			return getDealDAO().saveRestriction(restriction);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 *  Update Deal Restriction
	 * 
	 */
	public int updateRestriction(DealRestriction restriction) throws ApplicationException {

		try {
			return getDealDAO().updateRestriction(restriction);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 *  Get Deal Restriction
	 * 
	 */
	public DealRestriction getRestrictionById(Integer rid) throws ApplicationException {

		try {
			return getDealDAO().getRestrictionById(rid);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 *  Get  all Deal Names
	 * 
	 */

	public ArrayList<DealName> getAllDealNames() throws ApplicationException {
		ArrayList<DealName> dealrest = null;
		try {
			dealrest = getDealDAO().getAllDealNames();
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
		return dealrest;
	}
	/**
	 *  Set   Deal Name status
	 * 
	 */
	public boolean setDealNameStatus(Integer nameId, Short status) throws ApplicationException {

		try {
			return getDealDAO().setDealNameStatus(nameId, status);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 *  Save   Deal Name 
	 * 
	 */
	public int saveDealName(DealName dealName) throws ApplicationException {

		try {
			return getDealDAO().saveDealName(dealName);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 *  Update   Deal Name 
	 * 
	 */
	public int updateDealName(DealName dealName) throws ApplicationException {

		try {
			return getDealDAO().updateDealName(dealName);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 *  Get   Deal Name 
	 * 
	 */
	public DealName getNameById(Integer nid) throws ApplicationException {

		try {
			return getDealDAO().getNameById(nid);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 *  Save   Deal Description  
	 * 
	 */
	public int saveDealDesc(DealDescription dealdesc) throws ApplicationException {

		try {
			return getDealDAO().saveDealDesc(dealdesc);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 *  Get   Deal Description  
	 * 
	 */
	public DealDescription getDealDescById(Integer did) throws ApplicationException {

		try {
			return getDealDAO().getDealDescById(did);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 *  Update   Deal Description  
	 * 
	 */
	public boolean updateDealDesc(DealDescription dealdesc) throws ApplicationException {

		try {
			return getDealDAO().updateDealDesc(dealdesc);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 *  Set   Deal Description status  
	 * 
	 */
	public boolean setDealDescStatus(Integer descId, Short status) throws ApplicationException {

		try {
			return getDealDAO().setDealDescStatus(descId, status);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 *  Get   Deal Descriptions  
	 * 
	 */
	public ArrayList<String> getAllDealImages() throws ApplicationException {

		ArrayList<String> list = null;
		ArrayList<String> images = new ArrayList<String>();
		try {
			list = getDealDAO().getAllDealImages();
			for (String img : list) {
				if (img != null)
					images.add(img);
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
		return images;
	}
	/**
	 *  Get   All Deal Images  
	 * 
	 */
	public ArrayList<AdminDealImage> getAdminDealImages() throws ApplicationException {

		try {
			return getDealDAO().getAdminDealImages();
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}

	}
	/**
	 *  Set    Deal Images  status
	 * 
	 */
	public int saveAdminDealImage(AdminDealImage image) throws ApplicationException {

		try {
			return getDealDAO().saveAdminDealImage(image);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}

	}
	/**
	 *  Get all    Deal Descriptions  by Deal Name
	 * 
	 */
	public ArrayList<DealDescriptionTO> getDealDescriptionsByNameId(String dealName)
			throws ApplicationException {

		ArrayList<DealDescription> templates = getDealDAO().getDealDescriptionsByNameId(dealName);
		ArrayList<DealDescriptionTO> dealtemplates = new ArrayList<DealDescriptionTO>();
		for (DealDescription template : templates) {
			DealDescriptionTO deal = new DealDescriptionTO();
			try {
				BeanUtils.copyProperties(deal, template);
			} catch (Exception e) {
				e.printStackTrace();
			}
			dealtemplates.add(deal);
		}
		return dealtemplates;

	}
	/**
	 *  Delete    Deal Images   
	 * 
	 */
	public boolean deleteDealImage(AdminDealImage image) throws ApplicationException {

		try {
			return getDealDAO().deleteDealImage(image);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 *  Get    Deal Images   
	 * 
	 */
	public AdminDealImage getDealImgById(Integer did) throws ApplicationException {

		try {
			return getDealDAO().getDealImgById(did);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * Get  All    Deal Images    by Deal Name
	 * 
	 */
	public ArrayList<AdminDealImage> getDealImagesByDealName(String dealname)
			throws ApplicationException {

		try {
			return getDealDAO().getDealImagesByDealName(dealname);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}
	/**
	 * Get  All    Deal Images   by deal id 
	 * 
	 */
	public ArrayList<AdminDealImage> getDealImagesByDealNameId(Integer nameId)
			throws ApplicationException {

		try {
			return getDealDAO().getDealImagesByDealNameId(nameId);
		} catch (ApplicationException e) {
			e.printStackTrace();
			throw e;
		}
	}

    @Override
    public ArrayList<DealDescription> getAllDealDesc(Integer nameId) throws ApplicationException {
        return getDealDAO().getAllDealDesc(nameId);
    }

}
