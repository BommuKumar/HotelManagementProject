package com.naresh.Database.Entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class HotelMetaData {
	
	
	private String fileName;
	
	private String filePath;
	
	private long fileSize;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	 

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	 

	@Override
	public String toString() {
		return "HotelMetaData [fileName=" + fileName + ", filePath=" + filePath + ", fileSize=" + fileSize + "]";
	}

	public HotelMetaData() {
		super();
	}

	public HotelMetaData(String fileName, String filePath, long fileSize) {
		super();
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
	}
	
	

}
