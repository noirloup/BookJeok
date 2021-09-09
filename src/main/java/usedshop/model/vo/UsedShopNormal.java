package usedshop.model.vo;

import java.sql.Date;

public class UsedShopNormal implements java.io.Serializable {
	private static final long serialVersionUID = 112L;
	
	private int nMarketCd;
	private int nTypeNum;
	private String userWriterId;
	private int usedBookId;
	private int price;
	private java.sql.Date nRegDate;
	private int regCount;
	private int saleCount;
	private String nUsedBookIntro;
	private String nQuality;
	
	public UsedShopNormal() {}

	public UsedShopNormal(int nMarketCd, int nTypeNum, String userWriterId, int usedBookId, int price, Date nRegDate,
			int regCount, int saleCount, String nUsedBookIntro, String nQuality) {
		super();
		this.nMarketCd = nMarketCd;
		this.nTypeNum = nTypeNum;
		this.userWriterId = userWriterId;
		this.usedBookId = usedBookId;
		this.price = price;
		this.nRegDate = nRegDate;
		this.regCount = regCount;
		this.saleCount = saleCount;
		this.nUsedBookIntro = nUsedBookIntro;
		this.nQuality = nQuality;
	}

	public int getnMarketCd() {
		return nMarketCd;
	}

	public void setnMarketCd(int nMarketCd) {
		this.nMarketCd = nMarketCd;
	}

	public int getnTypeNum() {
		return nTypeNum;
	}

	public void setnTypeNum(int nTypeNum) {
		this.nTypeNum = nTypeNum;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public java.sql.Date getnRegDate() {
		return nRegDate;
	}

	public void setnRegDate(java.sql.Date nRegDate) {
		this.nRegDate = nRegDate;
	}

	public int getRegCount() {
		return regCount;
	}

	public void setRegCount(int regCount) {
		this.regCount = regCount;
	}

	public int getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}

	public String getnUsedBookIntro() {
		return nUsedBookIntro;
	}

	public void setnUsedBookIntro(String nUsedBookIntro) {
		this.nUsedBookIntro = nUsedBookIntro;
	}

	public String getnQuality() {
		return nQuality;
	}

	public void setnQuality(String nQuality) {
		this.nQuality = nQuality;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UsedShopNormal [nMarketCd=" + nMarketCd + ", nTypeNum=" + nTypeNum + ", userWriterId=" + userWriterId
				+ ", usedBookId=" + usedBookId + ", price=" + price + ", nRegDate=" + nRegDate + ", regCount="
				+ regCount + ", saleCount=" + saleCount + ", nUsedBookIntro=" + nUsedBookIntro + ", nQuality="
				+ nQuality + "]";
	}
	
}
