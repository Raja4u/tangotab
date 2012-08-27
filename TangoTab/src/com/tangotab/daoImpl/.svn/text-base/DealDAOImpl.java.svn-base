/**
 * 
 */
package com.tangotab.daoImpl;

import com.tangotab.dao.DealDAO;
import com.tangotab.dao.pojo.AdminDealImage;
import com.tangotab.dao.pojo.DealDescription;
import com.tangotab.dao.pojo.DealName;
import com.tangotab.dao.pojo.DealRestriction;
import com.tangotab.dao.pojo.DealTemplate;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author techgene
 * 
 */
@Component
public class DealDAOImpl extends TempDAOImpl implements DealDAO {
	private static Logger log = LoggerFactory.getLogger(DealDAOImpl.class);

	/**
	 * 
	 * @param save
	 *            dealTemplate
	 * @return
	 * @throws ApplicationException
	 */
	public int saveDealTemplate(DealTemplate deal) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveDealTemplate ");
		Session session = getSession(false);
		//Transaction //transaction = session.beginTransaction();

		try {
			session.save(deal);
			//////transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveDeal" + e.getMessage());
			}
			e.printStackTrace();
			//////transaction.rollback();

			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//////session.close();
		}
		return 1;
	}

	/**
	 * 
	 * @param update
	 *            dealTemplate
	 * @return
	 * @throws ApplicationException
	 */

	public boolean updateDealTemplate(DealTemplate deal) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveCuisine ");
		Session session = getSession(false);
		//Transaction //transaction = session.beginTransaction();
		try {
			session = getSession(false);
			//transaction = session.beginTransaction();
			session.merge(deal);
			//////transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveConsumer" + e.getMessage());
			}
			e.printStackTrace();
			//////transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//////session.close();
		}
		return false;
	}

	/**
	 * 
	 * @param get
	 *            all dealTemplates
	 * @return
	 * @throws ApplicationException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<DealTemplate> getDealTemplates() throws ApplicationException {

		if (log.isDebugEnabled())
			log.debug("Start of getDealTemplates() ");
		Session session = getSession(false);
		ArrayList<DealTemplate> dealTemp = null;
		Criteria criteria = session.createCriteria(DealTemplate.class);
		dealTemp = (ArrayList<DealTemplate>) criteria.list();
		//////session.close();
		return dealTemp;
	}

	/**
	 * 
	 * @param get
	 *            dealTemplates
	 * @return
	 * @throws ApplicationException
	 */
	@SuppressWarnings("unchecked")
	public DealTemplate getDealTemplateById(int dealTemplateId) throws ApplicationException {

		DealTemplate deal = null;
		Session session = getSession(false);
		try {

			Criteria criteria = session.createCriteria(DealTemplate.class).add(
					Restrictions.eq("dealTemplateId", dealTemplateId));

			List dealTemplate = (ArrayList<DealTemplate>) criteria.list();
			if (dealTemplate.size() == 1) {
				if (dealTemplate.iterator().hasNext()) {

					deal = (DealTemplate) dealTemplate.iterator().next();

				}
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in get deal template" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//////session.close();
		}
		return deal;
	}
/*
 * Search By Get Deal Template  
 */
	@SuppressWarnings("unchecked")
	public DealTemplate getDealTemplateByName(String dealTemplateName) throws ApplicationException {

		DealTemplate deal = null;
		Session session = getSession(false);
		try {

			Criteria criteria = session.createCriteria(DealTemplate.class).add(
					Restrictions.eq("dealTemplateName", dealTemplateName));

			List dealTemplate = (ArrayList<DealTemplate>) criteria.list();
			if (dealTemplate.size() == 1) {
				if (dealTemplate.iterator().hasNext()) {

					deal = (DealTemplate) dealTemplate.iterator().next();

				}
			}
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in get deal template" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//////session.close();
		}
		return deal;
	}

	/* methods for deal restrictions */

	@SuppressWarnings("unchecked")
	public ArrayList<DealRestriction> getAllRestrictions() throws ApplicationException {

		ArrayList<DealRestriction> dealrest = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(DealRestriction.class);
			dealrest = (ArrayList<DealRestriction>) criteria.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getting deal restrictions" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//////session.close();
		}

		return dealrest;
	}
