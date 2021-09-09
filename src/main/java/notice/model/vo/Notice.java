package notice.model.vo;

import java.sql.Date;

public class Notice implements java.io.Serializable {
	private static final long serialVersionUID = 114L;
	
	private int noticeNum;
	private String noticeWriterId;
	private String noticeTitle;
	private String noticeOriginalFile;
	private String noticeRenameFile;
	private String noticeContent;
	private String noticeGroup;
	private java.sql.Date noticeRegDate;
	private java.sql.Date noticeModifyDate;
	private int viewCount;
	
	public Notice() {}

	public int getNoticeNum() {
		return noticeNum;
	}

	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}

	public String getNoticeWriterId() {
		return noticeWriterId;
	}

	public void setNoticeWriterId(String noticeWriterId) {
		this.noticeWriterId = noticeWriterId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeOriginalFile() {
		return noticeOriginalFile;
	}

	public void setNoticeOriginalFile(String noticeOriginalFile) {
		this.noticeOriginalFile = noticeOriginalFile;
	}

	public String getNoticeRenameFile() {
		return noticeRenameFile;
	}

	public void setNoticeRenameFile(String noticeRenameFile) {
		this.noticeRenameFile = noticeRenameFile;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeGroup() {
		return noticeGroup;
	}

	public void setNoticeGroup(String noticeGroup) {
		this.noticeGroup = noticeGroup;
	}

	public java.sql.Date getNoticeRegDate() {
		return noticeRegDate;
	}

	public void setNoticeRegDate(java.sql.Date noticeRegDate) {
		this.noticeRegDate = noticeRegDate;
	}

	public java.sql.Date getNoticeModifyDate() {
		return noticeModifyDate;
	}

	public void setNoticeModifyDate(java.sql.Date noticeModifyDate) {
		this.noticeModifyDate = noticeModifyDate;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Notice [noticeNum=" + noticeNum + ", noticeWriterId=" + noticeWriterId + ", noticeTitle=" + noticeTitle
				+ ", noticeOriginalFile=" + noticeOriginalFile + ", noticeRenameFile=" + noticeRenameFile
				+ ", noticeContent=" + noticeContent + ", noticeGroup=" + noticeGroup + ", noticeRegDate="
				+ noticeRegDate + ", noticeModifyDate=" + noticeModifyDate + ", viewCount=" + viewCount + "]";
	}

	public Notice(int noticeNum, String noticeWriterId, String noticeTitle, String noticeContent, String noticeGroup,
			Date noticeRegDate, int viewCount) {
		super();
		this.noticeNum = noticeNum;
		this.noticeWriterId = noticeWriterId;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
		this.noticeGroup = noticeGroup;
		this.noticeRegDate = noticeRegDate;
		this.viewCount = viewCount;
	}

	public Notice(int noticeNum, String noticeWriterId, String noticeTitle, String noticeOriginalFile,
			String noticeRenameFile, String noticeContent, String noticeGroup, Date noticeRegDate,
			Date noticeModifyDate, int viewCount) {
		super();
		this.noticeNum = noticeNum;
		this.noticeWriterId = noticeWriterId;
		this.noticeTitle = noticeTitle;
		this.noticeOriginalFile = noticeOriginalFile;
		this.noticeRenameFile = noticeRenameFile;
		this.noticeContent = noticeContent;
		this.noticeGroup = noticeGroup;
		this.noticeRegDate = noticeRegDate;
		this.noticeModifyDate = noticeModifyDate;
		this.viewCount = viewCount;
	}

}
