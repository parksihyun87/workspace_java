public class Admin extends Person{
    // person에서 상속
    String pw;
    String phone;

    public Admin(String id,String pw) {
        this.id= id;
        this.pw = pw;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId(){
        return id;
    }

    public String getPw() {
        return this.pw;
    }

    public String getPhone() {
        return phone;
    }
}
