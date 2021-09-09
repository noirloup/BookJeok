package ask.model.vo;

import java.sql.Date;

public class Ask implements java.io.Serializable {
	private static final long serialVersionUID = 116L;
	
	private int AskNum;
	private String AskWriterId;
	private String AskGroup;
	private String AskTitle;
	private String AskContent;
	private String AskState;
	private String AskOriginalFile;
	private String AskRenameFile;
	private String answerContent;
	private String AnswerID;
	private java.sql.Date writeDate;
	private java.sql.Date answerDate;
	
	public Ask() {}

	public Ask(int AskNum, String AskWriterId, String AskGroup, String AskTitle, String AskContent, String AskState,
			Date writeDate) {
		super();
		this.AskNum = AskNum;
		this.AskWriterId = AskWriterId;
		this.AskGroup = AskGroup;
		this.AskTitle = AskTitle;
		this.AskContent = AskContent;
		this.AskState = AskState;
		this.writeDate = writeDate;
	}

	public Ask(int AskNum, String AskWriterId, String AskGroup, String AskTitle, String AskContent, String AskState,
			String AskOriginalFile, String AskRenameFile, String answerContent, Date writeDate, Date answerDate) {
		super();
		this.AskNum = AskNum;
		this.AskWriterId = AskWriterId;
		this.AskGroup = AskGroup;
		this.AskTitle = AskTitle;
		this.AskContent = AskContent;
		this.AskState = AskState;
		this.AskOriginalFile = AskOriginalFile;
		this.AskRenameFile = AskRenameFile;
		this.answerContent = answerContent;
		this.writeDate = writeDate;
		this.answerDate = answerDate;
	}
	
	public String getAnswerID() {
		return AnswerID;
	}

	public void setAnswerID(String answerID) {
		AnswerID = answerID;
	}

	public int getAskNum() {
		return AskNum;
	}

	public void setAskNum(int askNum) {
		AskNum = askNum;
	}

	public String getAskWriterId() {
		return AskWriterId;
	}

	public void setAskWriterId(String askWriterId) {
		AskWriterId = askWriterId;
	}

	public String getAskGroup() {
		return AskGroup;
	}

	public void setAskGroup(String askGroup) {
		AskGroup = askGroup;
	}

	public String getAskTitle() {
		return AskTitle;
	}

	public void setAskTitle(String askTitle) {
		AskTitle = askTitle;
	}

	public String getAskContent() {
		return AskContent;
	}

	public void setAskContent(String askContent) {
		AskContent = askContent;
	}

	public String getAskState() {
		return AskState;
	}

	public void setAskState(String askState) {
		AskState = askState;
	}

	public String getAskOriginalFile() {
		return AskOriginalFile;
	}

	public void setAskOriginalFile(String askOriginalFile) {
		AskOriginalFile = askOriginalFile;
	}

	public String getAskRenameFile() {
		return AskRenameFile;
	}

	public void setAskRenameFile(String askRenameFile) {
		AskRenameFile = askRenameFile;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public java.sql.Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(java.sql.Date writeDate) {
		this.writeDate = writeDate;
	}

	public java.sql.Date getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(java.sql.Date answerDate) {
		this.answerDate = answerDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Ask [AskNum=" + AskNum + ", AskWriterId=" + AskWriterId + ", AskGroup=" + AskGroup + ", AskTitle="
				+ AskTitle + ", AskContent=" + AskContent + ", AskState=" + AskState + ", AskOriginalFile="
				+ AskOriginalFile + ", AskRenameFile=" + AskRenameFile + ", answerContent=" + answerContent
				+ ", AnswerID=" + AnswerID + ", writeDate=" + writeDate + ", answerDate=" + answerDate + "]";
	}
	
	
	
}
