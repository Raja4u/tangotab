package com.tangotab.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.tangotab.util.ImageSaveUtility;
import com.tangotab.web.form.UploadImageForm;

 public class UploadImageAction extends Action{
	 public ActionForward execute(ActionMapping mapping, ActionForm form,
			                      HttpServletRequest request, HttpServletResponse response)  {
		
		try{
		String directionImgRealPath = getServlet().getServletContext().getRealPath("/")
		+ "waka/images/";
	
		UploadImageForm imageForm=(UploadImageForm)form;
		ImageSaveUtility.saveFile(directionImgRealPath, imageForm.getWakaImages());
				System.out.println(directionImgRealPath); 
				
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	request.setAttribute("uploaded", "Image Uploaded Successfully");
	 return mapping.findForward("success");
	}
}
