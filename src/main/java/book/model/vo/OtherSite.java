package book.model.vo;

public class OtherSite implements java.io.Serializable {
	private static final long serialVersionUID = 117L;
	
	private int siteCd;
	private int siteBookId;
	private String siteNm;
	private int sitePrice;
	
	public OtherSite() {}

	public OtherSite(int siteCd, int siteBookId, String siteNm, int sitePrice) {
		super();
		this.siteCd = siteCd;
		this.siteBookId = siteBookId;
		this.siteNm = siteNm;
		this.sitePrice = sitePrice;
	}

	public int getSiteCd() {
		return siteCd;
	}

	public void setSiteCd(int siteCd) {
		this.siteCd = siteCd;
	}

	public int getSiteBookId() {
		return siteBookId;
	}

	public void setSiteBookId(int siteBookId) {
		this.siteBookId = siteBookId;
	}

	public String getSiteNm() {
		return siteNm;
	}

	public void setSiteNm(String siteNm) {
		this.siteNm = siteNm;
	}

	public int getSitePrice() {
		return sitePrice;
	}

	public void setSitePrice(int sitePrice) {
		this.sitePrice = sitePrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OtherSite [siteCd=" + siteCd + ", siteBookId=" + siteBookId + ", siteNm=" + siteNm + ", sitePrice="
				+ sitePrice + "]";
	}
	
}
