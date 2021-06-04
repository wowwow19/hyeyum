package com.hyeyum.domain;


import lombok.Data;

@Data
public class AttachFileDTO {
	private String fileName;
	private String uploadPath;
	private String uuid;
	private Boolean document;
	
	public String getDownloadPath() {
		return uploadPath + "/" + uuid + "_" + fileName;
	}
}
