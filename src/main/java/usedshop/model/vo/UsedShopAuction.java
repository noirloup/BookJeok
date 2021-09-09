package usedshop.model.vo;

import java.sql.Date;

public class UsedShopAuction implements java.io.Serializable {
	private static final long serialVersionUID = 118L;
	
	private int aMarketCd;
	private int aTypeNum;
	private String userWriterId;
	private int usedBookId;
	private int startBid;
	private int bidCount;
	private int currentBid;
	private java.sql.Date aRegDate;
	private java.sql.Date aCloseDate;
	private String saleState;
	private int saleFin;
	private String aUsedBookIntro;
	private String aQuality;
	private String bidUserId;
	
	public UsedShopAuction() {}

	public UsedShopAuction(int aMarketCd, int aTypeNum, String userWriterId, int usedBookId, int startBid, int bidCount, 
			int currentBid, Date aRegDate, Date aCloseDate, String saleState, int saleFin, String aUsedBookIntro,
			String aQuality, String bidUserId) {
		super();
		this.aMarketCd = aMarketCd;
		this.aTypeNum = aTypeNum;
		this.userWriterId = userWriterId;
		this.usedBookId = usedBookId;
		this.startBid = startBid;
		this.bidCount = bidCount;
		this.currentBid = currentBid;
		this.aRegDate = aRegDate;
		this.aCloseDate = aCloseDate;
		this.saleState = saleState;
		this.saleFin = saleFin;
		this.aUsedBookIntro = aUsedBookIntro;
		this.aQuality = aQuality;
		this.bidUserId = bidUserId;
	}

	public int getaMarketCd() {
		return aMarketCd;
	}

	public void setaMarketCd(int aMarketCd) {
		this.aMarketCd = aMarketCd;
	}

	public int getaTypeNum() {
		return aTypeNum;
	}

	public void setaTypeNum(int aTypeNum) {
		this.aTypeNum = aTypeNum;
	}

	public String getUserWriterId() {
		return userWriterId;
	}

	public void setUserWriterId(String userWriterId) {
		this.userWriterId = userWriterId;
	}

	public int getUsedBookId() {
		return usedBookId;
	}

	public void setUsedBookId(int usedBookId) {
		this.usedBookId = usedBookId;
	}

	public int getStartBid() {
		return startBid;
	}

	public void setStartBid(int startBid) {
		this.startBid = startBid;
	}

	public int getBidCount() {
		return bidCount;
	}

	public void setBidCount(int bidCount) {
		this.bidCount = bidCount;
	}

	public int getCurrentBid() {
		return currentBid;
	}

	public void setCurrentBid(int currentBid) {
		this.currentBid = currentBid;
	}

	public java.sql.Date getaRegDate() {
		return aRegDate;
	}

	public void setaRegDate(java.sql.Date aRegDate) {
		this.aRegDate = aRegDate;
	}

	public java.sql.Date getaCloseDate() {
		return aCloseDate;
	}

	public void setaCloseDate(java.sql.Date aCloseDate) {
		this.aCloseDate = aCloseDate;
	}

	public String getSaleState() {
		return saleState;
	}

	public void setSaleState(String saleState) {
		this.saleState = saleState;
	}

	public int getSaleFin() {
		return saleFin;
	}

	public void setSaleFin(int saleFin) {
		this.saleFin = saleFin;
	}

	public String getaUsedBookIntro() {
		return aUsedBookIntro;
	}

	public void setaUsedBookIntro(String aUsedBookIntro) {
		this.aUsedBookIntro = aUsedBookIntro;
	}

	public String getaQuality() {
		return aQuality;
	}

	public void setaQuality(String aQuality) {
		this.aQuality = aQuality;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getBidUserId() {
		return bidUserId;
	}

	public void setBidUserId(String bidUserId) {
		this.bidUserId = bidUserId;
	}

	@Override
	public String toString() {
		return "UsedShopAuction [aMarketCd=" + aMarketCd + ", aTypeNum=" + aTypeNum + ", userWriterId=" + userWriterId
				+ ", usedBookId=" + usedBookId + ", startBid=" + startBid + ", currentBid=" + currentBid + ", aRegDate="
				+ aRegDate + ", aCloseDate=" + aCloseDate + ", saleState=" + saleState + ", saleFin=" + saleFin
				+ ", aUsedBookIntro=" + aUsedBookIntro + ", aQuality=" + aQuality + "]";
	}
	
}
