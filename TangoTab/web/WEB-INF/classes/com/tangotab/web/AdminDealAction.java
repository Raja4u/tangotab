/**
 * 
 */
package com.tangotab.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.business.DealBO;
import com.tangotab.dao.pojo.DealTemplate;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.ImageSaveUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.DealForm;


public class AdminDealAction extends BaseDispatchAction {

	public static Logger log = LoggerFactory.getLogger(UserRegAction.class);
	private DealBO dealBo = com.tangotab.businessImpl.BusinessFactory.getDealBO();

	/* to create a deal */
	public ActionForward save(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);

		DealForm deal = (DealForm) form;

		String dealTempName = deal.getDealTemplateName();
		DealTemplate dealt = new DealTemplate();
		DealTemplate dealtemp = new DealTemplate();
		ActionMessages messages = new ActionMessages();
		try {

			deal.setIsActive((short) 1);
			deal.setDefaultCreditValue(1.0);

			String directionImgRealPath = getServlet().getServletContext().getRealPath("/")
					+ "images/deal/";
			BeanUtils.copyProperties(dealt, deal);
			dealt.setDealTemplateImgPath(ImageSaveUtility.saveFile(directionImgRealPath, deal
					.getAdminDealImage(), "adminDeal"));

			int status = dealBo.saveDealTemplate(dealt);
			dealtemp = dealBo.getDealTemplateByName(dealTempName);
			saveImageInWebApps(dealtemp.getDealTemplateId() + "_", deal.getAdminDealImage());

			if (status > 0) {
				return mapping.findForward(TangotabConstants.SUCCESS);
			}
		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward("success");
	}

	/* Deal set to ready for edit details */
	public ActionForward edit(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		log.debug("Entering retrieveDealAction");
		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);
		ActionMessages messages = new ActionMessages();

		int dealId = Integer.parseInt(request.getParameter("dealid"));

		DealForm deal = (DealForm) form;
		DealTemplate dealtemp = null;
		try {

			dealtemp = dealBo.getDealTemplateById(dealId);
			request.setAttribute("dealId", dealId);
			request.setAttribute("dealTemp", dealtemp);

			if (dealtemp == null) {
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			}
		} catch (ApplicationException e) {

			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	/* display deal templates */
	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		log.debug("Entering retrieveDealAction");
		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);
		ActionMessages messages = new ActionMessages();
		HttpSession session = request.getSession();
		ArrayList<DealTemplate> deal2 = null;
		try {
			deal2 = dealBo.getDealTemplates();
			session.setAttribute("deal", deal2);

			
		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);
	}

	/* updating the deal */
	public ActionForward Update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		String methodName = request.getParameter(mapping.getParameter());
		log.debug("Method Name: " + methodName);
		DealForm dealform = (DealForm) form;

		DealTemplate dealtemp = new DealTemplate();
		ActionMessages messages = new ActionMessages();
		try {
			
			BeanUtils.copyProperties(dealtemp, dealform);
			if (StringUtils.isNotEmpty(dealform.getAdminDealImage().getFileName())) {
				String directionImgRealPath = getServlet().getServletContext().getRealPath("/")
						+ "images/deal/";
				dealtemp.setDealTemplateImgPath(ImageSaveUtility.saveFile(directionImgRealPath,
						dealform.getAdminDealImage(), "adminDeal"));
			} else {
				dealtemp.setDealTemplateImgPath(dealtemp.getDealTemplateImgPath());
			}
			dealtemp.setDealTemplateId(dealform.getDealTemplateId());
			boolean deal = dealBo.updateDealTemplate(dealtemp);
			if (deal) {
				return mapping.findForward(TangotabConstants.SUCCESS);
			}
		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward("updateSuccess");

	}

	/* save deal image in server */
	private boolean saveImageInWebApps(String imageSubPath, FormFile image) {
		try {
			String fileName = image.getFileName();
			String directionImgRealPath = getServlet().getServletContext().getRealPath("/")
					+ "images/deal/";
			if (!fileName.equals("")) {
				File fileToCreate = new File(directionImgRealPath, imageSubPath + fileName);

				if (fileToCreate.exists()) {
					fileToCreate.delete();
					fileToCreate = new File(directionImgRealPath, imageSubPath + fileName);
				}
				FileOutputStream fileOutStream = new FileOutputStream(fileToCreate);
				fileOutStream.write(image.getFileData());
				fileOutStream.flush();
				fileOutStream.close();
			}
		} catch (FileNotFoundException file) {
			return false;
		} catch (IOException io) {
			return false;
		}
		return true;
	}
}