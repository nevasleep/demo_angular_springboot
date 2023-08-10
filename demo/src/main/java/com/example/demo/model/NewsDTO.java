package com.example.demo.model;


public class NewsDTO {	

	private String vietnameseTitle;

	private String englishTitle;

	private String content;

	private String imageUrl;
	private int cateID;
	public String getVietnameseTitle() {
		return vietnameseTitle;
	}
	public void setVietnameseTitle(String vietnameseTitle) {
		this.vietnameseTitle = vietnameseTitle;
	}
	public String getEnglishTitle() {
		return englishTitle;
	}
	public void setEnglishTitle(String englishTitle) {
		this.englishTitle = englishTitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public NewsDTO(String vietnameseTitle, String englishTitle, String content, String imageUrl, int cateID) {
		super();
		this.vietnameseTitle = vietnameseTitle;
		this.englishTitle = englishTitle;
		this.content = content;
		this.imageUrl = imageUrl;
		this.cateID = cateID;
	}
	public NewsDTO() {
		super();
	}
	
}
