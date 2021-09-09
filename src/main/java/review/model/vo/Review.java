package review.model.vo;

import java.sql.Date;

public class Review implements java.io.Serializable { 
	private static final long serialVersionUID = 113L;

	private int reviewCd;
	private String reviewWriterId;
	private int reviewBookId;
	private String reviewName;
	private java.sql.Date reviewRegDate;
	private java.sql.Date reviewModifyDate;
	private String reviewOriginalFile;
	private String reviewRenameFile;
	private String reviewContent;
	private int score;
	private String keyword;
	private String bookImg;
	private String bookNm;

	public Review() {
	}

	public Review(int reviewCd, String reviewWriterId, int reviewBookId, String reviewName, Date reviewRegDate,
			String reviewContent, int score, String bookImg, String bookNm) {
		super();
		this.reviewCd = reviewCd;
		this.reviewWriterId = reviewWriterId;
		this.reviewBookId = reviewBookId;
		this.reviewName = reviewName;
		this.reviewRegDate = reviewRegDate;
		this.reviewContent = reviewContent;
		this.score = score;
		this.bookImg = bookImg;
		this.bookNm = bookNm;
	}

	public Review(int reviewCd, String reviewWriterId, int reviewBookId, String reviewName, Date reviewRegDate,
			Date reviewModifyDate, String reviewOriginalFile, String reviewRenameFile, String reviewContent, int score,
			String keyword, String bookImg, String bookNm) {
		super();
		this.reviewCd = reviewCd;
		this.reviewWriterId = reviewWriterId;
		this.reviewBookId = reviewBookId;
		this.reviewName = reviewName;
		this.reviewRegDate = reviewRegDate;
		this.reviewModifyDate = reviewModifyDate;
		this.reviewOriginalFile = reviewOriginalFile;
		this.reviewRenameFile = reviewRenameFile;
		this.reviewContent = reviewContent;
		this.score = score;
		this.keyword = keyword;
		this.bookImg = bookImg;
		this.bookNm = bookNm;
	}

	public int getReviewCd() {
		return reviewCd;
	}

	public void setReviewCd(int reviewCd) {
		this.reviewCd = reviewCd;
	}

	public String getReviewWriterId() {
		return reviewWriterId;
	}

	public void setReviewWriterId(String reviewWriterId) {
		this.reviewWriterId = reviewWriterId;
	}

	public int getReviewBookId() {
		return reviewBookId;
	}

	public void setReviewBookId(int reviewBookId) {
		this.reviewBookId = reviewBookId;
	}

	public String getReviewName() {
		return reviewName;
	}

	public void setReviewName(String reviewName) {
		this.reviewName = reviewName;
	}

	public java.sql.Date getReviewRegDate() {
		return reviewRegDate;
	}

	public void setReviewRegDate(java.sql.Date reviewRegDate) {
		this.reviewRegDate = reviewRegDate;
	}

	public java.sql.Date getReviewModifyDate() {
		return reviewModifyDate;
	}

	public void setReviewModifyDate(java.sql.Date reviewModifyDate) {
		this.reviewModifyDate = reviewModifyDate;
	}

	public String getReviewOriginalFile() {
		return reviewOriginalFile;
	}

	public void setReviewOriginalFile(String reviewOriginalFile) {
		this.reviewOriginalFile = reviewOriginalFile;
	}

	public String getReviewRenameFile() {
		return reviewRenameFile;
	}

	public void setReviewRenameFile(String reviewRenameFile) {
		this.reviewRenameFile = reviewRenameFile;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBookImg() {
		return bookImg;
	}

	public void setBookImg(String bookImg) {
		this.bookImg = bookImg;
	}

	public String getBookNm() {
		return bookNm;
	}

	public void setBookNm(String bookNm) {
		this.bookNm = bookNm;
	}

	@Override
	public String toString() {
		return "Review [reviewCd=" + reviewCd + ", reviewWriterId=" + reviewWriterId + ", reviewBookId=" + reviewBookId
				+ ", reviewName=" + reviewName + ", reviewRegDate=" + reviewRegDate + ", reviewModifyDate="
				+ reviewModifyDate + ", reviewOriginalFile=" + reviewOriginalFile + ", reviewRenameFile="
				+ reviewRenameFile + ", reviewContent=" + reviewContent + ", score=" + score + ", keyword=" + keyword
				+ ", bookImg=" + bookImg + ", bookNm=" + bookNm + "]";
	}




	

	
}
