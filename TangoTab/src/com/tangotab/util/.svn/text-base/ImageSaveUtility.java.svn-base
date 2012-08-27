package com.tangotab.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.struts.upload.FormFile;

public class ImageSaveUtility {

	public static String saveFile(String imageSubPath, FormFile image, String type) {

		String fileName = "rest";
		String requiredPath = "../images/";
		try {
			String currentTimeStamp = DateConverterUtility.getUniqueStamp();

			if (type.equals("restLocation")) {
				type += "location";
				requiredPath += "client/";
			} else if (type.equals("restLocationImg")) {
				type += "locationImg";
				requiredPath += "client/";
			} else if (type.equals("restLocationDeal")) {
				type += "locationDeal";
				requiredPath += "deal/";
			} else if (type.equals("adminDeal")) {
				type += "adminDeal";
				requiredPath += "deal/";
			}
			fileName += currentTimeStamp;

			fileName += image.getFileName();
			if (!fileName.equals("")) {
				File fileToCreate = new File(imageSubPath, fileName);

				if (fileToCreate.exists()) {
					fileToCreate.delete();
					fileToCreate = new File(imageSubPath, fileName);
				}
				FileOutputStream fileOutStream = new FileOutputStream(fileToCreate);
				fileOutStream.write(image.getFileData());
				fileOutStream.flush();
				fileOutStream.close();
			}
		} catch (FileNotFoundException file) {
			file.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}
		return requiredPath + fileName;
	}

	public static String saveFile(String imagePath, FormFile image) {

		String fileName ="waka_score.png";
		String requiredPath =imagePath;
		try {
						 			
			//fileName += "waka_score.png";
			if (!fileName.equals("")) {
				File fileToCreate = new File(imagePath, fileName);

				if (fileToCreate.exists()) {
					fileToCreate.delete();
					fileToCreate = new File(imagePath, fileName);
				}
				FileOutputStream fileOutStream = new FileOutputStream(fileToCreate);
				fileOutStream.write(image.getFileData());
				fileOutStream.flush();
				fileOutStream.close();
			}
		} catch (FileNotFoundException file) {
			file.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		}
		return requiredPath + fileName;
	}
	
	
}