/*   Set Restriction Status 
 */
	public boolean setRestrictionStatus(Integer restrictionId, Short status)
			throws ApplicationException {
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			SQLQuery query = session
					.createSQLQuery(TangotabConstants.RESTRICTION_STATUS_UPDATE_QUERY);
			query.setInteger(0, status);
			query.setInteger(1, restrictionId);

			int rows = query.executeUpdate();
			//transaction.commit();
			if (rows == 1) {
				return true;
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			//transaction.rollback();
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return false;
	}
/*
 * Save Restriction 
 */
	public int saveRestriction(DealRestriction restriction) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveLocationManager ");
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			session.save(restriction);
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveLocationManagerr" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return restriction.getRestrictionId();
	}
/*
 * Update Restriction 
 */
	public int updateRestriction(DealRestriction restriction) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveLocationManager ");
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			session.update(restriction);
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveLocationManagerr" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return restriction.getRestrictionId();
	}
/*
 * Get Restriction By Restriction 
 * 
 */
	public DealRestriction getRestrictionById(Integer rid) throws ApplicationException {

		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		DealRestriction dealrest = new DealRestriction();
		try {
			Criteria criteria = session.createCriteria(DealRestriction.class).add(
					Restrictions.eq("restrictionId", rid));
			dealrest = (DealRestriction) criteria.uniqueResult();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveLocationManagerr" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return dealrest;
	}

	/* methods for deal names for admin section */

	@SuppressWarnings("unchecked")
	public ArrayList<DealName> getAllDealNames() throws ApplicationException {

		ArrayList<DealName> dealnames = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(DealName.class);
			dealnames = (ArrayList<DealName>) criteria.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getting deal restrictions" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}

		return dealnames;
	}
/*set Deal name status
 */
	public boolean setDealNameStatus(Integer nameId, Short status) throws ApplicationException {
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.DEALNAME_STATUS_UPDATE_QUERY);
			query.setInteger(0, status);
			query.setInteger(1, nameId);

			int rows = query.executeUpdate();
			//transaction.commit();
			if (rows == 1) {
				return true;
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			//transaction.rollback();
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);

		} finally {
			//session.close();
		}
		return false;
	}
/*
 * save Deal Name
 */
	public int saveDealName(DealName dealName) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveLocationManager ");
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			session.save(dealName);
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in savedealname" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return dealName.getNameId();
	}
/*
 * Update Deal Name
 */
	public int updateDealName(DealName dealName) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of saveLocationManager ");
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			session.update(dealName);
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveLocationManagerr" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return dealName.getNameId();
	}
/*
 * get Deal Name BY name Id 
 */
	public DealName getNameById(Integer nid) throws ApplicationException {

		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		DealName dealnames = new DealName();
		try {
			Criteria criteria = session.createCriteria(DealName.class).add(
					Restrictions.eq("nameId", nid));
			dealnames = (DealName) criteria.uniqueResult();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveLocationManagerr" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return dealnames;
	}

	/* deal description */
	@SuppressWarnings("unchecked")
	public ArrayList<DealDescription> getAllDealDesc(Integer nameId) throws ApplicationException {

		ArrayList<DealDescription> dealdesc = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(DealDescription.class, "dealdesc");

			if (nameId != null && nameId > 0) {
				criteria.createAlias("dealdesc.dealName", "dealName").add(
						Restrictions.eq("dealName.nameId", nameId));
			}
			dealdesc = (ArrayList<DealDescription>) criteria.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getting deal restrictions" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}

		return dealdesc;
	}
/* Save Deal Description 
 */
	public int saveDealDesc(DealDescription dealdesc) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of updateLocation");
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			session.save(dealdesc);
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in updateLocation" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return dealdesc.getDescriptionId();
	}
/*
 * Get Deal Description 
 */
	public DealDescription getDealDescById(Integer did) throws ApplicationException {

		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		DealDescription dealdesc = new DealDescription();
		try {
			Criteria criteria = session.createCriteria(DealDescription.class).add(
					Restrictions.eq("descriptionId", did));
			dealdesc = (DealDescription) criteria.uniqueResult();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveLocationManagerr" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return dealdesc;
	}
/*
 * Update Deal Description 
 */
	public boolean updateDealDesc(DealDescription dealdesc) throws ApplicationException {
		if (log.isDebugEnabled())
			log.debug("Start of updateLocation");
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		boolean b = false;
		try {
			session.update(dealdesc);
			//transaction.commit();
			b = true;
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in updateLocation" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);

		} finally {
			//session.close();
		}
		return b;
	}
/*
 * 
 * Set Deal Description Status 
 */
	public boolean setDealDescStatus(Integer descId, Short status) throws ApplicationException {
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.DEALDESC_STATUS_UPDATE_QUERY);
			query.setInteger(0, status);
			query.setInteger(1, descId);

			int rows = query.executeUpdate();
			//transaction.commit();
			if (rows == 1) {
				return true;
			}
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			//transaction.rollback();
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return false;
	}
