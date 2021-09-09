package user.model.vo;

public class User implements java.io.Serializable {
	private static final long serialVersionUID = 111L;
	
	private String userId;
	private String nickName;
	private String userPwd;
	private String userNm;
	private String gender;
	private int age;
	private String phone;
	private String email;
	private int post;
	private String addr;
	private String addrDetail;
	private int point;
	private String userIntro;
	private String preferred;
	private String userRank;
	private String admin;
	
	public User() {}

	public User(String userId, String nickName, String userPwd, String userNm, String gender, int age, String phone,
			String email, String userRank, String admin) {
		super();
		this.userId = userId;
		this.nickName = nickName;
		this.userPwd = userPwd;
		this.userNm = userNm;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.userRank = userRank;
		this.admin = admin;
	}

	public User(String userId, String nickName, String userPwd, String userNm, String gender, int age, String phone,
			String email, int post, String addr, String addrDetail, int point, String userIntro, String preferred, 
			String userRank, String admin) {
		super();
		this.userId = userId;
		this.nickName = nickName;
		this.userPwd = userPwd;
		this.userNm = userNm;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
		this.post = post;
		this.addr = addr;
		this.addrDetail = addrDetail;
		this.point = point;
		this.userIntro = userIntro;
		this.preferred = preferred;
		this.userRank = userRank;
		this.admin = admin;
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

	public int getPost() {
		return post;
	}

	public void setPost(int post) {
		this.post = post;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPreferred() {
		return preferred;
	}

	public void setPreferred(String preferred) {
		this.preferred = preferred;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", nickName=" + nickName + ", userPwd=" + userPwd + ", userNm=" + userNm
				+ ", gender=" + gender + ", age=" + age + ", phone=" + phone + ", email=" + email + ", addr=" + addr
				+ ", addrDetail=" + addrDetail + ", point=" + point + ", userIntro=" + userIntro + ", preferred="
				+ preferred + ", userRank=" + userRank + ", admin=" + admin + "]";
	}
	
}
