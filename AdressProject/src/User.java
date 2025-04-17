public class User {
    private String id;
    private String pw;
    private String name;
    private String phone;
    private String address;
    private boolean currentUser= false;

    public User(String id, String pw, String name, String phone, String address){
        this.id = id;
        this.pw = pw;
        this.name=name;
        this.phone=phone;
        this.address=address;
    }

    //읽기 부
    public String getId() {
        return this.id;
    }

    public String getPw() {
        return this.pw;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhone() {
        return this.phone;
    }

    public boolean isCurrentUser() {
        return this.currentUser;
    }

    //쓰기 부
    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCurrentUser() {
        this.currentUser = !currentUser;
    }
}
