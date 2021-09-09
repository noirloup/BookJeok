package usedshop.model.vo;

public class Trade implements java.io.Serializable {
	private static final long serialVersionUID = 120L;
	
	private int buyCd;
	private int nMarketCd;
	private int aMarketCd;
	private String userBuyerId;
	private String payMethod;
	private String receiptCd;
	private String addPhone;
	private String shipAddr;
	private String returnAddr;
	private String useStatus;
	private int beforePoint;
	private int usingPoint;
	private int afterPoint;
	
	public Trade() {}

	public Trade(int buyCd, int nMarketCd, String payMethod, String receiptCd, String addPhone, String returnAddr,
			String useStatus, int beforePoint, int usingPoint, int afterPoint) {
		super();
		this.buyCd = buyCd;
		this.nMarketCd = nMarketCd;
		this.payMethod = payMethod;
		this.receiptCd = receiptCd;
		this.addPhone = addPhone;
		this.returnAddr = returnAddr;
		this.useStatus = useStatus;
		this.beforePoint = beforePoint;
		this.usingPoint = usingPoint;
		this.afterPoint = afterPoint;
	}

	public Trade(int buyCd, int nMarketCd, int aMarketCd, String userBuyerId, String payMethod, String receiptCd,
			String addPhone, String shipAddr, String returnAddr, String useStatus, int beforePoint, int usingPoint,
			int afterPoint) {
		super();
		this.buyCd = buyCd;
		this.nMarketCd = nMarketCd;
		this.aMarketCd = aMarketCd;
		this.userBuyerId = userBuyerId;
		this.payMethod = payMethod;
		this.receiptCd = receiptCd;
		this.addPhone = addPhone;
		this.shipAddr = shipAddr;
		this.returnAddr = returnAddr;
		this.useStatus = useStatus;
		this.beforePoint = beforePoint;
		this.usingPoint = usingPoint;
		this.afterPoint = afterPoint;
	}

	public int getBuyCd() {
		return buyCd;
	}

	public void setBuyCd(int buyCd) {
		this.buyCd = buyCd;
	}

	public int getnMarketCd() {
		return nMarketCd;
	}

	public void setnMarketCd(int nMarketCd) {
		this.nMarketCd = nMarketCd;
	}

	public int getaMarketCd() {
		return aMarketCd;
	}

	public void setaMarketCd(int aMarketCd) {
		this.aMarketCd = aMarketCd;
	}

	public String getUserBuyerId() {
		return userBuyerId;
	}

	public void setUserBuyerId(String userBuyerId) {
		this.userBuyerId = userBuyerId;
	}

	public String getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}

	public String getReceiptCd() {
		return receiptCd;
	}

	public void setReceiptCd(String receiptCd) {
		this.receiptCd = receiptCd;
	}

	public String getAddPhone() {
		return addPhone;
	}

	public void setAddPhone(String addPhone) {
		this.addPhone = addPhone;
	}

	public String getShipAddr() {
		return shipAddr;
	}

	public void setShipAddr(String shipAddr) {
		this.shipAddr = shipAddr;
	}

	public String getReturnAddr() {
		return returnAddr;
	}

	public void setReturnAddr(String returnAddr) {
		this.returnAddr = returnAddr;
	}

	public String getUseStatus() {
		return useStatus;
	}

	public void setUseStatus(String useStatus) {
		this.useStatus = useStatus;
	}

	public int getBeforePoint() {
		return beforePoint;
	}

	public void setBeforePoint(int beforePoint) {
		this.beforePoint = beforePoint;
	}

	public int getUsingPoint() {
		return usingPoint;
	}

	public void setUsingPoint(int usingPoint) {
		this.usingPoint = usingPoint;
	}

	public int getAfterPoint() {
		return afterPoint;
	}

	public void setAfterPoint(int afterPoint) {
		this.afterPoint = afterPoint;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Trade [buyCd=" + buyCd + ", nMarketCd=" + nMarketCd + ", aMarketCd=" + aMarketCd + ", userBuyerId="
				+ userBuyerId + ", payMethod=" + payMethod + ", receiptCd=" + receiptCd + ", addPhone=" + addPhone
				+ ", shipAddr=" + shipAddr + ", returnAddr=" + returnAddr + ", useStatus=" + useStatus
				+ ", beforePoint=" + beforePoint + ", usingPoint=" + usingPoint + ", afterPoint=" + afterPoint + "]";
	}
	
}
