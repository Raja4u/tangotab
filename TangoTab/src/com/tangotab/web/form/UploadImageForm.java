package com.tangotab.web.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;


public class UploadImageForm extends  ActionForm {
	
	private FormFile wakaImages;

	public void setWakaImages(FormFile wakaImages) {
		this.wakaImages = wakaImages;
	}

	public FormFile getWakaImages() {
		return wakaImages;
	}

	
	

}
