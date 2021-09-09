package review.model.vo;

import java.sql.Date;
import java.util.ArrayList;

public class ReviewList implements java.io.Serializable {
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
	private String bookNm;
	private String author;
	private String publisher;
	private java.sql.Date publishDate;
	private double avgScore;
	private int bookTypeNum;
	
	public ReviewList() {}
	
	public ReviewList(int reviewCd, String reviewWriterId, int reviewBookId, String reviewName, Date reviewRegDate,
			String reviewContent, int score) {
		super();
		this.reviewCd = reviewCd;
		this.reviewWriterId = reviewWriterId;
		this.reviewBookId = reviewBookId;
		this.reviewName = reviewName;
		this.reviewRegDate = reviewRegDate;
		this.reviewContent = reviewContent;
		this.score = score;
	}

	public ReviewList(int reviewCd, String reviewWriterId, int reviewBookId, String reviewName, Date reviewRegDate,
			Date reviewModifyDate, String reviewOriginalFile, String reviewRenameFile, String reviewContent, int score,
			String keyword, String bookNm, String author, String publisher, Date publishDate, double avgScore, int bookTypeNum) {
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
		this.bookNm = bookNm;
		this.author = author;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.avgScore = avgScore;
		this.bookTypeNum = bookTypeNum;
		
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

	public String getBookNm() {
		return bookNm;
	}

	public void setBookNm(String bookNm) {
		this.bookNm = bookNm;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public java.sql.Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(java.sql.Date publishDate) {
		this.publishDate = publishDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}

	public int getBookTypeNum() {
		return bookTypeNum;
	}

	public void setBookTypeNum(int bookTypeNum) {
		this.bookTypeNum = bookTypeNum;
	}

	@Override
	public String toString() {
		return "ReviewList [reviewCd=" + reviewCd + ", reviewWriterId=" + reviewWriterId + ", reviewBookId="
				+ reviewBookId + ", reviewName=" + reviewName + ", reviewRegDate=" + reviewRegDate
				+ ", reviewModifyDate=" + reviewModifyDate + ", reviewOriginalFile=" + reviewOriginalFile
				+ ", reviewRenameFile=" + reviewRenameFile + ", reviewContent=" + reviewContent + ", score=" + score
				+ ", keyword=" + keyword + ", bookNm=" + bookNm + ", author=" + author + ", publisher=" + publisher
				+ ", publishDate=" + publishDate + ", avgScore=" + avgScore + ", bookTypeNum=" + bookTypeNum
				+ ", getReviewCd()=" + getReviewCd() + ", getReviewWriterId()=" + getReviewWriterId()
				+ ", getReviewBookId()=" + getReviewBookId() + ", getReviewName()=" + getReviewName()
				+ ", getReviewRegDate()=" + getReviewRegDate() + ", getReviewModifyDate()=" + getReviewModifyDate()
				+ ", getReviewOriginalFile()=" + getReviewOriginalFile() + ", getReviewRenameFile()="
				+ getReviewRenameFile() + ", getReviewContent()=" + getReviewContent() + ", getScore()=" + getScore()
				+ ", getKeyword()=" + getKeyword() + ", getBookNm()=" + getBookNm() + ", getAuthor()=" + getAuthor()
				+ ", getPublisher()=" + getPublisher() + ", getPublishDate()=" + getPublishDate() + ", getAvgScore()="
				+ getAvgScore() + ", getBookTypeNum()=" + getBookTypeNum() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


	
	
}
