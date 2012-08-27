package com.tangotab.web.form;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class AdminDealImageForm extends ActionForm {

	private Integer imageId;
	private String imagePath;
	private FormFile adminDealImage;
	private Integer nameId;
	private String name;

	public Integer getNameId() {
		return nameId;
	}

	public void setNameId(Integer nameId) {
		this.nameId = nameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FormFile getAdminDealImage() {
		return adminDealImage;
	}

	public void setAdminDealImage(FormFile adminDealImage) {
		this.adminDealImage = adminDealImage;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

}
