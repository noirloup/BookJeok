package usedshop.model.vo;

import java.sql.Date;

public class UsedShopAuctionSelect implements java.io.Serializable {
	private static final long serialVersionUID = 121L;
	
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
	
	private int bookId;
	private int bookCateCd;
	private String bookCategory;
	private int bookTypeNum;
	private String bookType;
	private int bookLocNum;
	private String bookimg;
	private String bookLocation;
	private String bookNm;
	private int isbn;
	private int ranking;
	private String bookIntro;
	private String author;
	private String authorIntro;
	private int bookPrice;
	private int avgScore;
	private String publisher;
	private java.sql.Date publishDate;
	private String bookIndex;
	
	private String userId;
	private String nickName;
	private String userPwd;
	private String userNm;
	private String gender;
	private int age;
	private String phone;
	private String email;
	private String addr;
	private String addrDetail;
	private int point;
	private String userIntro;
	private String preferred;
	private String userRank;
	private String admin;
	
	public UsedShopAuctionSelect() {}

	public UsedShopAuctionSelect(int aMarketCd, int aTypeNum, String userWriterId, int usedBookId, int startBid,
			int bidCount, int currentBid, Date aRegDate, Date aCloseDate, String saleState, int saleFin,
			String aUsedBookIntro, String aQuality, String bidUserId, int bookId, int bookCateCd, String bookCategory,
			int bookTypeNum, String bookType, int bookLocNum, String bookimg, String bookLocation, String bookNm,
			int isbn, int ranking, String bookIntro, String author, String authorIntro, int bookPrice, int avgScore,
			String publisher, Date publishDate, String bookIndex, String userId, String nickName, String userPwd,
			String userNm, String gender, int age, String phone, String email, String addr, String addrDetail,
			int point, String userIntro, String preferred, String userRank, String admin) {
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
		this.bookId = bookId;
		this.bookCateCd = bookCateCd;
		this.bookCategory = bookCategory;
		this.bookTypeNum = bookTypeNum;
		this.bookType = bookType;
		this.bookLocNum = bookLocNum;
		this.bookimg = bookimg;
		this.bookLocation = bookLocation;
		this.bookNm = bookNm;
		this.isbn = isbn;
		this.ranking = ranking;
		this.bookIntro = bookIntro;
		this.author = author;
		this.authorIntro = authorIntro;
		this.bookPrice = bookPrice;
		this.avgScore = avgScore;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.bookIndex = bookIndex;
		this.userId = userId;
		this.nickName = nickName;
		this.userPwd = userPwd;
		this.userNm = userNm;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.addr = addr;
		this.addrDetail = addrDetail;
		this.point = point;
		this.userIntro = userIntro;
		this.preferred = preferred;
		this.userRank = userRank;
		this.admin = admin;
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

	public String getBidUserId() {
		return bidUserId;
	}

	public void setBidUserId(String bidUserId) {
		this.bidUserId = bidUserId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getBookCateCd() {
		return bookCateCd;
	}

	public void setBookCateCd(int bookCateCd) {
		this.bookCateCd = bookCateCd;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public int getBookTypeNum() {
		return bookTypeNum;
	}

	public void setBookTypeNum(int bookTypeNum) {
		this.bookTypeNum = bookTypeNum;
	}

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	public int getBookLocNum() {
		return bookLocNum;
	}

	public void setBookLocNum(int bookLocNum) {
		this.bookLocNum = bookLocNum;
	}

	public String getBookimg() {
		return bookimg;
	}

	public void setBookimg(String bookimg) {
		this.bookimg = bookimg;
	}

	public String getBookLocation() {
		return bookLocation;
	}

	public void setBookLocation(String bookLocation) {
		this.bookLocation = bookLocation;
	}

	public String getBookNm() {
		return bookNm;
	}

	public void setBookNm(String bookNm) {
		this.bookNm = bookNm;
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getBookIntro() {
		return bookIntro;
	}

	public void setBookIntro(String bookIntro) {
		this.bookIntro = bookIntro;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthorIntro() {
		return authorIntro;
	}

	public void setAuthorIntro(String authorIntro) {
		this.authorIntro = authorIntro;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(int avgScore) {
		this.avgScore = avgScore;
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

	public String getBookIndex() {
		return bookIndex;
	}

	public void setBookIndex(String bookIndex) {
		this.bookIndex = bookIndex;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getAddrDetail() {
		return addrDetail;
	}

	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getUserIntro() {
		return userIntro;
	}

	public void setUserIntro(String userIntro) {
		this.userIntro = userIntro;
	}

	public String getPreferred() {
		return preferred;
	}

	public void setPreferred(String preferred) {
		this.preferred = preferred;
	}

	public String getUserRank() {
		return userRank;
	}

	public void setUserRank(String userRank) {
		this.userRank = userRank;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
