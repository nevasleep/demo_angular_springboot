package com.example.demo.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import jakarta.persistence.*;

//@NamedStoredProcedureQueries({
//		@NamedStoredProcedureQuery(name = "News.countTitle", procedureName = "COUNT_BY_TITLE", parameters = {
//				@StoredProcedureParameter(mode = ParameterMode.IN, name = "title", type = String.class),
//				@StoredProcedureParameter(mode = ParameterMode.OUT, name = "count_title", type = Integer.class) }),
//		
//		@NamedStoredProcedureQuery(name = "News.getAllNews", procedureName = "GET_ALL_NEWS", parameters = {
//				@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "outResult", type = Void.class) }) })

@Entity
@Table(name = "NEWS")
public class News {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "VIETNAMESE_TITLE")
	private String vietnameseTitle;

	@Column(name = "ENGLISH_TITLE")
	private String englishTitle;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "IMAGE_URL")
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;

	public News() {
	}

	public News(int id, String vietnameseTitle, String englishTitle, String content, String imageUrl,
			Category category) {
		super();
		this.id = id;
		this.vietnameseTitle = vietnameseTitle;
		this.englishTitle = englishTitle;
		this.content = content;
		this.imageUrl = imageUrl;
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public News(String vietnameseTitle, String englishTitle, String content, String imageUrl) {
		super();
		this.vietnameseTitle = vietnameseTitle;
		this.englishTitle = englishTitle;
		this.content = content;
		this.imageUrl = imageUrl;
//		this.categoryid = category;
	}

	public News(int id, String vietnameseTitle, String englishTitle, String content, String imageUrl) {
		super();
		this.id = id;
		this.vietnameseTitle = vietnameseTitle;
		this.englishTitle = englishTitle;
		this.content = content;
		this.imageUrl = imageUrl;
//		this.categoryid = category;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

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
	
//	public int getCategoryid() {
//		return categoryid;
//	}
//
//	public void setCategoryid(int categoryid) {
//		this.categoryid = categoryid;
//	}

	@Override
	public String toString() {
		return "News [id=" + id + ", vietnameseTitle=" + vietnameseTitle + ", englishTitle=" + englishTitle
				+ ", content=" + content + ", imageUrl=" + imageUrl + "]";
	}

}
