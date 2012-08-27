package com.tangotab.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.business.DealBO;
import com.tangotab.dao.pojo.AdminDealImage;
import com.tangotab.dao.pojo.DealName;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.ImageSaveUtility;
import com.tangotab.web.form.AdminDealImageForm;

public class DealImagesAction extends BaseDispatchAction {

	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		DealBO dealBo = com.tangotab.businessImpl.BusinessFactory.getDealBO();
		ActionMessages messages = new ActionMessages();
		ArrayList<DealName> dealnames = null;
		AdminDealImageForm imageform = (AdminDealImageForm) form;
		Integer nameId = 0;
		try {
			ArrayList<AdminDealImage> images = null;
			dealnames = (ArrayList<DealName>) dealBo.getAllDealNames();

			if (dealnames == null || dealnames.size() == 0) {
				messages.add("No Records",
						new ActionMessage("result.noRecords", "No Records Found"));
				saveMessages(request, messages);
			} else {

				if (imageform.getNameId() == null)
					nameId = dealnames.get(0).getNameId();
				else
					nameId = imageform.getNameId();
			}
			images = dealBo.getDealImagesByDealNameId(nameId);
			imageform.setNameId(nameId);
			request.setAttribute("dealnames", dealnames);
			request.setAttribute("images", images);

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return mapping.findForward("success");
	}

	public ActionForward Upload(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		DealBO dealBo = com.tangotab.businessImpl.BusinessFactory.getDealBO();
		AdminDealImageForm imageform = (AdminDealImageForm) form;
		AdminDealImage imagepojo = new AdminDealImage();
		DealName dname = new DealName();
		ArrayList<DealName> dealnames = null;
		Integer nameId = 0;
		try {
			if (imageform.getAdminDealImage() != null
					&& imageform.getAdminDealImage().getFileName().length() > 0) {

				String directionImgRealPath = getServlet().getServletContext().getRealPath("/")
						+ "images/deal/";
				imageform.setImagePath(ImageSaveUtility.saveFile(directionImgRealPath, imageform
						.getAdminDealImage(), "adminDeal"));
				imagepojo.setImagePath(imageform.getImagePath());
				if (imageform.getNameId() == null)
					dname.setNameId(Integer.parseInt("8"));
				else {
					nameId = imageform.getNameId();
					dname.setNameId(nameId);
				}

				imagepojo.setDealName(dname);
				int id = dealBo.saveAdminDealImage(imagepojo);
			}
			ArrayList<AdminDealImage> images = null;

			images = dealBo.getDealImagesByDealNameId(nameId);
			dealnames = (ArrayList<DealName>) dealBo.getAllDealNames();
			request.setAttribute("images", images);
			request.setAttribute("dealnames", dealnames);

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		imageform.setAdminDealImage(null);
		return mapping.findForward("success");
	}

	public ActionForward Delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		DealBO dealBo = com.tangotab.businessImpl.BusinessFactory.getDealBO();
		AdminDealImageForm imageform = (AdminDealImageForm) form;
		AdminDealImage imagepojo = new AdminDealImage();
		ArrayList<DealName> dealnames = null;
		Integer nameId = 0;

		try {
			nameId = imageform.getNameId();
			/*
			 * holds imageId values upon select checkbox, the value changed from one to ImageId
			 * using javascript buttons[] contains only selected checkbox values
			 */
			String buttons[] = request.getParameterValues("button");
			if (buttons != null) {
				for (int i = 0; i < buttons.length; i++) {
					imagepojo = dealBo.getDealImgById(Integer.parseInt(buttons[i]));
					dealBo.deleteDealImage(imagepojo);
				}
			}
			ArrayList<AdminDealImage> images = null;
			images = dealBo.getDealImagesByDealNameId(nameId);
			dealnames = (ArrayList<DealName>) dealBo.getAllDealNames();

			request.setAttribute("images", images);
			request.setAttribute("dealnames", dealnames);

		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return mapping.findForward("success");
	}
}
