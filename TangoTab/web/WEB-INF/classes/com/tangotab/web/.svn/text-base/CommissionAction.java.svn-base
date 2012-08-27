package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tangotab.business.CommissionBO;
import com.tangotab.dao.pojo.CommissionRate;
import com.tangotab.exception.ApplicationException;
import com.tangotab.util.TangotabConstants;
import com.tangotab.web.form.CommissionForm;

public class CommissionAction extends BaseDispatchAction {
	public static Logger log = LoggerFactory.getLogger(CommissionAction.class);
	private CommissionBO commissionBo = com.tangotab.businessImpl.BusinessFactory.getCommissionBO();

	public ActionForward Update(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		CommissionForm commissionForm = (CommissionForm) form;
		CommissionRate commission = new CommissionRate();
		ActionMessages messages = new ActionMessages();
		try {

			commission.setCommissionRateId(commissionForm.getCommissionRateId());
			commission.setCommissionManager(commissionForm.getCommissionManager());
			commission.setPercentOnNewSale(commissionForm.getPercentOnNewSale());
			commission.setPersonOnRenewalSale(commissionForm.getPercentOnRenewalSale());

			commission.setFlatCommissionAmount(commissionForm.getFlatCommissionAmount());
			commission.setCommissionRateId(1);
		} catch (Exception e) {
			messages.add("message", new ActionMessage("errors.misc", "Copy Properties Failed"));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		try {
			commissionBo.updateCommission(commission);
		} catch (ApplicationException e) {

			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		return mapping.findForward(TangotabConstants.SUCCESS);

	}

	public ActionForward display(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String result = "success";
		ActionMessages messages = new ActionMessages();
		CommissionForm commissionForm = (CommissionForm) form;
		try {

			CommissionRate commission = commissionBo.getCommission();
			commissionForm.setCommissionRateId(commission.getCommissionRateId());
			commissionForm.setCommissionManager(commission.getCommissionManager());
			commissionForm.setPercentOnNewSale(commission.getPercentOnNewSale());
			commissionForm.setPercentOnRenewalSale(commission.getPersonOnRenewalSale());

			commissionForm.setFlatCommissionAmount(commission.getFlatCommissionAmount());
			commissionForm.setCommissionRateId(commission.getCommissionRateId());

		} catch (ApplicationException e) {

			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(e.getCode()));
			saveMessages(request, messages);
			return mapping.findForward(TangotabConstants.FAILURE);
		}
		
		return mapping.findForward(result);
	}
	
	public ActionForward Cancel(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		return mapping.findForward("cancel");
	}

}
