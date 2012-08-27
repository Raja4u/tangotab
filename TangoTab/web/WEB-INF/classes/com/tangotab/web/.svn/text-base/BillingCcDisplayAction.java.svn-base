package com.tangotab.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.tangotab.TO.BillingCcTO;
import com.tangotab.TO.UserTO;
import com.tangotab.business.UserBO;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.DateConverterUtility;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.DateForm;

public class BillingCcDisplayAction extends BaseAction {

	private UserBO userBO = com.tangotab.businessImpl.BusinessFactory.getUserBO();

	@Override
	public ActionForward performExecute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String purchasedDate = "NO"; // for differentiating view all and view by date

		if (mapping.getPath().equals("/jsp/billingSummary")) { // path to view all
			purchasedDate = "NO";

			ActionMessages actionMessages = new ActionMessages();
			try {

				HttpSession session = request.getSession();
				UserTO useTO = (UserTO) session.getAttribute("userInfo");
				Integer Rid = useTO.getRestaurantId();

				Integer Uid = useTO.getUserId();
				Double amount = 0.0;

				ArrayList<BillingCcTO> bill = userBO.getBillingSummary(Rid);
				if (bill == null || bill.size() == 0) {
					actionMessages.add("No Records", new ActionMessage("result.noRecords",
							"No Records Found"));
					saveMessages(request, actionMessages);
				}
				if (bill != null && bill.size() > 0) {
					request.setAttribute("size", bill.size()); // set size of list
					for (BillingCcTO bil : bill) {
						amount += bil.getDoubleAmount();
					}
				}
				session.setAttribute("bill", bill); // All results are session scoped
				request.setAttribute("purchasedDate", purchasedDate);
				request.setAttribute("total", amount);

			} catch (ApplicationException e) {
				actionMessages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
				saveMessages(request, actionMessages);
			}
			return mapping.findForward(TangotabConstants.SUCCESS);

		} else if (mapping.getPath().equals("/jsp/billingSearch")) // path to view by Date
		{
			purchasedDate = "YES";
			ActionMessages actionMessages = new ActionMessages();
			ArrayList<BillingCcTO> purchaseDate = new ArrayList<BillingCcTO>();
			Double amount = 0.0;

			try {
				HttpSession session = request.getSession();
				ArrayList<BillingCcTO> bill = null;
				bill = (ArrayList) session.getAttribute("bill"); // getting data from session scoped
																	// deals (all)

				DateForm df = (DateForm) form;
				Date startDate = null;
				Date endDate = null;
				if (df.getStartDate() != null) {
					startDate = DateConverterUtility.convertUiToServiceDate(df.getStartDate());
				}
				if (df.getStartDate() != null) {
					endDate = DateConverterUtility.convertUiToServiceDate(df.getEndDate());
				}

				Iterator<BillingCcTO> iter = bill.iterator();
				while (iter.hasNext()) {
					BillingCcTO crTO = iter.next();
					Date d = DateConverterUtility.convertUiToServiceDate(crTO.getPurchasedDate());

					if (startDate != null && endDate != null) {
						int s = d.compareTo(startDate);
						int e = d.compareTo(endDate);

						if (s >= 0 && e <= 0) // compare all dates with entered dates
						{
							purchaseDate.add(crTO); // insert deal in to list & put this crTO in to
													// targetList

						}
					} else if (startDate != null && endDate == null) {
						int s = d.compareTo(startDate);
						if (s >= 0) // compare all dates with entered dates
						{
							purchaseDate.add(crTO); // insert deal in to list & put this crTO in to
													// targetList
						}
					} else if (startDate == null && endDate != null) {
						int e = d.compareTo(endDate);
						if (e <= 0) // compare all dates with entered dates
						{
							purchaseDate.add(crTO); // insert deal in to list & put this crTO in to
													// targetList

						}
					} else if (startDate == null && endDate == null) {
						purchaseDate.add(crTO);
					}

				}
				if (purchaseDate == null || purchaseDate.size() == 0) {
					actionMessages.add("No Records", new ActionMessage("result.noRecords",
							"No Records Found"));
					saveMessages(request, actionMessages);
				}
				if (purchaseDate != null && purchaseDate.size() > 0) {
					request.setAttribute("size", purchaseDate.size()); // set size of list
					for (BillingCcTO bil : purchaseDate) {
						amount += bil.getDoubleAmount(); // adding up amount
					}
				}
				request.setAttribute("purchaseDate", purchaseDate); // view details according to
																	// request scope
				request.setAttribute("purchasedDate", purchasedDate);
				request.setAttribute("total", amount);

			} catch (Exception e) {
			}
			return mapping.findForward("searchfound"); // going to view after search by date
		} else {
			return mapping.findForward(TangotabConstants.SUCCESS);
		}
	}

}