/*
 * Get All Deal Images
 */
	@SuppressWarnings("unchecked")
	public ArrayList<String> getAllDealImages() throws ApplicationException {
 
		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		ArrayList<String> list = null;
		try {
			SQLQuery query = session.createSQLQuery(TangotabConstants.GET_ALL_DEAL_IMAGES);
			list = (ArrayList<String>) query.list();
			//transaction.commit();
		} catch (Exception ex) {
			if (log.isErrorEnabled()) {
				log.error(ex.getMessage());
			}
			//transaction.rollback();
			ex.printStackTrace();
			throw new ApplicationException("DB002", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return list;

	}
/* Get Admin Deal Images
 */
	@SuppressWarnings("unchecked")
	public ArrayList<AdminDealImage> getAdminDealImages() throws ApplicationException {

		ArrayList<AdminDealImage> dealimages = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(AdminDealImage.class);

			dealimages = (ArrayList<AdminDealImage>) criteria.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getting deal restrictions" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return dealimages;
	}
/*
 * get Deal ImagesbyDeal Name by particular image name   
 */
	@SuppressWarnings("unchecked")
	public ArrayList<AdminDealImage> getDealImagesByDealName(String dealname)
			throws ApplicationException {

		Session session = getSession(false);
		ArrayList<AdminDealImage> imageList = null;
		try {
			Criteria criteria = session.createCriteria(AdminDealImage.class, "dealImage")
					.createAlias("dealImage.dealName", "dealname").add(
							Restrictions.eq("dealname.name", dealname));
			imageList = (ArrayList<AdminDealImage>) criteria.list();

		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getting deal restrictions" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return imageList;
	}
/*
 * get Deal Image By Deal Name
 */
	@SuppressWarnings("unchecked")
	public ArrayList<AdminDealImage> getDealImagesByDealNameId(Integer nameId)
			throws ApplicationException {

		Session session = getSession(false);
		ArrayList<AdminDealImage> imageList = null;
		try {
			Criteria criteria = session.createCriteria(AdminDealImage.class, "dealImage")
					.createAlias("dealImage.dealName", "dealname").add(
							Restrictions.eq("dealname.nameId", nameId));
			imageList = (ArrayList<AdminDealImage>) criteria.list();

		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getting deal restrictions" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return imageList;

	}
/*
 * Save Admin Deal Image
 */
	public int saveAdminDealImage(AdminDealImage image) throws ApplicationException {

		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			session.save(image);
			//transaction.commit();

		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getting deal restrictions" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return image.getImageId();
	}
/*
 * Get the Deal Description By name 
 */
	@SuppressWarnings("unchecked")
	public ArrayList<DealDescription> getDealDescriptionsByNameId(String dealName)
			throws ApplicationException {

		ArrayList<DealDescription> dealdesc = null;
		Session session = getSession(false);
		try {
			Criteria criteria = session.createCriteria(DealDescription.class, "dealdesc")
					.createAlias("dealdesc.dealName", "dealname").add(
							Restrictions.eq("dealname.name", dealName))
							.add(
							Restrictions.eq("dealdesc.isActive", (short)1));

			dealdesc = (ArrayList<DealDescription>) criteria.list();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getting deal restrictions" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return dealdesc;
	}
/*
 * Get Deal Image by deal ID
 */
	public AdminDealImage getDealImgById(Integer did) throws ApplicationException {

		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		AdminDealImage dealdesc = new AdminDealImage();
		try {
			Criteria criteria = session.createCriteria(AdminDealImage.class).add(
					Restrictions.eq("imageId", did));
			dealdesc = (AdminDealImage) criteria.uniqueResult();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in saveLocationManagerr" + e.getMessage());
			}
			e.printStackTrace();
			//transaction.rollback();
			throw new ApplicationException("DB001", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return dealdesc;
	}
/*
 * 
 * Delete Deal Image 
 */
	public boolean deleteDealImage(AdminDealImage image) throws ApplicationException {

		Session session = getSession(false);
		//Transaction transaction = session.beginTransaction();
		try {
			session.delete(image);
			//transaction.commit();
		} catch (Exception e) {
			if (log.isErrorEnabled()) {
				log.error("Error occured in getting deal restrictions" + e.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("DB003", TangotabConstants.ERROR);
		} finally {
			//session.close();
		}
		return true;
	}
}
