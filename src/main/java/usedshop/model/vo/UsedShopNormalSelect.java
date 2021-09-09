package usedshop.model.vo;

import java.sql.Date;

public class UsedShopNormalSelect implements java.io.Serializable {
	private static final long serialVersionUID = 122L;
	
	// UsedShopNormal vo
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
	
	// User vo
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
	
	// Book vo
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
	
	public UsedShopNormalSelect() {}

	public UsedShopNormalSelect(int nMarketCd, int nTypeNum, String userWriterId, int usedBookId, int price,
			Date nRegDate, int regCount, int saleCount, String nUsedBookIntro, String nQuality, String userId,
			String nickName, String userPwd, String userNm, String gender, int age, String phone, String email,
			String addr, String addrDetail, int point, String userIntro, String preferred, String userRank,
			String admin, int bookId, int bookCateCd, String bookCategory, int bookTypeNum, String bookType,
			int bookLocNum, String bookimg, String bookLocation, String bookNm, int isbn, int ranking, String bookIntro,
			String author, String authorIntro, int bookPrice, int avgScore, String publisher, Date publishDate,
			String bookIndex) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
