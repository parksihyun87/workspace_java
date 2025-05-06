package dbpackage;

import java.sql.Date;

public class User {
//    유저 tbl의 레코드 하나를 가져올 객체를 클래스로 정의할 예정
    private String userId;
    private String userName;
    private int birthYear;
    private String addr;
    private String mobile1;
    private String mobile2;
    private int height;
    private Date mdate;

    public User(String userId, String userName, int birthYear, String addr, String mobile1, String mobile2, int height, Date mdate) {
        this.userId = userId;
        this.userName = userName;
        this.birthYear = birthYear;
        this.addr = addr;
        this.mobile1 = mobile1;
        this.mobile2 = mobile2;
        this.height = height;
        this.mdate = mdate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Date getMdate() {
        return mdate;
    }

    public void setMdate(Date mdate) {
        this.mdate = mdate;
    }
}
