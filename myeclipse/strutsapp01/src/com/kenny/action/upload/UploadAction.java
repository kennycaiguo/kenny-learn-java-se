package com.kenny.action.upload;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport{
	
     private File file1;
     private String file1Filename;
     private String file1ContentType;
     
	public void setFile1(File file1) {
		this.file1 = file1;
	}
	public void setFile1Filename(String file1Filename) {
		this.file1Filename = file1Filename;
	}
	public void setFile1ContentType(String file1ContentType) {
		this.file1ContentType = file1ContentType;
	}
	
	@Override
	public String execute() throws Exception {
		 System.out.println("upload.excute()");
     	 return SUCCESS;
	}
	
	 
//     public String excute() {
//    	
//     }
}
