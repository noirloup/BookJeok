package usedshop.model.vo;

public class SaleType implements java.io.Serializable {
	private static final long serialVersionUID = 119L;
	
	private int typeNum;
	private String saleType;
	
	public SaleType() {}

	public SaleType(int typeNum, String saleType) {
		super();
		this.typeNum = typeNum;
		this.saleType = saleType;
	}

	public int getTypeNum() {
		return typeNum;
	}

	public void setTypeNum(int typeNum) {
		this.typeNum = typeNum;
	}
	
	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SaleType [typeNum=" + typeNum + ", saleType=" + saleType + "]";
	}
	
}
